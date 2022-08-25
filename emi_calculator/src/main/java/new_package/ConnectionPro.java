package new_package;

import java.sql.*;


public class ConnectionPro {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","almamun@123");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
