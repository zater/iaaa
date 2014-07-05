/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.zater.CS.AnnexTable;
import tk.zater.CS.FoodTable;
import tk.zater.CS.HotelTable;
import tk.zater.CS.LocationTable;
import tk.zater.CS.MemoTable;
import tk.zater.CS.MonthTable;
import tk.zater.CS.PlanTable;
import tk.zater.CS.PointTable;
import tk.zater.CreateSession.CreateHibernateServer;

/**
 *
 * @author zater
 */
public class addTravel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            Session session = CreateHibernateServer.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            PlanTable plan = new PlanTable();
            plan.setTopic(request.getParameter("topic"));
            plan.setDays(Integer.parseInt(request.getParameter("Days")));
            plan.setDownload(0);
            plan.setScore(0);
            int price = Integer.parseInt(request.getParameter("pay"));
            plan.setPrice(price);
            if (price != 0) {
                plan.setGone(true);
            } else {
                plan.setGone(false);
            }
            plan.setAbstracts(request.getParameter("abstract"));
            plan.setPlantype(request.getParameter("plantype"));
            plan.setCover(request.getParameter("cover"));
            plan.setCharacteristic(request.getParameter("characteristic"));
            String userid = null;
            try {
                userid = String.valueOf(request.getSession().getAttribute("userid"));
            } catch (Exception e) {
                out.println("請先登錄");
                return;
            }
            if (userid == null) {
                out.println("請先登錄");
                return;
            }
            if (userid.matches("\\d+")) {
                plan.setUserId(Integer.parseInt(userid));
            } else {

                out.println("請先登錄");
                return;
            }
            int planid = (int) session.save(plan);
            int month1 = request.getParameter("month1").matches("\\d+") ? Integer.parseInt(request.getParameter("month1")) : 1;
            int month2 = request.getParameter("month2").matches("\\d+") ? Integer.parseInt(request.getParameter("month2")) : 12;
            for (int i = month1; i <= month2; i++) {
                session.save(new MonthTable(planid, i));
            }
            int location = Integer.parseInt(request.getParameter("location"));

            for (int i = 1; i <= location; i++) {
                LocationTable locationTable = new LocationTable(planid, request.getParameter("locationName" + i));
                session.save(locationTable);
            }
            for (int i = 1; i <= Integer.parseInt(request.getParameter("Days")); i++) {
                String memo = request.getParameter("day" + i + "-memo");
                String traffic = request.getParameter("day" + i + "-traffic");
                MemoTable memoday = new MemoTable(planid, i, memo, traffic);
                int memoID = (int) session.save(memoday);
                int eatcount = Integer.parseInt(request.getParameter("day" + i + "-eatcount"));
                int sitecount = Integer.parseInt(request.getParameter("day" + i + "-sitecount"));
                int pointcount = Integer.parseInt(request.getParameter("day" + i + "-pointcount"));

                for (int j = 1; j <= eatcount; j++) {
                    String foodStore = request.getParameter("day" + i + "-foodStore-" + j);
                    String foodTel = request.getParameter("day" + i + "-foodTel-" + j);
                    String foodAddress = request.getParameter("day" + i + "-foodAddress-" + j);
                    String foodTime = request.getParameter("day" + i + "-foodTime-" + j);
                    String foodRemark = request.getParameter("day" + i + "-foodRemark-" + j);
                    FoodTable food = new FoodTable(memoID, foodStore, foodTel, foodAddress, foodTime, foodRemark);
                    int foodid = (int) session.save(food);
                    int piccount = Integer.parseInt(request.getParameter("day" + i + "-foodpiccount-" + j));
                    for (int k = 1; k <= piccount; k++) {
                        AnnexTable photo = new AnnexTable();
                        photo.setFoodId(foodid);
                        photo.setAnnexURL(request.getParameter("day" + i + "-foodpiccount-" +"pic" + k+"-"+j));
                        session.save(photo);
                    }
                }
                for (int j = 1; j <= sitecount; j++) {
                    String Hotelname = request.getParameter("day" + i + "-hotel-" + j);
                    String HotelTel = request.getParameter("day" + i + "-hotelTel-" + j);
                    String Hoteladdress = request.getParameter("day" + i + "-hotelAddress-" + j);
                    String HotelRemark = request.getParameter("day" + i + "-hotelRemark-" + j);
                    HotelTable hotel = new HotelTable();
                    hotel.setHotelAddress(Hoteladdress);
                    hotel.setHotelName(Hotelname);
                    hotel.setHotelTel(HotelTel);
                    hotel.setMemoId(memoID);
                    hotel.setHtotelRemark(HotelRemark);
                    int hotelid = (int) session.save(hotel);
                    int piccount = Integer.parseInt(request.getParameter("day" + i + "-hotelpiccount-" + j));
                    for (int k = 1; k <= piccount; k++) {
                        AnnexTable photo = new AnnexTable();
                        photo.setHotelId(hotelid);
                        photo.setAnnexURL(request.getParameter("day" + i + "-hotelpiccount-" +"pic" + k+"-"+j));
                        session.save(photo);
                    }
                }

                for (int j = 1; j <= pointcount; j++) {
                    String PointName = request.getParameter("day" + i + "-pointName-" + j);
                    String PointSummary = request.getParameter("day" + i + "-hotelTel-" + j);

                    PointTable point = new PointTable();
                    point.setMemoId(memoID);
                    point.setPointName(PointName);
                    point.setPointSummary(PointSummary);
                    point.setPointNum(j);
                    int placecount = (int) session.save(point);
                    int piccount = Integer.parseInt(request.getParameter("day" + i + "-placepiccount-" + j));
                    for (int k = 1; k <= piccount; k++) {
                        AnnexTable photo = new AnnexTable();
                        photo.setPointId(placecount);
                        photo.setAnnexURL(request.getParameter("day" + i + "-placepiccount-" +"pic" + k+"-"+j));
                        session.save(photo);
                    }
                }

            }

            tx.commit();
            response.sendRedirect("add.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
