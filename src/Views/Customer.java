package Views;

import java.sql.SQLException;

import Models.customerDAO;
import Util.Input;

public class Customer extends Input{
    public static void newCustomer() throws SQLException{
        System.out.println("Enter your name");
        String name=sc.next();
        customerDAO cust=customerDAO.getInstance();
        cust.addNewCustomer(name);
        System.out.println("Welcome to our mall");
    }
    
}
