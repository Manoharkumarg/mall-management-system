import java.sql.SQLException;

import Controllers.UserControll;
import Models.Connect;
import Util.Input;

public class App extends Input{
    public static void main(String[] args) throws Exception {
        try{
            Connect.getConnection();
            System.out.println("connected");
        }
        catch(SQLException err){
            System.out.println("Database Connection error");
            System.out.println(err);
            return;
        }
        System.out.print("enetr email: ");
        String email=sc.nextLine();
        System.out.print("Enter password");
        String password=sc.nextLine();
        UserControll us=new UserControll();
        int check=us.login(email, password);
        if(check==1){
            System.out.println("Admin");
        }
        else{
            System.out.println("Tenant");
        }
    }
}
