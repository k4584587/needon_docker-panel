package kr.needon.panel.Module.User.Service;

import kr.needon.panel.Module.User.Model.UserBean;
import kr.needon.panel.Module.User.Repository.RoleRepository;
import kr.needon.panel.Module.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final SqlSession sqlSession;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserBean user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public UserBean findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String testMybatis() {
        return sqlSession.selectOne("TestMapper.testSql");
    }
}