package Controllers;

import java.sql.SQLException;

import Models.tenantDAO;

public class tenantController {
    public static int getTenentIdByName(String name) throws SQLException{
        tenantDAO tenant=tenantDAO.getInstance();
        int t_id=tenant.getTenantId(name);
        return t_id;
    }
    public static int getBlockId(int t_id) throws SQLException{
        tenantDAO tenant=tenantDAO.getInstance();
        int b_id=tenant.getBlockId(t_id);
        return b_id;
    }
    public static void changeTenantStatus(int t_id) throws SQLException{
        tenantDAO tenant=tenantDAO.getInstance();
        tenant.changeTenantStatus(t_id);
    }
}
