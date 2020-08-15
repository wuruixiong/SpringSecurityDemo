package wrx.scs.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wrx.scs.demo.bean.SecurityUserBean;

@Mapper
public interface UserMapper {


    @Select("select * from security_user where username = #{username}")
    SecurityUserBean selectUserByName(String username);

    @Insert("insert security_user (username, password, role) values(#{username}, #{password}, #{role})")
    void addOne(SecurityUserBean user);

}

