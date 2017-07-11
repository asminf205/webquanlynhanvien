/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.controller;

import entity.xml.Users;
//import entity.ano.Users;
import java.util.List;
import javax.transaction.Transactional;
import poly.model.userDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    SessionFactory factory;
    
    @RequestMapping("index")
    public String index(ModelMap model) {
            Session session = factory.getCurrentSession();
            String hql = "from Users";
            Query query = session.createQuery(hql);
            List<Users> list = query.list();
            
            //Or ............
//            List<Users> list = userDAO.layDanhSachUser("");

            model.addAttribute("users", list);          
            return "user/index";
    }
    @RequestMapping(value="insert", method=RequestMethod.GET)
    public String insert(ModelMap model) {
            model.addAttribute("user", new Users());
            return "user/insert";
    }
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String insert(ModelMap model, @ModelAttribute("user") Users user) {
//            Session session = factory.openSession();
//            Transaction t = session.beginTransaction();
//            try {
//                session.save(user);
//                t.commit();
//                model.addAttribute("message", "Thêm mới thành công !");
//            } 
//            catch (Exception e) {
//                t.rollback();
//                model.addAttribute("message", "Thêm mới thất bại !");
//            }
//            finally {
//                session.close();
//            }

            //Or ................
            if(userDAO.themUser(user))
                model.addAttribute("message", "Thêm mới thành công !");
            else 
                model.addAttribute("message", "Thêm mới thất bại !");
            
            return "user/insert";
    }

}
