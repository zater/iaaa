<%@page import="java.util.List"%>
<%@page import="tk.zater.CS.plantype"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="tk.zater.CreateSession.CreateHibernateServer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<link rel="icon" href="images/logo.png" type="image/png" />
    <title>Little Trip 地方.輕旅行</title>
    <meta charset="utf-8">
<script src = "js/jquery-1.11.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("body").toggle();
		$(window).load(function(){		
			$("header").find("img:eq(2)").parent().click(function(){$("iframe").attr("src","search.html?userId=1&locationName=&plantype=&pay=&score=");})
			$("header").find("img:eq(3)").parent().click(function(){$("iframe").attr("src","search.html?userId=&locationName=&plantype=&pay=&score=5");})
			$("header").find("img:eq(4)").parent().click(function(){$("iframe").attr("src","search.html?userId=&locationName=&plantype=&pay=0&score=");})
			$("header").find("img:last").parent().click(function(){$("iframe").attr("src","add.jsp");})
			$("body").toggle();
			$("nav").find("table").css("border-collapse","collapse");	 
			$("nav").width($(window).width()*0.95);
			$("nav").find("img").width($("nav").width()/5-3);
			$("#theblock").css("padding-left",$(document).innerWidth()/2 + "px");
			$("#theblock").css("padding-right",$(document).innerWidth()/2 + "px");
			$("#theblock").css("padding-top",$(document).innerHeight()/2 + "px");
			$("#theblock").css("padding-bottom",$(document).innerHeight()/2 + "px");
			$("#theblock").css("left","0");
			$("#theblock").css("top","0");
			$("#bodycolor").css("height",$(window).innerHeight()*0.8+"px");
			$("#bodycolor").css("width",$(window).innerWidth()*0.95+"px");
			$("footer span img").css("width",$("#bodycolor").css("width"));
			document.getElementsByTagName("section")[0].style.height=$(window).innerHeight()*0.95+"px";		
			$("iframe").css("height",$("section").css("height"));
			$("iframe").css("width",$("section").css("width"));	 
			$("#form1").hide();
			$("#form2").hide();
			$("#form3").hide();
			setTimeout(function(){$("#theblock").hide()},100);

		});
		 $(window).resize(function(){
			$("nav table").css("border-collapse","collapse");	 
			$("nav").width($(window).width()*0.95);
			$("nav").find("img").width($("nav").width()/5-3);
			$("#bodycolor").css("height",$(window).innerHeight()*0.8+"px");
			$("#bodycolor").css("width",$(window).innerWidth()*0.95+"px");
			$("footer span img").css("width",$("#bodycolor").css("width"));			
			document.getElementsByTagName("section")[0].style.height=$(window).innerHeight()*0.95+"px";
			$("iframe").css("height",$("section").css("height"));
			$("iframe").css("width",$("section").css("width"));
			$("#form1").hide();
			$("#form2").hide();
			$("#form3").hide();
			$("#theblock").hide();	 
		 });
		 $(window).keydown(function(e){
			if(e.keyCode==8&&e.target.nodeName=="BODY"){
				return false;
			}
		});
	});

	 function processlogin(){
		 $("#form1").show();
		 $("#theblock").toggle();
		 $("#theblock").css("opacity","0.5");
		 $("#theblock").css("filter","alpha(opacity=50)");
		 $("#form1").css("padding-left",($(window).width()-$("#form1").width())/2 + "px");
		 $("#form1").css("padding-right",($(window).width()-$("#form1").width())/2 + "px");
		 $("#form1").css("padding-top",($(window).height()-$("#form1").height()-10)/2 + "px");
		 $("#form1").css("padding-bottom",($(window).height()-$("#form1").height()-10)/2 + "px");
		 $("#form1").css("left","0");
		 $("#form1").css("top","0");
	 }
	 
	  function cancellogin(){
		 $("#form1").hide();
		  $("#theblock").toggle();

		 
	 }
	 function  processregister(){
		 $("#form2").show();
		 $("#theblock").toggle();
		 $("#theblock").css("opacity","0.5");
		 $("#theblock").css("filter","alpha(opacity=50)");
		 $("#form2").css("padding-left",($(window).width()-$("#form2").width())/2 + "px");
		 $("#form2").css("padding-right",($(window).width()-$("#form2").width())/2 + "px");
		 $("#form2").css("padding-top",($(window).height()-$("#form2").height()-10)/2 + "px");
		 $("#form2").css("padding-bottom",($(window).height()-$("#form2").height()-10)/2 + "px");
		 $("#form2").css("left","0");
		 $("#form2").css("top","0");
		 
	 }
	 
	  function cancelregister(){
	   $("#theblock").toggle();
		 $("#form2").hide();
		 
	 }
	
	function opensearch(){
		var q1 = $("#form3 select:eq(0)").val();
		var q2 = $("#form3 select:eq(1)").val();
		var q3 = $("#form3 input[name='pay']").val()
		var q4 = $("#form3 select:eq(2)").val();
		if(q1 == "其他"){
			q1="";
		}
		if(q2 == "其他") {
			q2="";
		}
		if(q4 == "不限定"){
			q4="";
		}
		if(q3 == ""||isNaN(q3)==true) {
			q3=0;
		}
		$("iframe").attr("src","search.html?userId=&locationName="+q1+"&plantype="+q2+"&pay="+q3+"&score="+q4);		
		$("#theblock").toggle();
		$("#form3").hide();
	}

	function gosearch(){
		$("#form3").show();
		 $("#theblock").toggle();
		 $("#theblock").css("opacity","0.5");
		 $("#theblock").css("filter","alpha(opacity=50)");
		 $("#form3").css("padding-left",($(window).width()-$("#form3").width())/2 + "px");
		 $("#form3").css("padding-right",($(window).width()-$("#form3").width())/2 + "px");
		 $("#form3").css("padding-top",($(window).height()-$("#form3").height()-10)/2 + "px");
		 $("#form3").css("padding-bottom",($(window).height()-$("#form3").height()-10)/2 + "px");
		 $("#form3").css("left","0");
		 $("#form3").css("top","0");
	}
	function closesearch(){
		$("#theblock").toggle();
		$("#form3").hide();
	}
	<%
							try {
							String lv =  String.valueOf(request.getSession().getAttribute("userLV"));
							String name =  String.valueOf(request.getSession().getAttribute("Username"));
								if ("5".equals(lv)) {		
	%>	
		function setgone(){
			$("iframe").attr("src","search.html?setgone=0");
		}
	<%							
								} 								
							} catch (Exception e) {
								out.print("error");
							}
	%>
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
z-index:2;	

}
#form2{
min-width: 200px;
max-width: 450px;
position:absolute;
z-index:2;	

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
#form3{
min-width: 200px;
max-width: 480px;
width:520px; 
position:absolute; height:480px;
z-index:2;
}


#form3 .style1{
font-family: "微軟正黑體","新細明體","Adobe 黑体 Std R";
font-size:15px;
line-height:18px;
letter-spacing:1px;
font-weight:bold;
}
#form3 .style3{
background:url(LittleTrip%20_website/images/.jpg) repeat top left  ;
}

#form3 a:link {color:gray;}
a:visited {color:gray;}
a:hover{color:brown;}
a:active{color:blue;}
a{text-decoration:none}


#form3 fieldset{
	
border:1px groove; 
border-radius:10px;
background-color:#D1BBFF;
border-color:white;	

	
	}
#form3 .button {
   border-top: 1px solid #c4a4e3;
   background: #553978;
   background: -webkit-gradient(linear, left top, left bottom, from(#7420d4), to(#553978));
   background: -webkit-linear-gradient(top, #7420d4, #553978);
   background: -moz-linear-gradient(top, #7420d4, #553978);
   background: -ms-linear-gradient(top, #7420d4, #553978);
   background: -o-linear-gradient(top, #7420d4, #553978);
   padding: 7.5px 15px;
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
#form3 .button:hover {
   border-top-color: #6f46b0;
   background: #6f46b0;
   color: #ccc;
   }
#form3 .button:active {
   border-top-color: #8019e0;
   background: #8019e0;
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
							<%
							try {
							String lv =  String.valueOf(request.getSession().getAttribute("userLV"));
							String name =  String.valueOf(request.getSession().getAttribute("Username"));
								if ("5".equals(lv)) {						
									out.print("<a class='active' onclick='setgone()'><span class='style1'>審核</span></a>|");
									out.print("<span class=\"style1\">"+name+"</span>|");
									out.print("<a class=\"active\" href=\"logout\"><span class=\" style1\">登出</span></a>");	
								} else if(name != "null"){
									out.print("<span class=\"style1\">"+name+"</span>|");
									out.print("<a class=\"active\" href=\"logout\"><span class=\" style1\">登出</span></a>");
								} else {
									out.print("<a class=\"active\" onClick=\"processlogin()\"><span class=\" style1\">登入</span></a>|");
									out.print("<a class=\"active\" onClick=\"processregister()\"><span class=\"style1\">註冊</span></a>");
								}
								
							} catch (Exception e) {
								out.print("error");
							}
							%>
							
							
                        </ul></td>
                </tr>
                <tr>
                  <td><input style="color:gray; width:30%;margin-left:7%;"type="text" name="search" placeholder="我想去..." size="10" maxlength="10" onclick="gosearch()" readonly >
                </tr>
                </table>
                    
                       
              <nav >
			  <table>
				<tr>
					<td><a href="https://www.facebook.com/puyesido"><image src="images/nav1.png" alt=""></a></td>
					<td><a href="#"><image src="images/nav2.png" alt=""></a></td>
					<td><a href="#"><image src="images/nav3.png" alt=""></a></td>
					<td><a href="#"><image src="images/nav4.png" alt=""></a></td>
					<td><a href="#"><image src="images/nav5.png" alt=""></a></td>
				</tr>
			  </table>
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
                      <iframe src="content.jsp"></iframe>
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
  
  <input type="text" id="UserAccount" size="20"  name="accountName" placeholder="使用者ID"  style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#87CECB; height:25px;" required >
</div>
<p align="center">
<input type="password" id="UserPass" size="20" name="pwd" placeholder="密碼"  style="font-family: 微軟正黑體; width:40%; border-radius:5px; border-style:solid; border-color:#87CECB;height:25px;" required><p align="center">

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


<form id="form2" method = "GET" action="reg">
	<fieldset id="fieldset2">
		<p align="center">
		<img style="width:106%;margin-left:-3%;margin-top:-5%;" src="images/pic32.png"></img><br/><br/>
		<img style="width:100px;margin-left:5px;" src="images/pic34.png"></img><br/>	  
		<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-30%;">帳號</span><br/><input type="text" id="accountName" name="accountName" size="20" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;" required>
		</p>
		<p align="center">
		<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-20%;">密碼(6-20碼)</span><br/>
		<input type="password" id="UserPass" name = "pwd" size="20" style="font-family: 微軟正黑體; width:40%; border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;" required>
		</p>
		<p align="center">
		<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-28%;">確認密碼</span><br/>
		<input type="password" id="ConfirmPass" size="20" style="font-family: 微軟正黑體; width:40%; border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;" required>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-32%;">姓名</span><br/>
			<input type="text" name="userName" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;" required>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-32%;">E-mail</span><br/>
			<input type="text" id="email" name="email" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;" required>
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-35%;">地址</span><br/>
			<input type="text" id="address" name="address" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;">
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-35%;">電話</span><br/>
			<input type="text" name="tel" size="50" style="margin: 0 auto; font-family: 微軟正黑體; width:40%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:25px;">
		</p>
		<p align="center">
			<span style="text-align:center;color:#666666; font-family: 微軟正黑體;margin-left:-35%;">自我介紹</span><br/>
			<textarea name="inrtoduction" cols="30" rows = "3" style="margin: 0 auto; font-family: 微軟正黑體; width:36%;border-radius:5px; border-style:solid; border-color:#FFAA33;height:50px;"></textarea>
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

<form id="form3" onsubmit="return false">
<fieldset>
<div align="center">
<img style="width:106%;margin-left:-3%;margin-top:-2%;" src="images/pic35.png"></img><br/><br/>
<img style="width:100px;margin-left:5px;" src="images/pic34.png"></img><br/>
<p><span style="text-align:center;color:#666666; font-family: 微軟正黑體;font-size:17px;margin-left:-13%;">地點:</span>
		<select style="margin: 0 auto; font-family: 微軟正黑體; width:20%;border-radius:5px; border-style:solid; border-color:#800080;height:25px;color:#666666;font-size:14px;">
				<option>基隆市</option>
                <option>臺北市</option>
                <option>新北市</option>
                <option>桃園縣</option>
                <option>新竹市</option>
                <option>新竹縣</option>
                <option>苗栗縣</option>
                <option>臺中市</option>
                <option>南投縣</option>
                <option>彰化縣</option>
                <option>雲林縣</option>
                <option>嘉義市</option>
                <option>嘉義縣</option>
                <option>臺南市</option>
                <option>高雄市</option>
                <option>屏東縣</option>
                <option>宜蘭縣</option>
                <option>花蓮縣</option>
                <option>澎湖縣</option>
                <option>金門縣</option>
                <option>連江縣</option>
				<option selected="true">其他</option>
		</select>
</p>   
<p><span style="text-align:center;color:#666666; font-family: 微軟正黑體;font-size:17px;margin-left:-6%;">主題類型:</span>
		<select style="margin: 0 auto; font-family: 微軟正黑體; width:20%;border-radius:5px; border-style:solid; border-color:#800080;height:25px;color:#666666;font-size:14px;">
                <option selected="true">其他</option>
				<%
				Session sess = CreateHibernateServer.getSessionFactory().openSession();
				Query qr = sess.createQuery("from plantype");
				List<plantype> plan = qr.list();
				for(int i = 0; i < plan.size();i++) {
					out.print("<option>"+plan.get(i).getTypename()+"</option>");
				}
				%>
		</select>
</p>
<p><span style="text-align:center;color:#666666; font-family: 微軟正黑體;font-size:17px;">價格:小於</span>
 <input type="number" name="pay" min="1" size="15" style="margin: 0 auto; font-family: 微軟正黑體; width:20%;border-radius:5px; border-style:solid; border-color:#800080; height:20px;"/>
<span style="text-align:center;color:#666666; font-family: 微軟正黑體;font-size:17px;">元</span>
</p>
<p><span style="text-align:center;color:#666666; font-family: 微軟正黑體;font-size:17px;margin-left:-6%;">評比星等:</span>
		<select style="margin: 0 auto; font-family: 微軟正黑體; width:20%;border-radius:5px; border-style:solid; border-color:#800080;height:25px;color:#666666;font-size:14px;">
			<option selected="true">不限定</option>
			<option value="1">一顆星</option>
			<option value="2">二顆星</option>
			<option value="3">三顆星</option>
			<option value="4">四顆星</option>
			<option value="5">五顆星</option>
		</select>
</p>     
</div>

<div align="center">
<table>
<tr> 
<td><input type="button" class="button" onClick="opensearch()" value="送出" /></p></td>
<td><input type="button" class="button" onClick="closesearch()" value="返回" /></p></td>
</tr></table>
</div>
</fieldset>
</form>	

</body>
</html>
