package cn.probuing.dao;

import cn.probuing.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/27 14:59
 * @Description:
 */
public interface CustomerDao {
    //获得总数
    Integer getTotalCount(DetachedCriteria criteria);

    /**
     *
     * @param criteria 查询条件
     * @param start  起始索引
     * @param pageSize
     * @return
     */
    List<Customer> getPageList(DetachedCriteria criteria, int start, Integer pageSize);
}
