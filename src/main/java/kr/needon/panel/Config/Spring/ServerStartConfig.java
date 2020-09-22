package kr.needon.panel.Config.Spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerStartConfig implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Web Server Start!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Web Server Stop!");
    }

}
