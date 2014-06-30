<%-- 
    Document   : show
    Created on : 2014/6/25, 下午 10:03:34
    Author     : zater
--%>

<%@page import="tk.zater.CS.PointTable"%>
<%@page import="tk.zater.CS.HotelTable"%>
<%@page import="java.io.File"%>
<%@page import="tk.zater.CS.AnnexTable"%>
<%@page import="tk.zater.CS.FoodTable"%>
<%@page import="tk.zater.CS.MemoTable"%>
<%@page import="java.util.List"%>
<%@page import="tk.zater.CS.PlanTable"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="tk.zater.CreateSession.CreateHibernateServer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <%
            int index = 0;
            String indexpar = request.getParameter("index");
            if (indexpar.matches("\\d+")) {
                index = Integer.parseInt(indexpar);

            } else {
                index = 0;
            }
            Session sess = CreateHibernateServer.getSessionFactory().openSession();
            Query qr = sess.createQuery("from PlanTable where id=:id");
            qr.setInteger("id", index);
            List<PlanTable> plan = qr.list();
			if(plan.size()==0){
			out.println("您的内容被服务器吃掉了");
			return;
			}
        %>

        簡介<%=plan.get(0).getAbstracts()%><br>
        特色<%=plan.get(0).getCharacteristic()%><br>
        封面<%=plan.get(0).getCover()%><br>
        旅遊類型<%=plan.get(0).getPlantype()%><br>
        主題<%=plan.get(0).getTopic()%>
        <br>  

        <% qr = sess.createQuery("from MemoTable where planId=:id");
            qr.setInteger("id", index);
            List<MemoTable> memo = qr.list();
            for (int i = 0; i < memo.size(); i++) {
        %>
        第 <%=(i + 1)%>天<br>

        <%
            int day = memo.get(i).getDay();
        %>

        行程介紹<%=memo.get(day - 1).getMemo()%><br>
        交通<%=memo.get(day - 1).getMemoTraffic()%><br>

        <%
            qr = sess.createQuery("from FoodTable where memoId=:id");
            qr.setInteger("id", memo.get(i).getId());
            List<FoodTable> food = qr.list();
            for (int j = 0; j < food.size(); j++) {
                qr = sess.createQuery("select p.annexURL from AnnexTable p where foodId=:foodid");
                qr.setInteger("foodid", food.get(j).getId());
                List<AnnexTable> photofood = qr.list();
                for (int k = 0; k < photofood.size(); k++) {%>

        <img src="<%="/IAAA/" + photofood.get(k)%>"/>



        <%
                }
            }

            qr = sess.createQuery("from HotelTable where memoId=:id");
            qr.setInteger("id", memo.get(i).getId());
            List<HotelTable> hotel = qr.list();
            for (int j = 0; j < hotel.size(); j++) {
        %>


        地址 <%=hotel.get(j).getHotelAddress()%><br>
        電話 <%=hotel.get(j).getHotelTel()%>    <br>
        備註 <%=hotel.get(j).getHtotelRemark()%>   <br>
        店名 <%=hotel.get(j).getHotelName()%>   <br>
        <%

            qr = sess.createQuery("select p.annexURL from AnnexTable p where hotelId=:hotelid");
            qr.setInteger("hotelid", hotel.get(j).getId());
            List<AnnexTable> photohotel = qr.list();
            for (int k = 0; k < photohotel.size(); k++) {%>

        <img src="<%="/IAAA/" + photohotel.get(k)%>"/>

        <%
                }
            }
            qr = sess.createQuery("from PointTable where memoId=:id");
            qr.setInteger("id", memo.get(i).getId());
            List<PointTable> Point = qr.list();
            for (int j = 0; j < Point.size(); j++) {
        %>


        景點名稱 <%=Point.get(j).getPointName()%><br>
        景點總結
        <%=Point.get(j).getPointSummary()%>    <br>

        <%

            qr = sess.createQuery("select p.annexURL from AnnexTable p where pointid=:Point");
            qr.setInteger("Point", Point.get(j).getId());
            List<AnnexTable> photofood = qr.list();
            for (int k = 0; k < photofood.size(); k++) {%>

        <img src="<%="/IAAA/" + photofood.get(k)%>"/>

        <%
                    }
                }

            }
        %>

    </body>
</html>
