package cn.probuing.dao.impl;


import cn.probuing.dao.CustomerDao;
import cn.probuing.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

    @Override
    public List<Object[]> getIndustryCount() {
        List list = getHibernateTemplate().execute(new HibernateCallback<List>() {
            String sql = "SELECT bd.dict_item_name,COUNT(*) " +
                    "FROM cst_customer c,base_dict bd " +
                    "where c.cust_industry=bd.dict_id " +
                    "GROUP BY c.cust_industry";

            @Override
            public List doInHibernate(Session session) throws HibernateException {
                SQLQuery sqlQuery = session.createSQLQuery(sql);
                return sqlQuery.list();
            }
        });
        return list;
    }
}
