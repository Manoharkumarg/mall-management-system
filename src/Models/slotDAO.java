package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class slotDAO extends Connect {
    private static slotDAO instance;
    PreparedStatement getCapacity;
    PreparedStatement getId;
    PreparedStatement getRent;
    private slotDAO() throws SQLException{
    getCapacity=con.prepareStatement("SELECT slot_capacity FROM slot WHERE slot_category=?");
    getId=con.prepareStatement("SELECT slot_id FROM slot WHERE slot_category=?");
    getRent=con.prepareStatement("SELECT slot_rent FROM slot WHERE slot_id=?");
    }
    public static slotDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new slotDAO();
        }
        return instance;
    }
    public int getCapacityById(int c) throws SQLException{
        getCapacity.setInt(1, c);
        ResultSet rs=getCapacity.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public int getId(int c) throws SQLException{
        getId.setInt(1, c);
        ResultSet rs=getId.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public int getRentById(int id) throws SQLException{
        getRent.setInt(1, id);
        ResultSet rs=getRent.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
}
