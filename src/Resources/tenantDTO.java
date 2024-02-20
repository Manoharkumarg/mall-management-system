package Resources;

import java.sql.Date;
public class tenantDTO {
    private int tenant_id;
    private String tenant_name;
    private int tenant_contact;
    private Date tenant_date;
    private int block_id;
    public tenantDTO(int tenant_id,String tenant_name,int tenant_contact,Date tenant_date,int block_id)
    {
        this.tenant_id=tenant_id;
        this.tenant_name=tenant_name;
        this.tenant_contact=tenant_contact;
        this.tenant_date=tenant_date;
        this.block_id=block_id;
    }
    public int getTenant_id() {
        return this.tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getTenant_name() {
        return this.tenant_name;
    }

    public void setTenant_name(String tenant_name) {
        this.tenant_name = tenant_name;
    }

    public int getTenant_contact() {
        return this.tenant_contact;
    }

    public void setTenant_contact(int tenant_contact) {
        this.tenant_contact = tenant_contact;
    }

    public Date getTenant_date() {
        return this.tenant_date;
    }

    public void setTenant_date(Date tenant_date) {
        this.tenant_date = tenant_date;
    }

    public int getBlock_id() {
        return this.block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }
} 
