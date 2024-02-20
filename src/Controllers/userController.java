package Controllers;

import java.sql.SQLException;

import Models.loginDAO;
import Models.userDAO;

public class userController {
    public static int checkLogin(String email,String password) throws SQLException{
        loginDAO l=loginDAO.getInstance();
        int u_id=l.getUserId(email,password);
        if(u_id==0){
            return 0;
        }
        else{
            userDAO u=userDAO.getInstance();
            String role=u.getUserRole(u_id);
            if(role.equals("admin")){
                return 1;
            }
            else{
                return 2;
            }
        }
    }
    public static int addNewAdmin(String name) throws SQLException{
        userDAO user=userDAO.getInstance();
        user.addNewAdmin(name);
        int u_id=user.getUserId(name);
        return u_id;
    }
}