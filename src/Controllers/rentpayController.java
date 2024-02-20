package Controllers;

import java.sql.SQLException;

import Models.rentpayDAO;

public class rentpayController {
    public static int getPayIdByTenantId(int t_id) throws SQLException{
        rentpayDAO rent=rentpayDAO.getInstance();
        int p_id=rent.getPayId(t_id);
        return p_id;
    }
    public static int getTimeDiff(int p_id) throws SQLException{
        rentpayDAO rent=rentpayDAO.getInstance();
        String date[]=rent.getTimeDiff(p_id).split(":");
        int d=Integer.parseInt(date[0]);
        return d;
    }
    public static boolean checkForRentpay(int date){
        if(date<=730){
            return false;
        }
        return true;
    }
    public static int getPayAmount(int p_id) throws SQLException{
        rentpayDAO rent=rentpayDAO.getInstance();
        int amount=rent.getPayAmount(p_id);
        return amount;
    }
    public static void addPaymentData(int amount,int t_id) throws SQLException{
        rentpayDAO pay=rentpayDAO.getInstance();
        pay.addPaymentData(amount, t_id);
    }
}
