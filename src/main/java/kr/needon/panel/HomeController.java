package kr.needon.panel;

import kr.needon.panel.Module.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public @ResponseBody String Index() {

        return userService.testMybatis();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/test")
    public String Test() {

        System.out.println("Hello World!");


        return "index";
    }

}
