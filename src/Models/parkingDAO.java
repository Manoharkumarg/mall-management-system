package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class parkingDAO extends Connect {
    private static parkingDAO instance;
    PreparedStatement parkedCount;
    PreparedStatement addParking;
    PreparedStatement dateDifference;
    PreparedStatement slotId;
    PreparedStatement changeStatus;
    private parkingDAO() throws SQLException{
        parkedCount=con.prepareStatement("SELECT COUNT(park_id) FROM parking WHERE slot_id=? AND park_status=false");
        addParking=con.prepareStatement("INSERT INTO parking(park_status,slot_id) VALUES(?,?)");
        dateDifference=con.prepareStatement("SELECT TIMEDIFF(CURRENT_TIMESTAMP,park_date) FROM parking WHERE Park_id=?;");
        slotId=con.prepareStatement("SELECT slot_id FROM parking WHERE park_id=?");
        changeStatus=con.prepareStatement("UPDATE parking SET park_status=true WHERE park_id=?");
    }
    public static parkingDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new parkingDAO();
        }
        return instance;
    }
    public int getParkedCount(int id) throws SQLException{
        parkedCount.setInt(1,id);
        ResultSet rs=parkedCount.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void addParkingData(int id) throws SQLException{
        addParking.setBoolean(1, false);
        addParking.setInt(2, id);
        addParking.executeUpdate();
    }
    public int getParkId() throws SQLException{
        ResultSet rs=st.executeQuery("SELECT MAX(park_id) FROM parking");
        rs.next();
        return rs.getInt(1);
    }
    public String getTimeDifference(int id) throws SQLException{
        dateDifference.setInt(1, id);
        ResultSet rs=dateDifference.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    public int getSlotId(int id) throws SQLException{
        slotId.setInt(1, id);
        ResultSet rs=slotId.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return 0;
    }
    public void changeStatusById(int id) throws SQLException{
        changeStatus.setInt(1, id);
        changeStatus.executeUpdate();
    }
}
