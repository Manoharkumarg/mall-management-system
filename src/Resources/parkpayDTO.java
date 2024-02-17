package Resources;

import java.util.Date;

public class parkpayDTO {
    private int pay_id;
    private int pay_amount;
    private Date pay_date;
    private int park_id; 
    public parkpayDTO(int pay_id,int pay_amount,Date pay_date,int park_id)
    {
        this.pay_id=pay_id;
        this.pay_amount=pay_amount;
        this.pay_date=pay_date;
        this.park_id=park_id;
    }

    public int getPay_id() {
        return this.pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public int getPay_amount() {
        return this.pay_amount;
    }

    public void setPay_amount(int pay_amount) {
        this.pay_amount = pay_amount;
    }

    public Date getPay_date() {
        return this.pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public int getPark_id() {
        return this.park_id;
    }

    public void setPark_id(int park_id) {
        this.park_id = park_id;
    }


}
