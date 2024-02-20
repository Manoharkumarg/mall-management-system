package Models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class customerDAO extends Connect{
    private static customerDAO instance;
    PreparedStatement newCustomer;
    private customerDAO() throws SQLException{
        newCustomer=con.prepareStatement("INSERT INTO customer(cust_name) VALUES(?)");
    }
    public static customerDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new customerDAO();
        }
        return instance;
    }
    public void addNewCustomer(String name) throws SQLException{
        newCustomer.setString(1, name);
        newCustomer.executeUpdate();
    }
}
