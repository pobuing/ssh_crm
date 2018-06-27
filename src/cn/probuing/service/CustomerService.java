package cn.probuing.service;

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
}
