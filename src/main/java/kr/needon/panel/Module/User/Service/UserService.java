package kr.needon.panel.Module.User.Service;

import kr.needon.panel.Module.User.Model.RoleBean;
import kr.needon.panel.Module.User.Model.UserBean;

import java.util.List;

public interface UserService {

    String testMybatis();
    List<RoleBean> getUserRole();
    int insertUserRole(String name);
    int userCount();
    void save(UserBean user);
    UserBean findByUsername(String username);



}