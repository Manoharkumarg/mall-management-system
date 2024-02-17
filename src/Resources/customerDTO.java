package Resources;

import java.util.Date;

public class customerDTO {
    private int cust_id;
    private String cust_name;
    private Date cust_date;
    public customerDTO(int cust_id,String cust_name,Date cust_date)
    {
        this.cust_id=cust_id;
        this.cust_name=cust_name;
        this.cust_date=cust_date;
    }
    public int getCust_id() {
        return this.cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return this.cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public Date getCust_date() {
        return this.cust_date;
    }

    public void setCust_date(Date cust_date) {
        this.cust_date = cust_date;
    }
    
}
