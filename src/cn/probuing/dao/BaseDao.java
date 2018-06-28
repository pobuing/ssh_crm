package cn.probuing.dao;

import cn.probuing.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/28 13:09
 * @Description:
 */
public interface BaseDao<T> {
    //增
    void save(T t);

    //删 根据对象删除
    void delete(T t);

    //删 根据id删除
    void delete(Serializable id);

    //改
    void update(T t);

    //查 根据id查询
    T getById(Serializable id);

    //查 符合条件的记录数
    Integer getTotalCount(DetachedCriteria dc);

    //查 查询分页列表数据
    List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

    /**
     * 增加或修改
     * @param t
     */
    void saveOrUpdate(T t);
}
