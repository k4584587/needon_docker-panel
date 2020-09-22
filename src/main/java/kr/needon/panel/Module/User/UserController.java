package kr.needon.panel.Module.User;

import kr.needon.panel.Config.Security.Service.SecurityService;
import kr.needon.panel.Module.User.Model.UserBean;
import kr.needon.panel.Module.User.Service.UserService;
import kr.needon.panel.Module.User.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String Login(Model model) {

        model.addAttribute("test","Hello Model");
        return "/user/login";
    }

    @GetMapping("/join")
    public String registration(Model model) {

        model.addAttribute("userForm", new UserBean());

        return "/user/join";
    }

    @PostMapping("/join")
    public String registration(@ModelAttribute("userForm") UserBean userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/user/join";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }

}
