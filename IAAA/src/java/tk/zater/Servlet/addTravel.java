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
import tk.zater.CS.MemoTable;
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
            Session session = CreateHibernateServer.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            PlanTable plan = new PlanTable();
            plan.setTopic(request.getParameter("topic"));
            plan.setDays(Integer.parseInt(request.getParameter("Days")));
            plan.setDownload(0);
            plan.setScore(0);
            plan.setAbstracts(request.getParameter("abstract"));
            plan.setPlantype(request.getParameter("plantype"));
            plan.setCover(request.getParameter("cover"));
            plan.setCharacteristic(request.getParameter("characteristic"));
            String userid = null;
            try {
                userid = (String) request.getAttribute("userid");
            } catch (Exception e) {
                out.println("請先登錄");
                return;
            }
            if (userid == null) {
                out.println("請先登錄");
                return;
            }
            if (userid.matches("\\d+")) {
                plan.setUserId(Integer.parseInt((String) request.getAttribute("userid")));
            } else {

                out.println("請先登錄");
                return;
            }
            int planid = (int) session.save(plan);
            tx.commit();
            out.println(planid);
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
