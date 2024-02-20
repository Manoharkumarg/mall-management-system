package Controllers;

import java.sql.SQLException;

import Models.loginDAO;
import Models.userDAO;

public class UserControll {
    public static int checkLogin(String email,String password) throws SQLException{
        loginDAO l=loginDAO.getInstance();
        int u_id=l.getUserId(email,password);
        if(u_id==0){
            return 0;
        }
        else{
            userDAO u=userDAO.getInstance();
            String role=u.getUserRole(u_id);
            if(role=="admin"){
                return 1;
            }
            else{
                return 2;
            }
        }
    }
}