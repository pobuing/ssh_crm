package cn.probuing.dao.impl;

import cn.probuing.dao.BaseDictDao;
import cn.probuing.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/28 16:40
 * @Description:
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

    @Override
    public List<BaseDict> getListByTypeCode(String dict_type_code) {
        //创建离线查询对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BaseDict.class);
        //创建条件
        detachedCriteria.add(Restrictions.eq("dict_type_code", dict_type_code));
        //执行查询
        return ((List<BaseDict>) getHibernateTemplate().findByCriteria(detachedCriteria));
    }
}
