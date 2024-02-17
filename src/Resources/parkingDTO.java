package Resources;

public class parkingDTO {
    private int park_id;
    private boolean park_status;
    private int slot_id; 
    public parkingDTO(int park_id,boolean park_status,int slot_id)
    {
        this.park_id=park_id;
        this.park_status=park_status;
        this.slot_id=slot_id;
    }

    public int getPark_id() {
        return this.park_id;
    }

    public void setPark_id(int park_id) {
        this.park_id = park_id;
    }

    public boolean isPark_status() {
        return this.park_status;
    }

    public boolean getPark_status() {
        return this.park_status;
    }

    public void setPark_status(boolean park_status) {
        this.park_status = park_status;
    }

    public int getSlot_id() {
        return this.slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }
    
}
