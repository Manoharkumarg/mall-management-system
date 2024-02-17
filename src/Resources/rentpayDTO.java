package Resources;
import java.util.Date;
public class rentpayDTO {
    private int pay_id;
    private int pay_amount;
    private Date pay_date;
    private int tenent_id; 
    public rentpayDTO(int pay_id,int pay_amount,Date pay_date,int tenent_id)
    {
        this.pay_id=pay_id;
        this.pay_amount=pay_amount;
        this.pay_date=pay_date;
        this.tenent_id=tenent_id;
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

    public int getTenent_id() {
        return this.tenent_id;
    }

    public void setTenent_id(int tenent_id) {
        this.tenent_id = tenent_id;
    }

}
