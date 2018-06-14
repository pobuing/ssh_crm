package cn.probuing.action;

import cn.probuing.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/14 15:26
 * @Description:
 */
public class UserAction extends ActionSupport {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {
        System.out.println(userService);
        return super.execute();
    }
}
