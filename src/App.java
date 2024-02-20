import java.sql.SQLException;
import Models.Connect;
import Util.Input;
import Views.Tenant;
import Views.User;
import Views.Customer;
import Views.Parking;

public class App extends Input{
    public static void main(String[] args) throws Exception {
        try{
            Connect.getConnection();
            // System.out.println("connected");
        }
        catch(SQLException err){
            System.out.println("Database Connection error");
            System.out.println(err);
            return;
        }
        while(true){
            try{
                System.out.println("Enter 1 for USER LOGIN");
                System.out.println("Enter 2 to view blocks");
                System.out.println("Enter 3 for CUSTOMER entry");
                System.out.println("Enter 4 for PARKING entry");
                System.out.println("Enter 5 for EXIT");
                int entry=sc.nextInt();
                if(entry==1){
                    User.login();
                }
                else if(entry==2){
                    Tenant.block();
                }
                else if(entry==3){
                    Customer.newCustomer();
                }
                else if(entry==4){
                    Parking.parkingFunctions();
                }
                else if(entry==5){
                    break;
                }
            }
            catch(Exception err){
               System.out.println(err); 
            }
        }
    }
}
