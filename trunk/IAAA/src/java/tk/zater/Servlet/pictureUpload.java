/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.Servlet;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tk.zater.CreateSession.CreateHibernateServer;
import tk.zater.util.CreateFileName;

/**
 *
 * @author zater
 */
public class pictureUpload extends HttpServlet {

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
            throws ServletException, IOException, SmartUploadException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SmartUpload smart = new SmartUpload();
            smart.initialize(this.getServletConfig(), request, response);
            smart.setAllowedFilesList(CreateHibernateServer.EnableFileUpload);
            smart.upload();
            String FileName = new CreateFileName().GetName(request.getRemoteAddr());
            String attachinfo = smart.getFiles().getFile(0).getFileName();
            String fileext[] = attachinfo.split("\\.");
            if (!new File(this.getServletContext().getRealPath("/") +File.separator + CreateHibernateServer.uploadpath).exists()) {
                new File(this.getServletContext().getRealPath("/")+File.separator  + CreateHibernateServer.uploadpath).mkdirs();
            }
            smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+File.separator + CreateHibernateServer.uploadpath + File.separator + FileName + "." + fileext[1]);
            out.println(FileName+ "." + fileext[1]);
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
        try {
            processRequest(request, response);
        } catch (SmartUploadException ex) {
            Logger.getLogger(pictureUpload.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SmartUploadException ex) {
            Logger.getLogger(pictureUpload.class.getName()).log(Level.SEVERE, null, ex);
        }
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
