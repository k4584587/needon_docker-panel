package kr.needon.panel.Module.User.Repository;

import kr.needon.panel.Module.User.Model.RoleBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleBean, Long> {
}