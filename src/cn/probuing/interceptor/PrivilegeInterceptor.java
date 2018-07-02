package cn.probuing.interceptor;

import cn.probuing.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/7/2 18:11
 * @Description:
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        //从session中取出保存的登录对象
        User user = (User) ActionContext.getContext().getSession().get("user");
        if (user != null) {
            //放行
            return invocation.invoke();
        } else {
            return "toLogin";
        }
    }
}
