package cn.probuing.action;

import cn.probuing.domain.BaseDict;
import cn.probuing.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/28 16:17
 * @Description:
 */
public class BaseDictAction extends ActionSupport {
    private String dict_type_code;
    private BaseDictService baseDictService;

    @Override
    public String execute() throws Exception {
        //调用service根据页面传递的dict_type_code查询BaseDict并返回list
        List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
        //list转换json
        String jsonStr = JSONArray.fromObject(list).toString();
        //将json发送到页面
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(jsonStr);
        return null;
    }

    /**
     * setter方法 用于Spring注入
     *
     * @param baseDictService
     */
    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    public String getDict_type_code() {
        return dict_type_code;
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }
}
