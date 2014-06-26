/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tk.zater.CS.PlanTable;

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
            /* TODO output your page here. You may use following sample code. */

            String userid = request.getParameter("userId");
            String locationName = request.getParameter("locationName");
            String plantype = request.getParameter("plantype");
            String  score = request.getParameter("score");
            String pay = request.getParameter("pay");
            Iterator<PlanTable>a;
            Iterator<PlanTable>b;
            if (!("".equals(userid) && "".equals(pay) && "".equals(plantype) && "".equals(score))) {
                StringBuffer buf = new StringBuffer("from PlanTable where ");
                boolean flag = false;
                if (!"".equals(userid)) {
                    buf.append(" userId=" + userid);
                    flag = true;
                }
 
                if (!"".equals(plantype)) {
                    if (flag == true) {
                        buf.append(" and ");
                    }
                    buf.append(" plantype= " + plantype);
                    flag = true;
                }

                if (!"".equals(pay)) {
                    if (flag == true) {
                        buf.append(" and ");
                    }
                    buf.append(" pay<= " + pay);
                    flag = true;
                }
                if (!"".equals(score)) {
                    if (flag == true) {
                        buf.append(" and ");
                    }
                    buf.append(" pay<= " + pay);
                    flag = true;
                }
            }
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
