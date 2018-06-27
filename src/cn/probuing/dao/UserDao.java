package cn.probuing.dao;

import cn.probuing.domain.User;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/15 11:20
 * @Description:
 */
public interface UserDao {
    //根据登录名称查询user对象
    User getByUserCode(String userCode);

    void saveUser(User user);
}
