package cn.probuing.dao.impl;

import cn.probuing.dao.UserDao;
import cn.probuing.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/15 11:21
 * @Description:
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    // TODO:  为dao注入sessionFactory
    @Override
    public User getByUserCode(final String userCode) {
        //HQL
       /* User execute = getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String sql = "from user where user_code = ?";
                Query query = session.createQuery(sql);
                query.setParameter(0, userCode);
                User user = (User) query.uniqueResult();
                return user;
            }
        });*/
        //Criteria
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("user_code", userCode));
        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
