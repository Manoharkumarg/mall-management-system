package Models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class parkpayDAO extends Connect{
    private static parkpayDAO instance;
    PreparedStatement addPayment;
    private parkpayDAO() throws SQLException{
        addPayment=con.prepareStatement("INSERT INTO park_pay(pay_amount,park_id) VALUES(?,?)");
    }
    public static parkpayDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new parkpayDAO();
        }
        return instance;
    }
    public void addPaymentData(int amount,int id) throws SQLException{
        addPayment.setInt(1, amount);
        addPayment.setInt(2, id);
        addPayment.executeUpdate();
    }
}
