function addToCart(action){
	document.addForm.action=action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가 되었습니다.");
}

function removeFromeCart(action){
	document.removeForm.action=action;
	document.removeForm.submit();
	window.location.reload;
	
}

function clearCart(){
	document.claerForm.submit();
	window.location.reload();
}