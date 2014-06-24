/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.zater.CS.UserTable;
import tk.zater.CreateSession.CreateHibernateServer;

/**
 *
 * @author zater
 */
public class reg extends HttpServlet {

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
            try {
                String accountName = request.getParameter("accountName");
                out.println(accountName);
                String pwd = request.getParameter("pwd");
                String userName = request.getParameter("userName");
                String email = request.getParameter("email");
                Date addDate = new Date();
                String address = request.getParameter("address");
                String tel = request.getParameter("tel");
                int userLv = 0;
                int userScore = 0;
                String inrtoduction = request.getParameter("inrtoduction");
                UserTable usr = new UserTable(accountName, pwd, userName, email, addDate, address, tel, userLv, userScore, inrtoduction);
                if ("".equals(accountName) || "".equals(pwd) || "".equals(email) || "".equals(userName)) {
                    out.println("資料未填寫完整");
                } else if (!email.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+")) {
                    out.println("email不正確");
                } else if (pwd.length() < 6 || pwd.length() > 20) {
                    out.print("密碼長度不正確");
                } else {
                    Session sess = CreateHibernateServer.getSessionFactory().openSession();
                    Query search = sess.createQuery("from UserTable where accountName=:accountname");
                    search.setString("accountname", accountName);
                    Iterator<UserTable> get = search.iterate();
                    int i = 0;
                    while (get.hasNext()) {
                        i++;
                    }
                    if (i == 0) {
                        Transaction tx = sess.beginTransaction();
                        sess.save(usr);
                        tx.commit();
                        out.println("成功");
                        sess.close();
                    } else {

                        out.println("用戶名被註冊");
                    }
                }
            } catch (org.hibernate.PropertyValueException e) {
                out.println("資料未填寫完整");
            } catch (NullPointerException e) {
                out.println("參數不正確！請不要嘗試破解");
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
