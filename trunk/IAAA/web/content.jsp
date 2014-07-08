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
			
			
			$("img").css("width",$(window.parent.window).width()*0.5);
			$.getJSON("GainLatestTrip",function(jdata){
					tesr = jdata;
					for(var i = 0; i < 4;i++) {
						tag = jdata['trip'][i];
						flag = $("a")[i];
						topic = tag['topic'];
						cover = tag['cover'];
						$(flag).attr("href","tripcontent.jsp?id="+tag['id']);
						var text = document.createElement("p");
						text = topic;
						$(flag).append(text);
						$(flag).append(document.createElement("br"));
						var img = document.createElement("img");
						$(img).attr("src",cover);
						$(img).css("max-width","200px");
						$(flag).append(img);

					}
				});		
	});
	
	$(window).resize(function(){
		$("img").css("width",$(window.parent.window).width()*0.5);
	
	
	});
</script>

<style>

header{text-align:center}
a:link {color:gray;}
a:visited {color:gray;}
a:hover{color:#f76d2d;;}
a:active{color:blue;}
a{text-decoration:none}


fieldset{
	
border:1px groove; 
border-radius:10px;
background-color:#B0E0E6;
border-color:white;	

}
section{
	margin-left:25%
}
</style>

</head>
<body id="page1">
	<!--==============================header=================================-->
    <div id="bodycolor">
	<header>
	        <div class="row-bot">
        	<div class="style3">
            	<div class="main">
                	
                    <div class="slider-wrapper">
                        <div class="slider">
                        <img  style="width:100%;height:80%;" src="" alt="" />
                              
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
	<!--==============================content================================-->
    <section id="content" style="background:url("><div class="ic"></div>
        <div class="main">
            <div class="wrapper img-indent-bot">
            <table width="50%">
            <tr>
            <td width="50%" height="37%" colspan="2">
                <article class="col-1"><img src="images/pic3.png" style="width:100%;height:100%;"></img></article> <article class="col-2"></article>
				</td>
                </tr>
                  <tr>
       	 <td  height="25%"> <article class="column-1">
                <a></a>
                </article></td>
                 <td height="25%">
				 <article class="column-2">
                 <a></a>
                </article></td>
                 
                </tr>
                
                 <tr>
                 <td  height="25%"><article class="column-3">
                <a></a>
                </article></td>
                <td  height="25%"><article class="column-4">
                <a></a>
                </article></td> </tr></table>    
              
           <table width="50%" style="float:right">


                
              <tr>
                <td height="40%"><article class="column-6">
				<iframe src="http://www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Fpuyesido&width&height=290&colorscheme=light&show_faces=true&header=true&stream=false&show_border=true">
                </article></td></tr></table>       
               
            </div>
            
                	<div class="maxheight indent-bot">
                      
                	</div>
                </article>
          
        </div>
    </section>
    
    </div>

</body>
</html>
