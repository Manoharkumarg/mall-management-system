package Controllers;

import Models.loginDAO;
import Resources.loginDTO;

public class UserControll {
    public int login(String email,String password)throws Exception{
        loginDAO login=loginDAO.getInstance();
        loginDTO user=login.getLoginData(email);
        if(user==null){
            throw new Exception("Invalid user");
        }
        if(!user.getPassword().equals(password)){
            throw new Exception("Invalid password");
        }
        if(user.getRole().equals("admin")){
            return 1;
        }
        return 2;
    }
}
