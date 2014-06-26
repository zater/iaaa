<%-- 
    Document   : show
    Created on : 2014/6/25, 下午 10:03:34
    Author     : zater
--%>

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
        <title>JSP Page</title>
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
        %>
        <%=plan.get(0).getAbstracts()%>
        <%=plan.get(0).getCharacteristic()%>
        <%=plan.get(0).getCover()%>


        <% qr = sess.createQuery("from MemoTable where planId=:id");
            qr.setInteger("id", index);
            List<MemoTable> memo = qr.list();
            for (int i = 0; i < memo.size(); i++) {
        %>
        第 <%=(i+1)%>天

        <%
            int day = memo.get(i).getDay();
            qr = sess.createQuery("from FoodTable where memoId=:id");
            qr.setInteger("id", memo.get(i).getId());
            List<FoodTable> food = qr.list();
            out.println(food.size());
            out.println(food.get(i).getId());
            for (int j = 0; j < food.size(); j++) {
                qr = sess.createQuery("annexURL from AnnexTable where foodId=:foodid");
                qr.setInteger("foodid", food.get(j).getId());
                List<AnnexTable> photofood = qr.list();
                out.println(photofood.size());
                for (int k = 0; k < photofood.size(); k++) {
                    out.println("url"+photofood.get(k).getAnnexURL());
        %>
        <img src=<%=photofood.get(i).getAnnexURL()%>/>

        <%
                    }
                }
            }
        %>
        <>
    </body>
</html>
