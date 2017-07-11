package poly.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.bean.Nhanvien;
import poly.model.UserModel;
import poly.model.NhanvienModel;


@Controller

public class NhanvienController {
	
    private String username;
		
		
		@RequestMapping(value="Dangnhap",method=RequestMethod.POST )
		public String login(HttpServletRequest request,ModelMap model){
			
			 String user = request.getParameter("txtUser");
             String pass = request.getParameter("txtPass");
             UserModel us = new UserModel();
             boolean exist = us.checkLogin(user, pass);
             String url;
             if(exist){
                 url= "Trangchu";                                            
             }else{
            	 model.addAttribute("message", "Nhap sai !");
            	 url= "Dangnhap";        
             }
			
			return url;
		}
		@RequestMapping("/QLNhanVien")
		public String qlnhanvien(ModelMap model){
			NhanvienModel nhanvien =new NhanvienModel();
			List<Nhanvien> list = new ArrayList<Nhanvien>();
			list = nhanvien.showNhanvien("");
	        model.addAttribute("staffs", list);	        
	        
			return "QLNhanvien";			
		}
//		@RequestMapping(value="/QLNhanvien",params="btnInsert")
//	    public String insert(HttpServletRequest request, ModelMap model){	        
//
//	         String maNV = request.getParameter("txtManv");
//             String hoten = request.getParameter("txtName");
//             String gioitinh=request.getParameter("Gioitinh");
//             String ngaysinh=request.getParameter("txtNgaysinh");   
//             String photo="1";
//             String email=request.getParameter("txtEmail");
//             String sDT=request.getParameter("txtSdt");
//             String salary=request.getParameter("txtLuong");
//             float luong = Float.parseFloat(salary);            
//             String ghichu=request.getParameter("txtGhichu");
//             String phongban=request.getParameter("txtPhongban");    
//             NhanvienModel nv = new NhanvienModel();
//             System.out.println("insert: "+nv);
//	       // nv.insert(maNV, hoten, gioitinh, ngaysinh, photo, email, sDT, luong, ghichu, phongban);
//	        return "redirect:/QLNhanvien";
//	    }
		
		@RequestMapping(value="/NhanVien")
	    public String insert1(HttpServletRequest request, ModelMap model){	        

			if(request.getParameter("action").equalsIgnoreCase("Them")){
				String maNV = request.getParameter("txtManv");
	             String hoten = request.getParameter("txtName");
	             String gioitinh=request.getParameter("Gioitinh");
	             String ngaysinh=request.getParameter("txtNgaysinh");   
	             SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");   
	             Date d=null;
				try {
					d = new java.sql.Date(formater.parse(ngaysinh).getTime());
				} catch (ParseException e) {
					System.out.println(e.toString());
					
				}
	             String photo="1";
	             String email=request.getParameter("txtEmail");
	             String sDT=request.getParameter("txtSdt");
	             String salary=request.getParameter("txtLuong");
	             float luong = Float.parseFloat(salary);            
	             String ghichu=request.getParameter("txtGhichu");
	             String phongban=request.getParameter("txtPhongban");    
	             NhanvienModel nv = new NhanvienModel();
	             System.out.println("insert: "+nv);
		        nv.insert(maNV, hoten, gioitinh, d, photo, email, sDT, luong, ghichu, phongban);
		        
			}
			else if(request.getParameter("action").equalsIgnoreCase("CapNhat")){
				
	             String hoten = request.getParameter("txtName");
	             String gioitinh=request.getParameter("Gioitinh");
	             String ngaysinh=request.getParameter("txtNgaysinh");   
	             SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");   
	             Date d=null;
				try {
					d = new java.sql.Date(formater.parse(ngaysinh).getTime());
				} catch (ParseException e) {
					System.out.println(e.toString());
					
				}
	             String photo="1";
	             String email=request.getParameter("txtEmail");
	             String sDT=request.getParameter("txtSdt");
	             String salary=request.getParameter("txtLuong");
	             float luong = Float.parseFloat(salary);            
	             String ghichu=request.getParameter("txtGhichu");
	             String phongban=request.getParameter("txtPhongban");
	             String maNV = request.getParameter("txtManv");
	             NhanvienModel nv = new NhanvienModel();
                nv.update(hoten, gioitinh, d, photo, email, sDT, luong, ghichu, phongban, maNV);
			}
			else{
				String maNV = request.getParameter("txtManv");
				NhanvienModel nv = new NhanvienModel();
                nv.delete(maNV);
			}
			
			return "redirect:/QLNhanVien.htm";
	         
	    }
		
}

