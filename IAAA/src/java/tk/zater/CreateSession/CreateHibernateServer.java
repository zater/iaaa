/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.CreateSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 *
 * @author zater
 */
public class CreateHibernateServer extends HttpServlet {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static String EnableFileUpload;
    public static String uploadpath;

    public void setupload(ServletConfig config) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        System.out.println(config.getServletContext().getRealPath("")+"\\conf.propeties");
        prop.load(new FileInputStream(new File(config.getServletContext().getRealPath("")+"\\conf.propeties")));
        EnableFileUpload = prop.getProperty("EnableFileUpload");
        uploadpath = prop.getProperty("uploadpath");
        System.out.println("-------------------------");
        System.out.println(EnableFileUpload);
        System.out.println(uploadpath );
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
        
            super.init(config); //To change body of generated methods, choose Tools | Templates.
           // setupload(config);
            buildSessionFactory();
       
    }



    private static SessionFactory buildSessionFactory() {
        Configuration conf=new Configuration().configure();
        ServiceRegistry  sr=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        sessionFactory = conf.buildSessionFactory(sr);

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

   
}
