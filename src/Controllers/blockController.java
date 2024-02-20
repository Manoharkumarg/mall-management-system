package Controllers;
import java.util.ArrayList;
import Models.blockDAO;
import Resources.blockDTO;
import java.sql.SQLException;
public class blockController{
    public static ArrayList<blockDTO> block() throws SQLException{
        blockDAO block=blockDAO.getInstance();
        ArrayList<blockDTO> arr=block.getBlockData();
        return arr; 
    }
    public static void changeBLockStatus(int b_id) throws SQLException{
        blockDAO block=blockDAO.getInstance();
        block.changeBlockStatus(b_id);
    }
}
