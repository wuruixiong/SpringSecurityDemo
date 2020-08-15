package wrx.scs.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResController {

    @RequestMapping("/hello")
    public String helloWorld () {
        return "helloWorld";
    }


    @RequestMapping("/admin/hello")
    public String hello2(){
        return "res admin";
    }



}
