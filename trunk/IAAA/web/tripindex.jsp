﻿<!DOCTYPE html>
<html lang="en">
<head>

<link rel="icon" href="images/logo.png" type="image/png" />
    <title>Little Trip 地方.輕旅行</title>
    <meta charset="utf-8">
<script src = "js/jquery-1.11.1.min.js"></script>
<script>
<%
try {
String lv =  String.valueOf(request.getSession().getAttribute("userLV"));
out.print("'"+String.valueOf(request.getSession().getAttribute("Username"))+"'");
if ("5".equals(lv)) {

%>

<%
}
} catch (Exception e) {
}

%>
	$(document).ready(function(){
		$("body").toggle();
	});
	 $(window).load(function(){		
		 $("body").toggle();
		 $("#theblock").css("padding-left",$(window).innerWidth()/2 + "px");
		 $("#theblock").css("padding-right",$(window).innerWidth()/2 + "px");
		 $("#theblock").css("padding-top",$(window).innerHeight()/2 + "px");
		 $("#theblock").css("padding-bottom",$(window).innerHeight()/2 + "px");
		 $("#theblock").css("left","0");
		 $("#theblock").css("top","0");
		$("#bodycolor").css("height",$(window).innerHeight()*0.8+"px");
		$("#bodycolor").css("width",$(window).innerWidth()*0.95+"px");
		$("footer span img").css("width",$("#bodycolor").css("width"));
		 document.getElementsByTagName("section")[0].style.height=$(window).innerHeight()*0.95-$("header").height()- $("footer span img").height()+"px";		
		 $("iframe").css("height",$("section").css("height"));
		 $("iframe").css("width",$("section").css("width"));	 
		 document.getElementById("form1").hidden=true;
		 document.getElementById("form2").hidden=true;
		 setTimeout(function(){$("#theblock").toggle()},500);
	 
	 });
	 $(window).resize(function(){
		$("#bodycolor").css("height",$(window).innerHeight()*0.8+"px");
		$("#bodycolor").css("width",$(window).innerWidth()*0.95+"px");
		 $("footer span img").css("width",$("#bodycolor").css("width"));	
	 document.getElementsByTagName("section")[0].style.height=$(window).innerHeight()*0.95-$("header").height()- $("footer span img").height()+"px";
	 document.getElementsByTagName("body")[0].style.display = "block";
	 $("iframe").css("height",$("section").css("height"));
	 $("iframe").css("width",$("section").css("width"));
	 document.getElementById("form1").hidden=true;
	 document.getElementById("form2").hidden=true;
	 
	 });
	 function processlogin(){
		 document.getElementById("form1").hidden=false;
		 var element = document.getElementById("bodycolor");
	     element.style.opacity = "0.5";
	     element.style.filter  = "alpha(opacity=50)";
		 $("#form1").css("padding-left",($(window).innerWidth()-$("#form1").width())/2 + "px");
		 $("#form1").css("padding-right",($(window).innerWidth()-$("#form1").width())/2 + "px");
		 $("#form1").css("padding-top",($(window).innerHeight()-$("#form1").height()-10)/2 + "px");
		 $("#form1").css("padding-bottom",($(window).innerHeight()-$("#form1").height()-10)/2 + "px");
		 $("#form1").css("left","0");
		 $("#form1").css("top","0");
	 }
	 
	  function cancellogin(){
		 document.getElementById("form1").hidden=true;
		 var element = document.getElementById("bodycolor");
	     element.style.opacity = "1";
	     element.style.filter  = "alpha(opacity=100)";
		 return false;
		 
	 }
	 	 function  processregister(){
		 document.getElementById("form2").hidden=false;
		 var element = document.getElementById("bodycolor");
	     element.style.opacity = "0.5";
	     element.style.filter  = "alpha(opacity=50)";
		 $("#form2").css("padding-left",($(window).innerWidth()-$("#form2").width())/2 + "px");
		 $("#form2").css("padding-right",($(window).innerWidth()-$("#form2").width())/2 + "px");
		 $("#form2").css("padding-top",($(window).innerHeight()-$("#form2").height()-10)/2 + "px");
		 $("#form2").css("padding-bottom",($(window).innerHeight()-$("#form2").height()-10)/2 + "px");
		 $("#form2").css("left","0");
		 $("#form2").css("top","0");
		 
	 }
	 
	  function cancelregister(){
		 document.getElementById("form2").hidden=true;
		 var element = document.getElementById("bodycolor");
	     element.style.opacity = "1";
	     element.style.filter  = alpha(opacity=100);
		 
	 }
	
	function checkreg(x){
		
	}
	function gocontent(){
		$("iframe").attr("src","tripcontent.html?id=4")
	}
	function gosearch(){
		console.log("test");
	}
</script>

	<!--[if lt IE 8]>
    <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
        	<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
    </div>
	<![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
	<![endif]-->
<style>
.style1{
font-family: "微軟正黑體","新細明體","Adobe 黑体 Std R";
font-size:15px;
line-height:18px;
letter-spacing:1px;
font-weight:bold;
}
.style3{

}

a:link {color:gray;}
a:visited {color:gray;}
a:hover{color:brown;}
a:active{color:blue;}
a{text-decoration:none}



#form1{
min-width: 200px;
max-width: 450px;
position:absolute;
z-index:1;	

}
#form2{
min-width: 200px;
max-width: 450px;
position:absolute;
z-index:1;	

}
#theblock{
	position:absolute;
	z-index:1;	
	background-color:white;
}
fieldset{
	
border:1px groove; 
border-radius:10px;
background-color:#B0E0E6;
border-color:white;	

	
	}
.button {
   border-top: 1px solid #106091;
   background: #2382c2;
   background: -webkit-gradient(linear, left top, left bottom, from(#0c629c), to(#2382c2));
   background: -webkit-linear-gradient(top, #0c629c, #2382c2);
   background: -moz-linear-gradient(top, #0c629c, #2382c2);
   background: -ms-linear-gradient(top, #0c629c, #2382c2);
   background: -o-linear-gradient(top, #0c629c, #2382c2);
   padding: 7.5px 15px;
   -webkit-border-radius: 9px;
   -moz-border-radius: 9px;
   border-radius: 9px;
   -webkit-box-shadow: rgba(0,0,0,1) 0 1px 0;
   -moz-box-shadow: rgba(0,0,0,1) 0 1px 0;
   box-shadow: rgba(0,0,0,1) 0 1px 0;
   text-shadow: rgba(0,0,0,.4) 0 1px 0;
   color: #fcfcfc;
   font-size: 19px;
   font-family: 微軟正黑體;
   text-decoration: none;
   vertical-align: middle;


   }
.button:hover {
   border-top-color: #065b94;
   background: #065b94;
   color: #ccc;
   }
.button:active {
   border-top-color: #2570a1;
   background: #2570a1;
   }

.button2 {
   border-top: 1px solid #eb8934;
   background: #f76d2d;
   background: -webkit-gradient(linear, left top, left bottom, from(#f7711e), to(#f76d2d));
   background: -webkit-linear-gradient(top, #f7711e, #f76d2d);
   background: -moz-linear-gradient(top, #f7711e, #f76d2d);
   background: -ms-linear-gradient(top, #f7711e, #f76d2d);
   background: -o-linear-gradient(top, #f7711e, #f76d2d);
   padding: 8px 16px;
   -webkit-border-radius: 9px;
   -moz-border-radius: 9px;
   border-radius: 9px;
   -webkit-box-shadow: rgba(0,0,0,1) 0 1px 0;
   -moz-box-shadow: rgba(0,0,0,1) 0 1px 0;
   box-shadow: rgba(0,0,0,1) 0 1px 0;
   text-shadow: rgba(0,0,0,.4) 0 1px 0;
   color: white;
   font-size: 19px;
   font-family: 微軟正黑體;
   text-decoration: none;
   vertical-align: middle;
   }
.button2:hover {
   border-top-color: #e6842e;
   background: #e6842e;
   color: #ccc;
   }
.button2:active {
   border-top-color: #f26a2c;
   background: #f26a2c;
   }



#fieldset2{
	
border:1px groove; 
border-radius:10px;
background-color:#FFDDAA;
border-color:white;	
	
}


#bodycolor{
	margin-left:auto;
	margin-right:auto;
}

</style>
</head>
<body id="page1">
<!--==============================header=================================-->
     <div id="bodycolor" readOnly="true">
    <header>
    	<div class="row-top">
        	<div class="main">
            	<div class="wrapper">
                <table width="100%">
                <tr>
                 <td width="79%" rowspan="2"><a href="tripindex.jsp"><img style="width:230px;margin-left:5px;" src="images/logo.png"></img></a></td>
                <td width="80%">
                <ul class="menu" style="color:gray;font-size:24px; font-family:微軟正黑體; margin-top:-8%;">
                            <a class="active" onClick="processlogin()"><span class="style1">登入</span></a>|
                            <a class="active" onClick="processregister()"><span class="style1">註冊</span></a>| 
                        </ul></td>
                	</tr>
                <tr>
                  <td><input style="color:gray; width:30%;margin-left:7%;"type="text" name="search" placeholder="我想去..." size="10" maxlength="10" onclick="gosearch()" readonly >
                </tr>
                </table>
                    
                       
             
              <nav><img style="width:100%;height:17%;" src="images/pic1.png" onclick="gocontent()"></img></nav>
              </div>
            </div>
        </div>
        
        <div class="row-bot">
        	<div class="style3">
            	<div class="main">
                	
                    <div class="slider-wrapper">
                        <div class="slider"></div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
	<!--==============================content================================-->
    <section id="content" style=""><div class="ic"></div>
        <div class="main">
            <div class="wrapper img-indent-bot">
             
                
            </div>
            
                	<div class="maxheight indent-bot">
                      <iframe src="add.jsp"></iframe>
                	</div>
                </article>
          
        </div>
    </section>
    
	<!--==============================footer=================================-->
  <footer>
        <div class="main">
        	<div class="aligncenter">
            	<span> <img src="images/footer.png" alt=""/></span>
            </div>
        </div>
    </footer>
    </div>
<form id="form1" method="GET" action="login">
<fieldset>
<div align="center">
<img style="width:106%;margin-left:-3%;margin-top:-2%;" src="images/pic30.png"></img><br/><br/>
<img style="width:100px;margin-left:5px;" src="images/pic34.png"></img><br/>
  
  <input type="text" id="UserAccount" size="20"  name="accountName" placeholder="使用者ID"  style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#87CECB; height:25px;" />
</div>
<p align="center">
<input type="password" id="UserPass" size="20" name="pwd" placeholder="密碼"  style="font-family: 微軟正黑體; width:40%; border-radius:5px; border-style:solid; border-color:#87CECB;height:25px;"/><p align="center">

<div align="center">
  <table width="200">
    <tr>
      <td> <a href="#"><span style="color:#000088;font-size:16px;font-family: 微軟正黑體;">忘記密碼?</span></a></td>
      </tr>
  </table>
</div>
<div align="center">
<table>
<tr> 
<td><input type="submit" class="button" form="form1" value="登入" /></p></td>
<td><input type="button" class="button" form="form1" onClick="cancellogin()" value="取消" /></p></td>
</tr></table>
</div>
</fieldset>
</form>	


<form id="form2" method = "GET" action="reg" onsubmit = "return checkreg(this)">
	<fieldset id="fieldset2">
		<p align="center">
		<img style="width:106%;margin-left:-3%;margin-top:-5%;" src="images/pic32.png"></img><br/><br/>
		<img style="width:100px;margin-left:5px;" src="images/pic34.png"></img><br/>	  
		<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-30%;">帳號</span><br/><input type="text" id="accountName" name="accountName" size="20" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<p align="center">
		<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-20%;">密碼(6-20碼)</span><br/>
		<input type="password" id="UserPass" name = "pwd" size="20" style="font-family: 微軟正黑體; width:40%; border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<p align="center">
		<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-28%;">確認密碼</span><br/>
		<input type="password" id="ConfirmPass" size="20" style="font-family: 微軟正黑體; width:40%; border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-32%;">姓名</span><br/>
			<input type="text" name="userName" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-32%;">E-mail</span><br/>
			<input type="text" id="email" name="email" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-35%;">地址</span><br/>
			<input type="text" id="address" name="address" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-35%;">電話</span><br/>
			<input type="text" name="tel" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-35%;">自我介紹</span><br/>
			<input type="text" name="inrtoduction" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;"/>
		</p>
		<div align="center">		  
			<table>
			<tr>   
					<td><input type="submit" class="button2" form="form2" value="送出" /></td> 
					<td><input type="button" class="button2" form="form2" onClick="cancelregister()" value="取消" /></td>
				</tr>
			</table>
		</div>

	</fieldset>
</form>	
<div id="theblock">
</div>
</body>
</html>
