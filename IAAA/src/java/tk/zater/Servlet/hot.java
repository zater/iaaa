/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.zater.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
public class hot extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            		Session sess = CreateHibernateServer.getSessionFactory().openSession();
                Query qr = sess.createQuery("from PlanTable p order by p.score desc");
               
		Iterator<PlanTable> a = qr.iterate();
		PlanTable pl=a.next();
		JSONObject planObject = new JSONObject();
                planObject.put("Characteristic", pl.getCharacteristic());
                planObject.put("Abstracts", pl.getAbstracts());
                planObject.put("id", pl.getId());
                qr = sess.createQuery("select l.accountName from UserTable l where id=:id");
                qr.setInteger("id", pl.getUserId());
                qr.list();
                planObject.put("UserID", qr.list().get(0));
                planObject.put("Topic", pl.getTopic());
                planObject.put("cover", pl.getCover());
                planObject.put("Days", pl.getDays());
                planObject.put("Price", pl.getPrice());
                planObject.put("Score", pl.getScore());
                planObject.put("Download", pl.getDownload());
                qr = sess.createQuery("select l.locationName from LocationTable l where planid=:id");
                qr.setInteger("id", pl.getId());
                JSONArray location = JSONArray.fromObject(qr.list());
                planObject.put("place", location);
                out.println(planObject);
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
