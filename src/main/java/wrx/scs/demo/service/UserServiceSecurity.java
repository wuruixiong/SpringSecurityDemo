package wrx.scs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import wrx.scs.demo.bean.SecurityUserBean;
import wrx.scs.demo.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceSecurity implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 从数据库中获取用户信息
        SecurityUserBean securityUserBean = userService.selectUserByName(s);
        if (securityUserBean == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        List<GrantedAuthority> list = new ArrayList<>();
        // "ROLE_"前缀必须加，不然检测不出来
        list.add(new SimpleGrantedAuthority("ROLE_" + securityUserBean.getRole().toString()));
        // User的jar包不能导错
        // 返回数据库中的密码等信息，接下来准备进行校验密码
        User user = new User(securityUserBean.getUsername(), securityUserBean.getPassword(), list);

        return user;
    }




}
