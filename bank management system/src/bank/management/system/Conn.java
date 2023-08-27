
package bank.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        
        try{
//TO register the driver
//            Class.forName(com.mysql.cj.jdbc.Driver);
// To create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Arijit*1");
//  To create Statement
            s = c.createStatement();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
