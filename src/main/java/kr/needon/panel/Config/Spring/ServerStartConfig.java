package kr.needon.panel.Config.Spring;

import kr.needon.panel.Module.User.Service.UserService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerStartConfig implements InitializingBean, DisposableBean {

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Web Server Start!");

        int userRoleSize = userService.getUserRole().size();
        System.out.println("Check User Role Size --> " + userRoleSize);

        if(userRoleSize == 0) {
            userService.insertUserRole("ROLE_ADMIN");

        }

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Web Server Stop!");
    }

}
