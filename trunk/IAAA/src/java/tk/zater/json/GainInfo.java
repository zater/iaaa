/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import tk.zater.CS.AnnexTable;
import tk.zater.CS.FoodTable;
import tk.zater.CS.HotelTable;
import tk.zater.CS.MemoTable;
import tk.zater.CS.PlanTable;
import tk.zater.CS.PointTable;
import tk.zater.CreateSession.CreateHibernateServer;

/**
 *
 * @author zater
 */
public class GainInfo extends HttpServlet {

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
            JSONObject all = new JSONObject();
            int index = Integer.parseInt(request.getParameter("id"));
            Session sess = CreateHibernateServer.getSessionFactory().openSession();
            Query qr = sess.createQuery("from PlanTable where id=:id");
            qr.setInteger("id", index);
            List<PlanTable> plan = qr.list();
            PlanTable pl = plan.get(0);
            JSONObject planObject = new JSONObject();
            planObject.put("Characteristic", pl.getCharacteristic());
            planObject.put("Abstracts", pl.getAbstracts());
            planObject.put("Cover", pl.getCover());
            planObject.put("UserID", pl.getUserId());
            planObject.put("Topic", pl.getTopic());
            planObject.put("Days", pl.getDays());
            planObject.put("Price", pl.getPrice());
            planObject.put("Score", pl.getScore());
            planObject.put("Download", pl.getDownload());
            all.put("Plan", planObject);
            qr = sess.createQuery("select l.locationName from LocationTable l where planid=:id");
            qr.setInteger("id", plan.get(0).getId());
            JSONArray location = JSONArray.fromObject(qr.list());
            all.put("location", location);
            qr = sess.createQuery("select l.month from MonthTable l where planid=:id");
            qr.setInteger("id", plan.get(0).getId());
            JSONArray month = JSONArray.fromObject(qr.list());
            all.put("month", month);
            JSONArray memo = new JSONArray();
            qr = sess.createQuery("from MemoTable where planId=:id");
            qr.setInteger("id", plan.get(0).getId());
            List<MemoTable> memodays = qr.list();
            for (int i = 0; i < memodays.size(); i++) {
                MemoTable temp = memodays.get(i);
                JSONObject memoday1 = new JSONObject();
                memoday1.put("memoTraffic", temp.getMemoTraffic());
                memoday1.put("Day", temp.getDay());
                memoday1.put("ID", temp.getId());
                JSONArray foodarray = new JSONArray();
                qr = sess.createQuery("from FoodTable where memoId=:id");
                qr.setInteger("id", memodays.get(i).getId());
                List<FoodTable> foodList = qr.list();
                for (int j = 0; j < foodList.size(); j++) {
                    JSONObject foodObject = new JSONObject();
                    FoodTable foodtemp = foodList.get(j);
                    foodObject.put("FoodName", foodtemp.getFoodStore());
                    foodObject.put("FoodAddress", foodtemp.getFoodAddress());
                    foodObject.put("FoodRemark", foodtemp.getFoodRemark());
                    foodObject.put("FoodTel", foodtemp.getFoodTel());
                    foodObject.put("FoodTime", foodtemp.getFoodTime());
                    qr = sess.createQuery("select p.annexURL from AnnexTable p where foodId=:foodid");
                    qr.setInteger("foodid", foodList.get(j).getId());
                    JSONArray foodphoto = JSONArray.fromObject(qr.list());
                    foodObject.put("Annex", foodphoto);
                    foodarray.add(foodObject);
                }
                memoday1.put("food", foodarray);

                JSONArray hotelarray = new JSONArray();
                qr = sess.createQuery("from HotelTable where memoId=:id");
                qr.setInteger("id", memodays.get(i).getId());
                List<HotelTable> HotelList = qr.list();
                for (int j = 0; j < HotelList.size(); j++) {
                    JSONObject hotelObject = new JSONObject();
                    HotelTable hoteltemp = HotelList.get(j);
                    hotelObject.put("HotelName", hoteltemp.getHotelName());
                    hotelObject.put("HotelAddress", hoteltemp.getHotelAddress());
                    hotelObject.put("HotelRemark", hoteltemp.getHtotelRemark());
                    hotelObject.put("HotelTel", hoteltemp.getHotelTel());
                    qr = sess.createQuery("select p.annexURL from AnnexTable p where hotelId=:hotelid");
                    qr.setInteger("hotelid", HotelList.get(j).getId());
                    JSONArray hotelphoto = JSONArray.fromObject(qr.list());
                    hotelObject.put("Annex", hotelphoto);
                    hotelarray.add(hotelObject);
                }
                memoday1.put("hotel", hotelarray);

                JSONArray pointarray = new JSONArray();
                qr = sess.createQuery("from PointTable where memoId=:id");
                qr.setInteger("id", memodays.get(i).getId());
                List<PointTable> pointList = qr.list();
                for (int j = 0; j < pointList.size(); j++) {
                    JSONObject pointObject = new JSONObject();
                    PointTable pointtemp = pointList.get(j);
                    pointObject.put("pointName", pointtemp.getPointName());
                    pointObject.put("pointNumber", pointtemp.getPointNum());
                    pointObject.put("pointSummary", pointtemp.getPointSummary());
                    qr = sess.createQuery("select p.annexURL from AnnexTable p where pointid=:pointid");
                    qr.setInteger("pointid", pointList.get(j).getId());
                    JSONArray pointphoto = JSONArray.fromObject(qr.list());
                    pointObject.put("Annex", pointphoto);
                    pointarray.add(pointObject);
                }
                memoday1.put("point", pointarray);

                memo.add(memoday1);
            }
            all.put("memo", memo);
            out.println(all);
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
