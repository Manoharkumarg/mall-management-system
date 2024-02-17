package Resources;


public class slotDTO {
    private int slot_id;
    private int slot_category;
    private int slot_capacity;
    private int slot_rent; 
    public slotDTO(int slot_id,int slot_category,int slot_capacity,int slot_rent)
    {
        this.slot_id=slot_id;
        this.slot_category=slot_category;
        this.slot_capacity=slot_capacity;
        this.slot_rent=slot_rent;
    }

    public int getSlot_id() {
        return this.slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public int getSlot_category() {
        return this.slot_category;
    }

    public void setSlot_category(int slot_category) {
        this.slot_category = slot_category;
    }

    public int getSlot_capacity() {
        return this.slot_capacity;
    }

    public void setSlot_capacity(int slot_capacity) {
        this.slot_capacity = slot_capacity;
    }

    public int getSlot_rent() {
        return this.slot_rent;
    }

    public void setSlot_rent(int slot_rent) {
        this.slot_rent = slot_rent;
    }

}
