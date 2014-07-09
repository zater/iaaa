<%@page import="java.util.List"%>
<%@page import="tk.zater.CS.plantype"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="tk.zater.CreateSession.CreateHibernateServer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>

<link rel="icon" href="/images/logo.png" type="image/png" />
    <meta charset="utf-8">
	<script src = "js/jquery-1.11.1.min.js"></script>
<script>
	 
	 	$(window).load(function(){
			if(Math.round(Math.random()) == 1){
				$("img:eq(0)").attr("src","images/back1.jpg");
			} else {
				$("img:eq(0)").attr("src","images/back2.jpg");
			}
			
			
			$("img").css("width",$(window.parent.window).width()*0.4);
$("iframe").css("float","right");
			$.getJSON("GainLatestTrip",function(jdata){
					for(var i = 0; i < 4;i++) {
						tag = jdata['trip'][i];
						flag = $("a")[i];
						topic = tag['topic'];
						cover = tag['cover'];
						$(flag).attr("href","tripcontent.jsp?id="+tag['id']);
						var text = document.createElement("p");
						$(text).html(topic);
						$(flag).append(text);
						var img = document.createElement("img");
						$(img).attr("src",cover);
						$(img).css("max-width","200px");
						$(flag).append(img);

					}
				});		
							$.getJSON("hot",function(jdata){

						tag = jdata;
						flag = $("[src='images/pic4.jpg']").parent();
						$(flag).attr("href","tripcontent.jsp?id="+tag['id']);
						var text = document.createElement("p");
						$(text).html(tag['Abstracts']);
						$(flag).append(text);
				});	
	});
	
	$(window).resize(function(){
		$("img").css("width",$(window.parent.window).width()*0.4);
	
	
	});
</script>

<style>

header{text-align:center}
a:link {color:gray;}
a:visited {color:gray;}
a:hover{color:#f76d2d;}
a:active{color:blue;}
a{text-decoration:none;display:table-cell}
#content>div{display:table-cell}
</style>

</head>
<body id="page1">


	<header>
                 <img  style="width:100%;height:80%;" src="" alt="" />

   	 </header>

    <section id="content" >
	<div>
		<img src = "images/pic3.jpg">
		<div>
			<a></a>
			<a></a>
		</div>
		<div>
			<a></a>
			<a></a>
		</div>
	</div>
	<div>
		<a>
			<img src = "images/pic4.jpg">
		</a>
		
				<iframe src="http://www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Fpuyesido&width&height=290&colorscheme=light&show_faces=true&header=true&stream=false&show_border=true">
	</div>
    </section>

</body>
</html>
