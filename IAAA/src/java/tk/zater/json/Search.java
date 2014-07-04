/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
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
public class Search extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String userid = request.getParameter("userId");
            String locationName = request.getParameter("locationName");
            String plantype = request.getParameter("plantype");
            String score = request.getParameter("score");
            String pay = request.getParameter("pay");
            Iterator<Integer> a = null;
            Iterator<Integer> b = null;
            if (!("".equals(userid) && "".equals(pay) && "".equals(plantype) && "".equals(score))) {
                StringBuffer buf = new StringBuffer("select l.id from PlanTable l where gone=false ");
                boolean flag = true;
                if (!"".equals(userid)) {
                    if (flag == true) {
                        buf.append(" and ");
                    }
                    buf.append(" l.userId=" + userid);
                    flag = true;
                }

                if (!"".equals(plantype)) {
                    if (flag == true) {
                        buf.append(" and ");
                    }
                    buf.append(" l.plantype= " + plantype);
                    flag = true;
                }

                if (!"".equals(pay)) {
                    if (flag == true) {
                        buf.append(" and ");
                    }
                    buf.append(" l.price <= " + pay);
                    flag = true;
                }
                if (!"".equals(score)) {
                    if (flag == true) {
                        buf.append(" and ");
                    }
                    buf.append(" l.score >= " + score);
                    flag = true;
                }
                Session sess = CreateHibernateServer.getSessionFactory().openSession();
                Query qr = sess.createQuery(buf.toString());
                a = qr.iterate();

            }
            if (!"".equals(locationName)) {
                Session sess = CreateHibernateServer.getSessionFactory().openSession();
                Query qr = sess.createQuery("select l.planId from LocationTable l where locationName=:name");
                qr.setString("name", locationName);
                b = qr.iterate();
            }

            Iterator<Integer> c;
            if (a == null) {
                c = b;
            } else if (b == null) {
                c = a;
            } else {
                TreeSet<Integer> ansset = new TreeSet<>();
                TreeSet<Integer> aset = new TreeSet();
                while (a.hasNext()) {
                    aset.add(a.next());
                }
                while (b.hasNext()) {
                    int id = b.next();
                    if (aset.contains(id)) {
                        ansset.add(id);
                    }
                }
                c = ansset.iterator();
            }

            JSONObject output = new JSONObject();
            JSONArray ans = new JSONArray();
            while (c.hasNext()) {

                Session sess = CreateHibernateServer.getSessionFactory().openSession();
                Query qr = sess.createQuery("from PlanTable where id=:id and gone=false");
                qr.setInteger("id", c.next());
                List<PlanTable> plan = qr.list();
                PlanTable pl = plan.get(0);
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
                qr.setInteger("id", plan.get(0).getId());
                JSONArray location = JSONArray.fromObject(qr.list());
                planObject.put("place", location);
                ans.add(planObject);
               //  ans.add(location);
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
