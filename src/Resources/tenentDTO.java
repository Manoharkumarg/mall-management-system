package Resources;

import java.util.Date;

public class tenentDTO {
    private int tenent_id;
    private String tenent_name;
    private int tenent_contact;
    private Date tenent_date;
    private int block_id;
    public tenentDTO(int tenent_id,String tenent_name,int tenent_contact,Date tenent_date,int block_id)
    {
        this.tenent_id=tenent_id;
        this.tenent_name=tenent_name;
        this.tenent_contact=tenent_contact;
        this.tenent_date=tenent_date;
        this.block_id=block_id;
    }
    public int getTenent_id() {
        return this.tenent_id;
    }

    public void setTenent_id(int tenent_id) {
        this.tenent_id = tenent_id;
    }

    public String getTenent_name() {
        return this.tenent_name;
    }

    public void setTenent_name(String tenent_name) {
        this.tenent_name = tenent_name;
    }

    public int getTenent_contact() {
        return this.tenent_contact;
    }

    public void setTenent_contact(int tenent_contact) {
        this.tenent_contact = tenent_contact;
    }

    public Date getTenent_date() {
        return this.tenent_date;
    }

    public void setTenent_date(Date tenent_date) {
        this.tenent_date = tenent_date;
    }

    public int getBlock_id() {
        return this.block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }
} 
