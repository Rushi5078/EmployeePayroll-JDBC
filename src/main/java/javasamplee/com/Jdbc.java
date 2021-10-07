package javasamplee.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

public class Jdbc {
	
	public static void main(String[] args)
	{
        String jdbcURL = "jdbc:mysql://localhost:3306/payrolservice?useSSL=false";
        String userName = "root";
        String password = "Rushi@123";
        Connection connection;
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } 
        catch (ClassNotFoundException e)
        {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        listDrivers();

        try 
        {
            System.out.println("Connecting to database : " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful" + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	/*
	 * @purpose: To check all driver are register with JDBC.
	 */
     private static void listDrivers()
     {
        Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
           Driver driverClass = (Driver) driverList.nextElement();
           System.out.println("  " + driverClass.getClass().getName());
      }
    }
}
	


