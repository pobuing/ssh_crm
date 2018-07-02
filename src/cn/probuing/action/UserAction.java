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
    private User user = new User();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {
        try {
            //调用service执行登录逻辑
            User u = userService.getUserByCodePassword(user);
            //将返回的User对象放到session域中
            ActionContext.getContext().getSession().put("user", u);
        } catch (Exception e) {
            e.printStackTrace();
            ActionContext.getContext().put("error", e.getMessage());
            return "error";
        }
        return "toHome";
    }

    public String regist() throws Exception {
        //service查询用户是否存在
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            ActionContext.getContext().put("error", e.getMessage());
            return "regist";
        }
        return "toLogin";
    }

    @Override
    public User getModel() {
        return user;
    }
}
