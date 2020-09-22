package kr.needon.panel.Module.User.Service;

import kr.needon.panel.Module.User.Model.UserBean;

public interface UserService {

    void save(UserBean user);
    UserBean findByUsername(String username);
    String testMybatis();


}