package wrx.scs.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class STController {


    @RequestMapping("/hello")
    public String helloWorld () {

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
