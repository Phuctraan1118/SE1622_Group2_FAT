/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import utils.DBHelper;

/**
 *
 * @author buikh
 */
public class MyApplicationServletListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ServletContext context = sce.getServletContext();
        
        try {
            DBHelper.getSiteMaps(context);
        }catch (IOException ex) {
            context.log("MyApplicationServletListener _ IO " + ex.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        
        context.removeAttribute("SITEMAPS");
    }
    
}
