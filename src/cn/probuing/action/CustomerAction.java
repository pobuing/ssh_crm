package cn.probuing.action;

import cn.probuing.domain.Customer;
import cn.probuing.service.CustomerService;
import cn.probuing.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/27 14:41
 * @Description:
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    private CustomerService cs;
    private Integer currentPage;
    private Integer pageSize;
    public String list() {
        //创建离线查询对象
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNotBlank(customer.getCust_name())) {
            //添加查询条件
            criteria.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }
        //调用service查询分页数据
        PageBean pb = cs.getPageBean(criteria,currentPage,pageSize);
        ActionContext.getContext().put("pb",pb);
        return "list";
    }

    public String add() throws Exception {
        cs.save(customer);
        return "toList";
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerService getCs() {
        return cs;
    }

    public void setCs(CustomerService cs) {
        this.cs = cs;
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
