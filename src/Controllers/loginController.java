package Controllers;

import java.sql.SQLException;

import Models.loginDAO;

public class loginController {
    public static void addLoginData(String email,String passwrod,int u_id) throws SQLException{
        loginDAO login=loginDAO.getInstance();
        login.addNewLogin(email, passwrod, u_id);
    }
}
