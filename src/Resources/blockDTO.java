package Resources;

public class blockDTO {
    private int block_id;
    private boolean block_availability;
    private int block_size;
    private int block_rent; 
    public blockDTO(int block_id,boolean block_availability,int block_size,int block_rent)
    {
        this.block_id=block_id;
        this.block_availability=block_availability;
        this.block_size=block_size;
        this.block_rent=block_rent;
    }

    public int getBlock_id() {
        return this.block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public boolean isBlock_availability() {
        return this.block_availability;
    }

    public boolean getBlock_availability() {
        return this.block_availability;
    }

    public void setBlock_availability(boolean block_availability) {
        this.block_availability = block_availability;
    }

    public int getBlock_size() {
        return this.block_size;
    }

    public void setBlock_size(int block_size) {
        this.block_size = block_size;
    }

    public int getBlock_rent() {
        return this.block_rent;
    }

    public void setBlock_rent(int block_rent) {
        this.block_rent = block_rent;
    }


}
