package cn.probuing.dao.impl;

import cn.probuing.dao.CustomerDao;
import cn.probuing.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/27 15:01
 * @Description:
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public Integer getTotalCount(DetachedCriteria criteria) {
        //设置聚合函数
        criteria.setProjection(Projections.rowCount());
        List list = getHibernateTemplate().findByCriteria(criteria);
        //清空聚合函数
        criteria.setProjection(null);
        if (list != null && list.size() > 0) {
            Long count = (Long) list.get(0);
            return count.intValue();
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> getPageList(DetachedCriteria criteria, int start, Integer pageSize) {
        List<Customer> customerList = (List<Customer>) getHibernateTemplate().findByCriteria(criteria, start, pageSize);
        return customerList;
    }
}
