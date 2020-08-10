package wrx.scs.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wrx.scs.demo.bean.SecurityUserBean;
import wrx.scs.demo.service.UserService;

import javax.management.relation.Role;

@RestController
public class STController {

    @Autowired
    UserService userService;


    @RequestMapping("/hello")
    public String helloWorld () {
        // 插入一行数据
        /*SecurityUserBean bean = new SecurityUserBean();
        bean.setUsername("wrx");
        bean.setPassword("123456");
        bean.setRole(SecurityUserBean.Roles.admin);
        userService.addOne(bean);*/

        //查询并打印日志
        SecurityUserBean userBean = userService.selectUserByName("wrx");
        if (userBean != null) {
            System.out.print("get user name:" + userBean.getUsername() + "\n");
            if (userBean.getRole().equals(SecurityUserBean.Roles.admin)) {
                System.out.print("user is admin" + "\n");
            }
        }

        return "helloWorld";
    }


    @RequestMapping("/admin/hello")
    public String hello2(){
        return "admin";
    }

    @RequestMapping("/db/hello")
    public String hello3(){
        return "db";
    }

    @RequestMapping("/user/hello")
    public String hello4(){
        return "user";
    }



}
