package cn.probuing.service.impl;

import cn.probuing.dao.CustomerDao;
import cn.probuing.domain.Customer;
import cn.probuing.service.CustomerService;
import cn.probuing.util.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/27 14:55
 * @Description:
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao cd;
    @Override
    public PageBean getPageBean(DetachedCriteria criteria, Integer currentPage, Integer pageSize) {
        //调用dao查询数据库获得总记录数
        Integer totalCount = cd.getTotalCount(criteria);
        //创建PageBean对象
        PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
        //调用Dao查询分页列表数据
        List<Customer> list =  cd.getPageList(criteria,pageBean.getStart(),pageBean.getPageSize());
        //将列表数据封装到pagebean中
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(Customer customer) {
        cd.saveOrUpdate(customer);
    }

    @Override
    public Customer getById(Long cust_id) {
        Customer customer = cd.getById(cust_id);
        return customer;
    }

    public void setCd(CustomerDao cd) {
        this.cd = cd;
    }
}
