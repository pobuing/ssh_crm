package cn.probuing.action;

import cn.probuing.domain.User;
import cn.probuing.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/14 15:26
 * @Description:
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private UserService userService;
    private User u = new User();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {
        //调用service执行登录逻辑
        User user = userService.getUserByCodePassword(u);
        //将返回的User对象放到session域中
        ActionContext.getContext().getSession().put("user", user);
        return "toHome";
    }

    @Override
    public User getModel() {
        return u;
    }
}
