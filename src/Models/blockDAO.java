package Models;
import Resources.blockDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class blockDAO extends Connect {
    private static blockDAO instance;
    static PreparedStatement Rent;
    static PreparedStatement blockAvailability;
    PreparedStatement blockStatus;
    private blockDAO() throws SQLException{
        Rent=con.prepareStatement("SELECT block_rent FROM block WHERE block_id=?");
        blockAvailability=con.prepareStatement("UPDATE block SET block_availability=false WHERE block_id=?");
        blockStatus=con.prepareStatement("UPDATE block SET block_availability=true WHERE block_id=?");
    }

    public static blockDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new blockDAO();
        }
        return instance;
    }

    public ArrayList<blockDTO> getBlockData() throws SQLException{
        ResultSet rs=st.executeQuery("SELECT * FROM block WHERE block_availability=1");
        ArrayList<blockDTO> arr=new ArrayList<>();
        while(rs.next()){
            arr.add(new blockDTO(rs.getInt(1), rs.getBoolean(2),rs.getInt(3), rs.getInt(4)));
        }
        return arr;
    }
    public static int getRent(int id) throws SQLException{
        Rent.setInt(1,id);
        ResultSet rs=Rent.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return 0;

    }
    public static void setBlockAvailability(int id) throws SQLException{
        blockAvailability.setInt(1, id);
        blockAvailability.executeUpdate();
    }
    public void changeBlockStatus(int id) throws SQLException{
        blockStatus.setInt(1, id);
        blockStatus.executeUpdate();
    }
}
