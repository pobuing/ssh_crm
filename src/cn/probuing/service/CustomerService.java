package cn.probuing.service;

import cn.probuing.domain.Customer;
import cn.probuing.util.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/27 14:54
 * @Description:
 */
public interface CustomerService {
    //获得分页封装对象
    PageBean getPageBean(DetachedCriteria criteria, Integer currentPage, Integer pageSize);

    /**
     * 保存客户
     *
     * @param customer
     */
    void save(Customer customer);

    Customer getById(Long cust_id);
}
