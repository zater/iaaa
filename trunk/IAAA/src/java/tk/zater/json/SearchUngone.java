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
import tk.zater.CS.PlanTable;
import tk.zater.CreateSession.CreateHibernateServer;

/**
 *
 * @author zater
 */
public class SearchUngone extends HttpServlet {

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
            String id = request.getParameter("id");
            String userlv;
            try {
                userlv = String.valueOf(request.getSession().getAttribute("userLV"));
            } catch (Exception e) {
                out.println("請先登錄");
                return;
            }
            if (userlv == null) {
                out.println("請先登錄");
                return;
            }
            if (userlv.equals("5")) {
            } else {
                out.println("permission deny");
                return;
            }

            /* TODO output your page here. You may use following sample code. */
            JSONObject output = new JSONObject();
            JSONArray ans = new JSONArray();

            Session sess = CreateHibernateServer.getSessionFactory().openSession();
            Query qr = sess.createQuery("from PlanTable where gone=true");

            List<PlanTable> plan = qr.list();
            for (int i = 0; i < plan.size(); i++) {
                PlanTable pl = plan.get(0);
                JSONObject planObject = new JSONObject();
                planObject.put("Characteristic", pl.getCharacteristic());
                planObject.put("Abstracts", pl.getAbstracts());
                planObject.put("Cover", pl.getCover());
                qr = sess.createQuery("select l.accountName from UserTable l where id=:id");
                qr.setInteger("id", pl.getUserId());
                qr.list();
                planObject.put("UserID", qr.list().get(0));
                planObject.put("Topic", pl.getTopic());

                planObject.put("Days", pl.getDays());
                planObject.put("Price", pl.getPrice());
                planObject.put("Score", pl.getScore());
                planObject.put("Download", pl.getDownload());
                qr = sess.createQuery("select l.locationName from LocationTable l where planid=:id");
                qr.setInteger("id", plan.get(0).getId());
                JSONArray location = JSONArray.fromObject(qr.list());
                ans.add(planObject);
                ans.add(location);

            }
            output.put("location", ans);
            out.println(output);
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
