package travel.managnment.system;
import java.sql.*;
// import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class Connect {
    Connection c;
   Statement s;
   

    Connect() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root","Ranjan@8523"); //? for stablishing connection
            s=c.createStatement(); //? creating statment
           


        } catch (Exception e) {
            e.printStackTrace();// print exception
        }
    }
}
