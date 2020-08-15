package wrx.scs.demo.service;

import wrx.scs.demo.bean.SecurityUserBean;

public interface UserService {

    SecurityUserBean selectUserByName(String name);

    void addOne(SecurityUserBean user);


}
