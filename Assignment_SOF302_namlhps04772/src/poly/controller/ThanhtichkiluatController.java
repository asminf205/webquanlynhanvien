package poly.controller;

import entity.xml.Records;
import entity.xml.Staffs;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.HibernateUtil;

@Transactional
@Controller
public class ThanhtichkiluatController {
	@Autowired
    SessionFactory factory;

    @RequestMapping(value="Thanhtichkyluat", method=RequestMethod.GET)
    public String insert2(ModelMap model) {
            model.addAttribute("record", new Records());
            return "Thanhtichkyluat";
    }
	
    @RequestMapping(value="Thanhtichkyluat", method=RequestMethod.POST)
    public String insert2(ModelMap model, @ModelAttribute("record") Records record) {
        //Session session = factory.openSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            record.setDate(new Date());
            session.save(record);
            t.commit();
            model.addAttribute("message", "Thêm mới thành công !");
        } 
        catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Thêm mới thất bại !");
        }
        finally {
                session.close();
        }
        return "Thanhtichkyluat";
}

}
