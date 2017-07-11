package poly.controller;

import entity.xml.Staffs;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import util.HibernateUtil;

@Transactional
@Controller
public class TonghopController {
	 @RequestMapping("Tonghop")
	 public String report(ModelMap model) {
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        String hql = "SELECT r.staffs.id, "+
	        " SUM(case when r.type=1 then 1 else 0 end), "+
	        " SUM(case when r.type=0 then 1 else 0 end)"+
	        " FROM Records r "+
	        " GROUP BY r.staffs.id";
	        Query query = session.createQuery(hql);
	        List<Object[]> list = query.list();
	        model.addAttribute("arrays", list);
	        return "Tonghop";
	    }
}
