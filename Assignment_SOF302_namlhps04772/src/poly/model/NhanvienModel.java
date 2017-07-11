	package poly.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import poly.bean.Nhanvien;

public class NhanvienModel {

	public NhanvienModel() {
		super();
	}

    public List<Nhanvien> showNhanvien(String tennv) {
    	try {
        	String gioitinh;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = " select Staffs.Id,Staffs.Name,Gender,Birthday,Photo,Email,Phone,Salary,Notes,Departs.Name from Staffs,Departs where Staffs.DepartId =Departs.Id";
            if(tennv.length() > 0){
                sql += " where name like '%"+tennv+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Nhanvien> list = new ArrayList<Nhanvien>();
            while (rs.next()) {
            	String maNV = rs.getString("Id");
                String hoten = rs.getString("Name");
                int sex = rs.getInt("Gender");
                if (sex == 1) {
                     gioitinh="nam";
                } else {
                	 gioitinh="nu";
                }
                String ngaysinh=rs.getString("Birthday");   
                String photo=rs.getString("Photo");
                String email=rs.getString("Email");
                String sDT=rs.getString("Phone");
                float luong = rs.getFloat("Salary");            
                String ghichu=rs.getString("Notes");
                String phongban=rs.getString(10);      
                Nhanvien nv = new Nhanvien(maNV, hoten, gioitinh, ngaysinh, photo, luong, email, sDT, ghichu, phongban);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(String maNV, String hoten, String gioitinh, Date ngaysinh, String photo, String email,String sDT, float luong,
			 String ghichu, String phongban){
        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into Staffs values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maNV);
            stm.setString(2, hoten);
            if(gioitinh.equalsIgnoreCase("Nam")){
            	stm.setInt(3, 1);
            }else{
            	stm.setInt(3, 0);
            }
            
            stm.setDate(4, ngaysinh);
            stm.setString(5, photo);
            stm.setString(6, email);
            stm.setString(7, sDT);
            stm.setFloat(8, luong);
            stm.setString(9, ghichu);
            stm.setString(10,phongban);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update( String hoten, String gioitinh, Date ngaysinh, String photo, String email,String sDT, float luong,
			 String ghichu, String phongban,String maNV) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update Staffs set Name=?, Gender=?,Birthday=?, Photo=?,Email=?, Phone=?,Salary=?, Notes=?,DepartId=? where Id=?)";
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, hoten);
            if(gioitinh.equalsIgnoreCase("Nam")){
            	stm.setInt(2, 1);
            }else{
            	stm.setInt(2, 0);
            }
            
            stm.setDate(3, ngaysinh);
            stm.setString(4, photo);
            stm.setString(5, email);
            stm.setString(6, sDT);
            stm.setFloat(7, luong);
            stm.setString(8, ghichu);
            stm.setString(9,phongban);
            stm.setString(10, maNV);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String maNV) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from Staffs where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maNV);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
