package Views;

import java.sql.SQLException;

import Controllers.parkingController;
import Models.parkingDAO;
import Models.parkpayDAO;
import Models.slotDAO;
import Util.Input;

public class Parking extends Input{
    public static void parkingFunctions() throws SQLException{
        System.out.println("Enter 1 to PARK your vehicle");
        System.out.println("Enter 2 to TAKE your vehicle");
        int p=sc.nextInt();
        if(p==1){
            System.out.println("Enter your vehicle category(2/4)");
            int c=sc.nextInt();
            if(c==2 || c==4){
                slotDAO s=slotDAO.getInstance();
                int capacity=s.getCapacityById(c);
                int s_id=s.getId(c);
                int s_rent=s.getRentById(s_id);
                System.out.println("Rent for 1 hour is "+s_rent);
                parkingDAO park=parkingDAO.getInstance();
                int parkedCount=park.getParkedCount(s_id);
                if(parkedCount<capacity){
                    park.addParkingData(s_id);
                    int p_id=park.getParkId();
                    System.out.println("Your parking ID is "+p_id);
                    System.out.println("Enter parking ID while taking your vehicle");
                }
                else{
                    System.out.println("Parking is FULL");
                }
            }
            else{
                System.out.println("Invalid choice");
                return;
            }
        }
        else if(p==2){
            System.out.println("Enter your vehicle's parking ID");
            int p_id=sc.nextInt();
            parkingDAO park=parkingDAO.getInstance();
            int s_id=park.getSlotId(p_id);
            if(s_id==0){
                System.out.println("Invalid parking ID");
                return;
            }
            slotDAO slot=slotDAO.getInstance();
            int rent=slot.getRentById(s_id);
            String date=park.getTimeDifference(p_id);
            int hours=parkingController.getTotalHours(date);
            System.out.println("Total parking time is "+hours+" hours");
            int amount=parkingController.getTotalAmount(hours,rent);
            System.out.println("Total amount is "+amount);
            System.out.println("Enter 1 to pay amount");
            int option=sc.nextInt();
            if(option==1){
                parkpayDAO pay=parkpayDAO.getInstance();
                pay.addPaymentData(amount, p_id);
                park.changeStatusById(p_id);
                System.out.println("Amount is payed you can take your vehicle");
            }
            else{
                System.out.println("Invalid choice");
                return;
            }
        }
        else{
            System.out.println("Invalid choice");
            return;
        }
    }
}
