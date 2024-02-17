package Resources;

public class loginDTO {
    private int user_id;
    private String email;
    private String password;
    private String role;
    public loginDTO(int user_id,String email,String password,String role)
    {
        this.user_id=user_id;
        this.email=email;
        this.password=password;
        this.role=role;
    }
    public String getEmail(){
        return this.email;
    }
    public String getRole(){
        return this.role;
    }
    public String getPassword(){
        return this.password;
    }
    public int getUserId(){
        return this.user_id;
    }
    public void setUserId(int user_id){
        this.user_id=user_id;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setRole(String role){
        this.role=role;
    }
}
