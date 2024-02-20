package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO extends Connect{
    private static userDAO instance;
    PreparedStatement addUser;
    PreparedStatement addAdmin;
    PreparedStatement getUser;
    PreparedStatement getRole;
    private userDAO() throws SQLException{
        addUser=con.prepareStatement("INSERT INTO user(user_name,user_role,tenant_id) VALUES(?,?,?)");
        getUser=con.prepareStatement("SELECT user_id FROM user WHERE user_name=?");
        getRole=con.prepareStatement("SELECT user_role FROM user WHERE user_id=?");
        addAdmin=con.prepareStatement("INSERT INTO user(user_name,user_role) VALUES(?,?)");
    }
    public static userDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new userDAO();
        }
        return instance;
    }
    public void addNewUser(String name,int t_id) throws SQLException{
        addUser.setString(1, name);
        addUser.setString(2, "tenant");
        addUser.setInt(3, t_id);
        addUser.executeUpdate();
    }
    public int getUserId(String name) throws SQLException{
        getUser.setString(1, name);
        ResultSet rs=getUser.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return 0;
    }
    public String getUserRole(int u_id) throws SQLException{
        getRole.setInt(1, u_id);
        ResultSet rs=getRole.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    public void addNewAdmin(String name) throws SQLException{
        addAdmin.setString(1, name);
        addAdmin.setString(2, "admin");
        addAdmin.executeUpdate();
    }
}
