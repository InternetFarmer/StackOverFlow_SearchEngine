 function shelter(){
	var h = document.body.scrollHeight;
	var w = document.body.scrollWidth;
	var oMask=document.createElement("div");
	    oMask.id="mask";
		oMask.style.height = h +"px";
		oMask.style.width = w +"px";
    document.body.appendChild(oMask);
      
    
    
    var oLogin=document.createElement("div");
		oLogin.id="login";
		oLogin.innerHTML='<div class="loginCon">balalallalalalal<div id="close">close</div></div>';
		document.body.appendChild(oLogin);
                
    //var oCompare=document.createElement("div");
           //     oCompare.id="compare";
              //  oCompare.innerHTML='';

	
	//获取登陆框的宽和高
	var dHeight=oLogin.offsetHeight;
	var dWidth=oLogin.offsetWidth;
		//设置登陆框的left和top
		oLogin.style.left=w/2-dWidth/2+"px";
		oLogin.style.top=h/2-dHeight/2+"px";
	//点击关闭按钮
	var oClose=document.getElementById("close");
	
		//点击登陆框以外的区域也可以关闭登陆框
		oClose.onclick=oMask.onclick=function(){
					document.body.removeChild(oLogin);
					document.body.removeChild(oMask);
					};                                              
					};
					
	/*window.onload=function(){
			var oBtn=document.getElementsByTagName("a");
				//点击登录按钮
				oBtn.onclick=function(){
					shelter();
					return false;
					} 
    
    

};*/
