
package dbconnect;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;

public class DataBaseHelper {   
     
    private static DataBaseHelper db; 
    public Connection conn = null;
    private Statement statement;
    private DataBaseHelper() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "steganography";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized DataBaseHelper getDbCon() {
        if ( db == null ) {
            db = new DataBaseHelper();
        }
        return db;
    }

    public ResultSet getResult(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    
}
