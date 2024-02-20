package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class rentpayDAO extends Connect{
   private static rentpayDAO instance; 
   static PreparedStatement addPayment;
   PreparedStatement payId;
   PreparedStatement timeDiff;
   PreparedStatement payAmount;
   private rentpayDAO() throws SQLException{
        addPayment=con.prepareStatement("INSERT INTO rent_pay(pay_amount,tenant_id) VALUES(?,?)");
        payId=con.prepareStatement("SELECT MAX(pay_id) FROM rent_pay WHERE tenant_id=?");
        timeDiff=con.prepareStatement("SELECT TIMEDIFF(CURRENT_TIMESTAMP,pay_date) FROM rent_pay WHERE pay_id=?");
        payAmount=con.prepareStatement("SELECT pay_amount FROM rent_pay WHERE pay_id=?");
   }
   public static rentpayDAO getInstance() throws SQLException{
    if(instance==null){
        instance=new rentpayDAO();
    }
    return instance;
   }
   public void addPaymentData(int amount,int t_id) throws SQLException{
        addPayment.setInt(1, amount);
        addPayment.setInt(2, t_id);
        addPayment.executeUpdate();
   }
   public int getPayId(int id) throws SQLException{
     payId.setInt(1, id);
     ResultSet rs=payId.executeQuery();
     rs.next();
     return rs.getInt(1);
   }
   public String getTimeDiff(int p_id) throws SQLException{
     timeDiff.setInt(1, p_id);
     ResultSet rs=timeDiff.executeQuery();
     rs.next();
     return rs.getString(1);
   }
   public int getPayAmount(int p_id) throws SQLException{
     payAmount.setInt(1, p_id);
     ResultSet rs=payAmount.executeQuery();
     rs.next();
     return rs.getInt(1);
   }
}
