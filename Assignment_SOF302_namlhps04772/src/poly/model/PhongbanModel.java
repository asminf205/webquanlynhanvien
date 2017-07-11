package poly.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;


import poly.bean.Phongban;

public class PhongbanModel {
	public PhongbanModel() {
		super();
	}
	  public List<Phongban> showPhongban() {
	    	try {
	        	
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            String url = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
	            Connection con = DriverManager.getConnection(url, "sa", "123");
	            String sql = "select * from Departs";	            
	            Statement stm = con.createStatement();
	            ResultSet rs = stm.executeQuery(sql);
	            List<Phongban> list = new ArrayList<Phongban>();
	            while (rs.next()) {
	            	String maPB = rs.getString(1);		
			        String tenPB = rs.getString(2);   
	               Phongban pb = new Phongban(maPB, tenPB);
	                list.add(pb);
	            }
	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	public void insert(String maPB, String tenPB) {
		
        try {
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
             Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = " insert into Departs values (?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPB);
            stm.setString(2, tenPB);            
            stm.executeUpdate();
            stm.close();
            con.close();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
    }
	 public void update(String maPB, String tenPB) {
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
	             Connection con = DriverManager.getConnection(url, "sa", "123");
	            PreparedStatement stm = con.prepareStatement("UPDATE Departs set Name='"+tenPB+"' Where Id='"+maPB+"'");
	            stm.executeUpdate();
	            stm.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void delete(String maPB) {
	        try {
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
	             Connection con = DriverManager.getConnection(url, "sa", "123");
	            String sql = "delete from Departs where Id=?";
	            PreparedStatement stm = con.prepareStatement(sql);
	            stm.setString(1, maPB);
	            stm.executeUpdate();
	            stm.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
