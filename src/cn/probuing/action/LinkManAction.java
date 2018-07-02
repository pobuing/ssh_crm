package cn.probuing.action;

import cn.probuing.domain.LinkMan;
import cn.probuing.service.LinkManService;
import cn.probuing.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/7/2 12:05
 * @Description:
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    LinkMan linkMan = new LinkMan();
    private LinkManService lms;

    private Integer currentPage;
    private Integer pageSize;

    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
        if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
            dc.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
        }
        if (linkMan.getCustomer() != null && linkMan.getCustomer().getCust_id() != null) {
            dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
        }
        //调用LinkManService 查询linkmanlist
        PageBean pb = lms.getPageBean(dc, currentPage, pageSize);
        ActionContext.getContext().put("pageBean", pb);
        return "list";
    }

    public String add() throws Exception {
        //1 调用Service
        lms.save(linkMan);
        //2 重定向到联系人列表(404)
        return "toList";
    }

    public String toEdit() throws Exception {
        //调用service获取要修改的linkman对象
        LinkMan lkm = lms.getById(linkMan.getLkm_id());
        ActionContext.getContext().put("linkMan", lkm);
        //新增和修改共用页面
        return "add";
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    public LinkManService getLms() {
        return lms;
    }

    public void setLms(LinkManService lms) {
        this.lms = lms;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
