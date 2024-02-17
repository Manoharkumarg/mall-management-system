package Resources;

public class userDTO {
    private int user_id;
    private String user_name;
    private String role;
    private int tenent_id;
    public userDTO(int user_id,String user_name,String role,int tenent_id)
    {
        this.user_id=user_id;
        this.user_name=user_name;
        this.role=role;
        this.tenent_id=tenent_id;
    }
    public int getUserId(){
        return this.user_id;
    }
    public String getUserName(){
        return this.user_name;
    }
    public String getRole(){
        return this.role;
    }
    public int getTenentId(){
        return this.tenent_id;
    }
    public void setUserId(int user_id){
        this.user_id=user_id;
    }
    public void setUserName(String user_name){
        this.user_name=user_name;
    }
    public void setRole(String role){
        this.role=role;
    }
    public void setTenentId(int tenent_id){
        this.tenent_id=tenent_id;
    }
}
