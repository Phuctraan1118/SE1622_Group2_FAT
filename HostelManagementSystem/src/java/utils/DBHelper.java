/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

/**
 *
 * @author buikh
 */
public class DBHelper {

    public static Connection makeConnection()
            throws ClassNotFoundException, SQLException {

        //1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create Connection String
        String url = "jdbc:sqlserver://"
                + "localhost:1433"
                + ";databaseName=HostelManagement";
        //3. Open Connection
        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;

    }

    public static void getSiteMaps(ServletContext context) throws IOException {
        //get properties filemap
        String filePath = context.getInitParameter("SITE_MAPS_FILE_PATH");

        //convert Properties file into inputStream
        InputStream is = null;
        is = context.getResourceAsStream(filePath);
        //create property object
        Properties siteMaps = new Properties();
        siteMaps.load(is);
        //store in context Scope
        context.setAttribute("SITEMAPS", siteMaps);
    }
}
