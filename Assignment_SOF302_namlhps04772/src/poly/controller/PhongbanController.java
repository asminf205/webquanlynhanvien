package poly.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import poly.bean.Phongban;

import poly.model.PhongbanModel;

@Controller
public class PhongbanController {
	@RequestMapping("/QLPhongBan")
	public String qlphongban(ModelMap model){
		PhongbanModel phongban =new PhongbanModel();
		List<Phongban> list = new ArrayList<Phongban>();
		list = phongban.showPhongban();
        model.addAttribute("Departs", list);	        			
		return "QLPhongBan";
	}
	@RequestMapping(value="/Phongban")
	public String insert(HttpServletRequest request, ModelMap model){	
		if(request.getParameter("action").equalsIgnoreCase("Them")){
			try{
				String maPB = request.getParameter("txtMapb");		
		        String tenPB = request.getParameter("txtTenpb");
		        PhongbanModel pb = new PhongbanModel();
		        pb.insert(maPB, tenPB);
		        
				}catch(Exception e){
				e.printStackTrace();
				}
		}
		else if(request.getParameter("action").equalsIgnoreCase("CapNhat")){
			 String tenPB= request.getParameter("txtTenpb");
			 String maPB = request.getParameter("txtMapb");		
			 PhongbanModel pb = new PhongbanModel();
			 pb.update(maPB, tenPB);
		}
		else{
			String maPB = request.getParameter("txtMapb");	
			PhongbanModel pb = new PhongbanModel();
            pb.delete(maPB);
		}
		
		return "redirect:/QLPhongBan.htm";
      
	}
}
