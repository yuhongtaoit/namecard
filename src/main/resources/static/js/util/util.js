function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}

function myStartWith(val,flag){
	if(val.indexOf(flag)==0){
		return true;
	}else{
		return false;
	}
}

function toArray(val){
	if(myStartWith(val,"[")){
		return val.substring(val.indexOf("[")+1, val.lastIndexOf("]")).split(",");
	}else{
		return val.split(",");
	}
}

Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == val) return i;
	}
	return -1;
};

Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};


function checkPhone(value){ 
    if(!(/^1(3|4|5|7|8)\d{9}$/.test(value))){ 
        return false; 
    } 
    return true;
}

function isNull(value){
	if (!value || myTrim(value)=='') { 
		return true;
	}
	return false;
}

function checkNum(value){ 
    if(!(/^[0-9]*$/.test(value))){ 
        return false; 
    } 
    return true;
}

function checkCash(value){ 
    if(!(/(^[1-9]([0-9]+)?(\.[0-9]*)?$)|(^(0){1}$)|(^(0){1}\.[0-9]+$)/.test(value))){ 
        return false; 
    } 
    return true;
}

function checkEmail(value){ 
    if(!(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/.test(value))){ 
        return false; 
    } 
    return true;
}

function checkTel(value){
	if(!/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(value)){
		return false;
	}
	return true;
}
