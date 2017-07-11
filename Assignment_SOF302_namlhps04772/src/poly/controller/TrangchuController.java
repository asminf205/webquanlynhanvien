package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.xml.Records;
import entity.xml.Staffs;
import util.HibernateUtil;
@Controller
public class TrangchuController {
	@RequestMapping("TrangChu")
	public String showTrangchu(ModelMap model){			 
		        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        session.beginTransaction();
		        
		        String hql = "SELECT r.staffs.id, "+
		    	        " SUM(case when r.type=1 then 1 else 0 end), "+
		    	        " SUM(case when r.type=0 then 1 else 0 end)"+
		    	        " FROM Records r "+
		    	        " GROUP BY r.staffs.id";
		        Query query = session.createQuery(hql);
		        query.setMaxResults(10);
		        List<Object[]> list = query.list();
		       		        
		        model.addAttribute("array", list);
		     
		return "Trangchu";
	}
}
