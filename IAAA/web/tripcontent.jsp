<%@page import="java.util.List"%>
<%@page import="tk.zater.CS.plantype"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="tk.zater.CreateSession.CreateHibernateServer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="zh-tw">
<head>
	<meta charset="utf-8">
	<style>
		article {border-style:solid;border-color:#FFAA33}
		#plan {margin-left:10%}
		#content {margin-left:20%}
		.daytitle {color:blue}
		.memotitle {color:green}
		body>div{position:absolute;top:0px;z-index:2;padding-left:90%}
	</style>
	<script src = "js/jquery-1.11.1.min.js"></script>
	<script>
		$(document).ready(function(){	
			$.getJSON("GainInfo?id="+window.location.search.split("=")[1],function(jdata){
			$("#Topic").html(jdata["Plan"]["Topic"]);
			$("#UserID").html("作者："+jdata["Plan"]["UserID"]);
			$("#plantype").html("主題："+jdata["Plan"]["plantype"]);
			$("#location").html("地區：");	
			for(i = 0; i < jdata["location"].length;i++) {
				$("#location").append(jdata["location"][i]);
				if(i != jdata["location"]-1) {
					$("#location").append("、");
				}
			}
			$("#Characteristic").html("特色："+jdata["Plan"]["Characteristic"]);
			if(jdata["month"].length == 12) {
				$("#month").html("季節限定：全年");
			} else {
				$("#month").html("季節限定："+jdata["month"][0]+"月至"+jdata["month"][jdata["month"].length-1]+"月");
			}
			$("#Days").html("時間長度："+jdata["Plan"]["Days"]);
			$("#Abstracts").html("簡介："+jdata["Plan"]["Abstracts"]);
			if(jdata["Plan"]["Price"]  != 0) {
				$("#Price").html("金額："+jdata["Plan"]["Price"] );
			} else {
				$("#Price").hide();
			}
			for(i = 0; i < jdata["memo"].length;i++) {
				flag = jdata["memo"][i];
				tag = document.createElement("div");
				tag.id = "Day"+flag["Day"];
				tag2 = document.createElement("p");
				tag2.innerHTML = "第" + (i+1) + "天";
				tag2.className = "daytitle";
				$(tag).append(tag2);
				tag2 = document.createElement("p");
				tag2.innerHTML = "交通方式：" + flag["memoTraffic"];
				$(tag).append(tag2);
				flag2 = flag["food"];
				for(j = 0; j<flag2.length;j++){
					tag2 = document.createElement("p");
					tag2.innerHTML = "美食"+(j+1);
					tag2.className = "memotitle";
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "美食店名：" + flag2[j]["FoodName"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "美食地址：" + flag2[j]["FoodAddress"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "美食電話：" + flag2[j]["FoodTel"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "美食營業時間：" + flag2[j]["FoodTime"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "美食備註：" + flag2[j]["FoodRemark"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "美食照片：";
					$(tag).append(tag2);
					for(k = 0; k < flag2[j]["Annex"].length;k++) {
						tag2 = document.createElement("img");
						tag2.src = flag2[j]["Annex"][k];
						$(tag).append(tag2);
					}
				}
				flag2 = flag["hotel"];
				for(j = 0; j<flag2.length;j++){
					tag2 = document.createElement("p");
					tag2.innerHTML = "住宿"+(j+1);
					tag2.className = "memotitle";
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "住宿店名：" + flag2[j]["HotelName"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "住宿地址：" + flag2[j]["HotelAddress"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "住宿電話：" + flag2[j]["HotelTel"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "住宿備註：" + flag2[j]["HotelRemark"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "住宿照片：";
					$(tag).append(tag2);
					for(k = 0; k < flag2[j]["Annex"].length;k++) {
						tag2 = document.createElement("img");
						tag2.src = flag2[j]["Annex"][k];
						$(tag).append(tag2);
					}
				}
				flag2 = flag["point"];
				for(j = 0; j<flag2.length;j++){
					tag2 = document.createElement("p");
					tag2.innerHTML = "景點"+(j+1);
					tag2.className = "memotitle";
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "景點名稱：" + flag2[j]["pointName"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "景點說明：" + flag2[j]["pointSummary"];
					$(tag).append(tag2);
					tag2 = document.createElement("p");
					tag2.innerHTML = "景點照片：";
					$(tag).append(tag2);
					for(k = 0; k < flag2[j]["Annex"].length;k++) {
						tag2 = document.createElement("img");
						tag2.src = flag2[j]["Annex"][k];
						$(tag).append(tag2);
					}
				}
				$("#content").append(tag);
			}
			});		
		});
		
	<%
							try {
							String lv =  String.valueOf(request.getSession().getAttribute("userLV"));
							String name =  String.valueOf(request.getSession().getAttribute("Username"));
								if ("5".equals(lv)) { 
	%>	
								function gopass(){
									$.ajax({
			url: 'SetGone?id='+window.location.search.split("=")[1],  //Server script to process data
			type: 'GET'

			
		});
								
									
								}
	<% } else if(name != "null"){	
	
	%>	
								
	<%	 } else {
								
								}								
							} catch (Exception e) {
								out.print("error");
							}
	%>
	
	</script>
</head>
<body>
	<header>
		<p id="Topic"></p>
		<p id="UserID"></p>
	</header>
	<article>
		<div id="plan">
			<p id="plantype"></p>
			<p id="location"></p>
			<p id="Characteristic"></p>
			<p id="month"></p>
			<p id="Price"></p>
			<p id="Days"></p>
			<p id="Abstracts"></p>
		</div>
		<div id="content">
			
		</div>
	</article>
	<div>
	<%
							try {
							String lv =  String.valueOf(request.getSession().getAttribute("userLV"));
							String name =  String.valueOf(request.getSession().getAttribute("Username"));
								if ("5".equals(lv)) { %>	
								<input type="button" onclick="gopass()" value="審核通過">
							<% } else if(name != "null"){	%>	
								<input type="button" value="購買">
	<%	 } else {
								
								}								
							} catch (Exception e) {
								out.print("error");
							}
	%>
	</div>
</body>
</html>