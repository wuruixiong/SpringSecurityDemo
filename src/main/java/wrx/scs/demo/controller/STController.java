package wrx.scs.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class STController {


    @RequestMapping("/hello")
    public String helloWorld () {

        return "helloWorld";
    }





}
