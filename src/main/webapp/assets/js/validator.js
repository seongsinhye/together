/**
 * 
 */	// 규칙에 맞는 아이디 라면 false 반환 
	 //  규칙에 맞지 않는 아이디라면 true 반환 
 
 function idValidator(id){

	 
	 
	 const regex = /^[A-Za-z0-9]{4,10}$/;
	 
	 
	if(regex.test(id)){
		return false;
	} else {
		return true;
	}
	 
	 
}

function pwValidator(pw){
	const regex = /^[a-zA-Z0-9]{4,10}$/;
	 
	 
	if(regex.test(pw)){
		return false;
	} else {
		return true;
	}
}

function nameValidator(name){
	const regex = /[ㄱ-힣]/;
	 
	 
	if(regex.test(name)){
		return false;
	} else {
		return true;
	}
}

function telValidator(tel){
	return false;
}
function addrValidator(addr){
	// 규칙에 맞는 아이디 라면 false 반환 
	 //  규칙에 맞지 않는 아이디라면 true 반환 
	 
	return false;
}
function emailValidator(email){
	const regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	 
	if(regex.test(email)){
		return false;
	} else {
		return true;
	}
}
