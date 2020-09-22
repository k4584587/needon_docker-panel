package kr.needon.panel.Config.Security.Service;

public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String username, String password);

}
