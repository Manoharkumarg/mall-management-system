package Views;

import java.sql.SQLException;

import Controllers.userController;
import Controllers.blockController;
import Controllers.loginController;
import Controllers.rentpayController;
import Controllers.tenantController;
import Util.Input;

public class User extends Input{
    public static void login() throws SQLException{
        System.out.println("Enter your Email ");
        String email=sc.next();
        System.out.println("Enter your password");
        String password=sc.next();
        int user=userController.checkLogin(email,password);
        if(user==0){
            System.out.println("Invalid credentials");
            return;
        }
        else if(user==1){
            System.out.println("Enter 1 to add new ADMIN");
            int a=sc.nextInt();
            if(a==1){
                System.out.println("Enter new admin's name");
                String name=sc.next();
                int u_id=userController.addNewAdmin(name);
                System.out.println("Enter new admin's email");
                String Email=sc.next();
                if(!Email.contains("@gmail.com")){
                    System.out.println("Invalid Email");
                    return;
                }
                System.out.println("Enter new admin's password");
                String Password="";
                while(Password.length()<8){
                    Password=sc.next();
                    if(Password.length()<8){
                        System.out.println("Create a STRONG password");
                    }
                }
                loginController.addLoginData(Email,Password,u_id);
                System.out.println("New admin has been added successfully");

                }
            else{
                System.out.println("Invalid choice");
            }
        }
        else{
            System.out.println("Enter 1 to pay rent");
            System.out.println("Enter 2 to terminate the lease");
            int t=sc.nextInt();
            if(t==1){
                System.out.println("Enter your name");
                String name=sc.next();
                int t_id=tenantController.getTenentIdByName(name);
                if(t_id==0){
                    System.out.println("Invalid credentials");
                    return;
                }
                int p_id=rentpayController.getPayIdByTenantId(t_id);
                int date=rentpayController.getTimeDiff(p_id);
                boolean pay=rentpayController.checkForRentpay(date);
                if(pay){
                    int rent=rentpayController.getPayAmount(p_id);
                    System.out.println("Enter 1 to pay rupees "+rent);
                    int r=sc.nextInt();
                    if(r==1){
                        rentpayController.addPaymentData(rent, t_id);
                        System.out.println("Your rent for this month is payed successfully");
                    }
                    else{
                        System.out.println("Invalid choice");
                        return;
                    }
                }
                else{
                    System.out.println("Your payment for this month has been done");
                    return;
                }
            }
            else if(t==2){
                System.out.println("Enter your name");
                String name=sc.next();
                int t_id=tenantController.getTenentIdByName(name);
                if(t_id==0){
                    System.out.println("Invalid credentials");
                    return;
                }
                int b_id=tenantController.getBlockId(t_id);
                blockController.changeBLockStatus(b_id);
                tenantController.changeTenantStatus(t_id);
                System.out.println("Your lease has been terminated successfully");
            }
            else{
                System.out.println("Invalid choice");
                return;
            }
        }
    }
}
