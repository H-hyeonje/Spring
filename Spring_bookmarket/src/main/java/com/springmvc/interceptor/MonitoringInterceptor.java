package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor{

	ThreadLocal<StopWatch> stopWatchLocal= new ThreadLocal<StopWatch>();
	
	public Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public boolean preHandle(HttpServletRequest req,HttpServletResponse resq,Object hendler) throws Exception {
		StopWatch stopWatch= new StopWatch(hendler.toString());
		stopWatch.start(hendler.toString());
		stopWatchLocal.set(stopWatch);
		logger.info("접근한 URL 경로 : "+ getURLPath(req));
		logger.info("접근한 URL 경로 : "+ getCurrentTime());
		return true;
		
	}
	
	public void postHandle(HttpServletRequest req, HttpServletResponse rspn,Object handler, ModelAndView modelAndView)throws Exception {
		logger.info("요청 처리 종료 시각 :" +getCurrentTime() );
		
	}
	public void afterCompletion(HttpServletRequest req, HttpServletResponse rspn,Object handler, Exception exception)throws Exception {
		StopWatch stopWatch= stopWatchLocal.get();
		stopWatch.stop();
		logger.info("요청 처리 소요 시간 :" + stopWatch.getTotalTimeMillis() +"ms" );
		stopWatchLocal.set(null);
		logger.info("========================================================");
		
	}

	private String getURLPath(HttpServletRequest req) {
		String currentPath =req.getRequestURI();
		String queryString = req.getQueryString();
		queryString= queryString==null? "":"?"+queryString;
		return currentPath+queryString;
	}

	private String getCurrentTime() {
		DateFormat fommatter=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calender=Calendar.getInstance();
		calender.setTimeInMillis(System.currentTimeMillis());
		return fommatter.format(calender.getTime());
	}


	
}
