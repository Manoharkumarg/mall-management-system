package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tenantDAO extends Connect{
    private static tenantDAO instance;
    PreparedStatement setTenant;
    PreparedStatement tenantId;
    PreparedStatement blockId;
    PreparedStatement tenantStatus;
    private tenantDAO() throws SQLException{
        setTenant=con.prepareStatement("INSERT INTO tenant(tenant_name,block_id,tenant_status) VALUES(?,?,?)");
        tenantId=con.prepareStatement("SELECT tenant_id FROM tenant WHERE tenant_name=?");
        blockId=con.prepareStatement("SELECT block_id FROM tenant WHERE tenant_id=?");
        tenantStatus=con.prepareStatement("UPDATE tenant SET tenant_status=0 WHERE tenant_id=?");
    }
    public static tenantDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new tenantDAO();
        }
        return instance;
    }
    public void addNewTenant(String name,int id) throws SQLException{
        setTenant.setString(1, name);
        setTenant.setInt(2, id);
        setTenant.setInt(3, 1);
        setTenant.executeUpdate();

    } 
    public int getTenantId(String name) throws SQLException{
        tenantId.setString(1, name);
        ResultSet rs=tenantId.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return 0;
    }
    public int getBlockId(int t_id) throws SQLException{
        blockId.setInt(1, t_id);
        ResultSet rs=blockId.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void changeTenantStatus(int t_id) throws SQLException{
        tenantStatus.setInt(1, t_id);
        tenantStatus.executeUpdate();
    }
}
