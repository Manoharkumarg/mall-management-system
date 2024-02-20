package Controllers;

public class parkingController {
    public static int getTotalHours(String date){
        String a[]=date.split(":");
        int hours=Integer.parseInt(a[0].substring(0,2));
        hours=hours+1;
        return hours;
        
    }
    public static int getTotalAmount(int hours,int rent){
        int amount=rent*hours;
        return amount;
    }
}
