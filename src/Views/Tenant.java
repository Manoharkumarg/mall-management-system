package Views;
import java.util.ArrayList;
import Controllers.blockController;
import Models.blockDAO;
import Models.loginDAO;
import Models.rentpayDAO;
import Models.tenantDAO;
import Models.userDAO;
import Resources.blockDTO;
import Util.Input;
import java.sql.SQLException;
public class Tenant extends Input{
    public static void block() throws SQLException{
        ArrayList<blockDTO> arr=blockController.block();
        for(int i=0;i<arr.size();i++){
            blockDTO data=arr.get(i);
            System.out.print(data.getBlock_id()+" ");
            System.out.print(data.getBlock_availability()+" ");
            System.out.print(data.getBlock_size()+" ");
            System.out.println(data.getBlock_rent()+" ");
        }
        if(arr.size()==0)
        {
            System.out.println("Cuurently no blocks are available");
        }
        System.out.println("Enter 1 to book block");
        System.out.println("Enter 2 exit");
        int book=sc.nextInt();
        if(book==1){
            System.out.println("Enter block ID");
            int b_id=sc.nextInt();
            System.out.println("Enter your Name");
            String name=sc.next();
            System.out.println("Enter your Email");
            String email=sc.next();
            if(!email.contains("@gmail.com")){
                System.out.println("Invalid Email");
                return;
            }
            System.out.println("Create password");
            String password="";
            while(password.length()<8){
                password=sc.next();
                if(password.length()<8){
                    System.out.println("Create a STRONG password");
                }
            }
            int p_amount=blockDAO.getRent(b_id);
            System.out.println("Enter 1 to pay "+p_amount+" and book your block");
            int status=sc.nextInt();
            if(status==1){
                tenantDAO t=tenantDAO.getInstance();
                t.addNewTenant(name, b_id);
                int t_id=t.getTenantId(name);
                userDAO u=userDAO.getInstance();
                u.addNewUser(name, t_id);
                int u_id=u.getUserId(name);
                loginDAO l=loginDAO.getInstance();
                l.addNewLogin(email, password, u_id);
                blockDAO.setBlockAvailability(b_id);
                rentpayDAO r=rentpayDAO.getInstance();
                r.addPaymentData(p_amount, t_id);
                System.out.println("Your block is booked successfully");
                return;
            }
            else{
                return;
            }
        }
        else{
            return;
        }
    }
}
