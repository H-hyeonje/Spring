package com.spring.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spring.dto.BookDTO;



@Controller
@RequestMapping("/test")
public class controller {
	String json;
	Gson gs= new Gson();
	private int read;
	
	@GetMapping("/case1")
	public String index() {
		return "index";
	}
	
	//DTO -> JSON
	@ResponseBody
	@GetMapping("/project01")
	public String project01() {
		
		BookDTO dto=new BookDTO("자바",21000,"에어콘",670);
		System.out.println(dto.toString());
		json=gs.toJson(dto);
		System.out.println(json);
		return json;
	}
	
	//JSON ->DTO
	@GetMapping("/project02")
	public String project02() {
		BookDTO dto=gs.fromJson(json, BookDTO.class);
		System.out.println(dto.toString());
		return "index";
		
	}
	
	//(여러 DTO를 --> Arraylist) ---> JSON
	@ResponseBody
	@GetMapping("/project03")
	public String project03() {
		BookDTO dto1= new BookDTO("자바1",21000,"에어콘1",670);
		BookDTO dto2= new BookDTO("자바2",21000,"에어콘2",670);
		BookDTO dto3= new BookDTO("자바3",21000,"에어콘3",670);
		
		ArrayList<BookDTO> list =new ArrayList<BookDTO>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		String jsonList=gs.toJson(list);
		
		//json(ArrayList) --> ArrayList<BookDTO>
		ArrayList<BookDTO> jsontoList=gs.fromJson(jsonList,new TypeToken<ArrayList<BookDTO>>(){}.getType());
		
		for(int i=0;i<jsontoList.size();i++) {
			BookDTO tmp =jsontoList.get(i);
			System.out.println(tmp.toString());
		}
		
		
		
		return jsonList;
		
	}
	//JSON -JAVA(ORG>json)
	@GetMapping("/project04")
	public String project04() {
		
		JSONObject Student1=new JSONObject();
		Student1.put("name","홍길동");
		Student1.put("phone","010-1111-1111");
		Student1.put("address","서울");
		System.out.println(Student1);
		
		JSONObject Student2=new JSONObject();
		Student2.put("name","나길동");
		Student2.put("phone","010-2222-2222");
		Student2.put("address","광주");
		System.out.println(Student2);
		
		JSONArray Students=new JSONArray();
		Students.put(Student1);
		Students.put(Student2);
		
		JSONObject object=new JSONObject();
		object.put("Stusents", Students);
		
		System.out.println(object.toString(1));
		return "index";
	}
	
	@GetMapping("/project05")
	public String project05() {
		String client_id ="e4ptphrqyy";
		String client_secret ="2qGB2LMM6Nw8eV6UNf7xwKSmPyRgt2tv98zjzRRa";
		/* 키보드를 통하여 ImputStreamReader클래스를 통해 바이트 단위로 입력받고 라인단위로 읽기
		 위하서 버퍼리더를 연결함 */
		try {
			//Step 1 : 파라미터 확보하기 (검색할 주소정보를 콘솔로 확보)
			BufferedReader io=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("주소를 입력하세요 :");
			String address=io.readLine();
			/* 입력받는 문자열의 공백으로 인해서
			 * 데이터를 끝으로 인식하므로 
			 * UTF-8로 변경하여 %20으로 변환됨
			 * 즉 데이터 토큰이 공백을 통해서 판단됨
			 * */
			String addr=URLEncoder.encode(address,"utf-8");
			//Step 2 : URL 작성
			String reqUrl="https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+addr;
			URL url=new URL(reqUrl);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("x-ncp-apigw-api-key-id",client_id);
			con.setRequestProperty("x-ncp-apigw-api-key",client_secret);
			
			//Step 4: 요청 후 응답데이터 수신하기
			// 200 ok
			BufferedReader br;
			int responseCode=con.getResponseCode();
			if(responseCode==200) {
				br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
				
			//Step 5: 수신한 데이터 문자열 데이터로 변환하기
			String line;
			StringBuffer data=new StringBuffer();
			while((line=br.readLine())!=null) {
				data.append(line);
			}
			br.close();
			System.out.println(data);
				
			
			//Step 6: Json객체로 변환하기
			// 데이터 단위를 인식시키기 위해서 필요
			JSONTokener tok=new JSONTokener(data.toString());
			// {}
			JSONObject obj=new JSONObject(tok);
			System.out.println(obj.get("status"));
				// meta : {}
			JSONObject meta=obj.getJSONObject("meta");
			int totalCount = meta.getInt("totalCount");
			System.out.println(totalCount);
			JSONArray arr= obj.getJSONArray("addresses");
			JSONObject first=arr.getJSONObject(0);
			JSONArray arr2= first.getJSONArray("addressElements");
			String x=first.getString("x");
			String y=first.getString("y");
			System.out.println("경도"+x);
			System.out.println("위도"+y);
			JSONObject seven=arr2.getJSONObject(7);
			String longName=seven.getString("longName");
			String shortName=seven.getString("shortName");
			System.out.println(longName);
			System.out.println(shortName);
			getImage(x,y,addr);
			
			}
		}catch (Exception e) {e.printStackTrace();
			// TODO: handle exception
		}
		
		return "index";
	}
	
	
	public void getImage(String x,String y,String addr) {
		// step 1 : url 작성
		// https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?
		// w=300&
		// h=300&
		// center=127.1054221,37.3591614&
		// level=16
		// x-ncp-apigw-api-key-id: {API Key ID}
		// x-ncp-apigw-api-key: {API Key}'
		try {
			String url="https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
			url +="w=300&h=300&";
			url +="center="+x+","+y+"&";
			url +="level=16&";
			String pos = URLEncoder.encode(x+" "+y,"UTF-8");
			url += "markers=type:t|size:mid|pos:"+pos+"|label:"+URLEncoder.encode(addr,"UTF-8");

		 //step2 요청 발생시키기
		String client_id ="e4ptphrqyy";
		String client_secret ="2qGB2LMM6Nw8eV6UNf7xwKSmPyRgt2tv98zjzRRa";
		URL ur=new URL(url);
		HttpURLConnection con=(HttpURLConnection)ur.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("x-ncp-apigw-api-key-id",client_id);
		con.setRequestProperty("x-ncp-apigw-api-key",client_secret);
		
		
		
		//step3 : 데이터 수신
		InputStream is=con.getInputStream();
		int read=0;
		//이미지는 바이트단위이기 떄문에 바이트 배열을 사용한다.
		byte[] bytes=new byte[1024];
		//파일 이름짓기
		/*Date dt=new Date();
		Long lt=dt.getTime();
		String img =lt.toString();
		*/
		String imgname =Long.valueOf(new Date().getTime()).toString();
		//파일생성
		File file =new File(imgname+".jpg");
		file.createNewFile();
		
		
		OutputStream outputstream =new FileOutputStream(file);
		while((read=is.read(bytes))!=-1) {
			outputstream.write(bytes,0,read);
		}
		is.close();
		outputstream.close();
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	
	
}
}
