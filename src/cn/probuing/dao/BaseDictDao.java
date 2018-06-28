package cn.probuing.dao;

import cn.probuing.domain.BaseDict;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/28 16:27
 * @Description:
 */
public interface BaseDictDao {
    /**
     * 根据dict_type_code查询数据库
     *
     * @param dict_type_code
     * @return 查到的BaseDict集合
     */
    List<BaseDict> getListByTypeCode(String dict_type_code);
}
