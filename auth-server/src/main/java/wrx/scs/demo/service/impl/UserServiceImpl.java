package wrx.scs.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wrx.scs.demo.bean.SecurityUserBean;
import wrx.scs.demo.mapper.UserMapper;
import wrx.scs.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public SecurityUserBean selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public void addOne(SecurityUserBean user) {
        userMapper.addOne(user);
    }


}
