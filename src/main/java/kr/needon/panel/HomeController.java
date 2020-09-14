package kr.needon.panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Index() {

        System.out.println("Hello World!");


        return "index";
    }

}
