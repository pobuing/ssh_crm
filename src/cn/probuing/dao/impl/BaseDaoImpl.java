package cn.probuing.dao.impl;

import cn.probuing.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/28 13:12
 * @Description:
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private final Class clazz;

    public BaseDaoImpl() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = ((Class) parameterizedType.getActualTypeArguments()[0]);
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    @Override
    public void delete(Serializable id) {
        getHibernateTemplate().delete(this.getById(id));
    }

    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    @Override
    public T getById(Serializable id) {
        return (T) getHibernateTemplate().get(clazz, id);
    }

    @Override
    public Integer getTotalCount(DetachedCriteria dc) {
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
        dc.setProjection(null);
        if (list != null && list.size() > 0) {
            Long count = list.get(0);
            return count.intValue();
        } else {
            return null;
        }
    }

    @Override
    public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
        return ((List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize));
    }

    @Override
    public void saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
    }
}
