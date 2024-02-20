package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginDAO extends Connect {
    private static loginDAO instance;
    PreparedStatement getLogin;
    PreparedStatement addLogin;
    PreparedStatement userId;
    private loginDAO() throws SQLException{
        addLogin=con.prepareStatement("INSERT INTO login VALUES(?,?,?)");
        userId=con.prepareStatement("SELECT user_id FROM login WHERE email=? AND password=?");
    }

    public static loginDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new loginDAO();
        }
        return instance;
    }
    public void addNewLogin(String email,String pass,int id) throws SQLException{
        addLogin.setString(1, email);
        addLogin.setString(2, pass);
        addLogin.setInt(3, id);
        addLogin.executeUpdate();
    }
    public int getUserId(String email,String password) throws SQLException{
        userId.setString(1, email);
        userId.setString(2, password);
        ResultSet rs=userId.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return 0;
    }
}