package kr.needon.panel.Module.User.Repository;

import kr.needon.panel.Module.User.Model.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBean, Long> {

    UserBean findByUsername(String username);

}
