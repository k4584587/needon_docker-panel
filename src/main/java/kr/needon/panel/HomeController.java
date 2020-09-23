package kr.needon.panel;

import kr.needon.panel.Module.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String Index() {

        int userCount = userService.userCount();

        if(userCount == 0) {
            System.out.println("처음 설치되여있는 상태임 회원가입 페이지로 이동");
            return "redirect:/user/join";
        }

        System.out.println("userCount --> " + userCount);

        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test")
    public String Test() {

        System.out.println("Hello World!");


        return "index";
    }

}
