package cn.probuing.service;

import cn.probuing.domain.User;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/14 17:33
 * @Description:
 */
public interface UserService {
    User getUserByCodePassword(User u);

    void saveUser(User u);
}
