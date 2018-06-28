package cn.probuing.service;

import cn.probuing.domain.BaseDict;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/28 16:20
 * @Description:
 */
public interface BaseDictService {
    /**
     * 根据type_code 查询数据库返回list集合
     *
     * @param dict_type_code
     * @return
     */
    List<BaseDict> getListByTypeCode(String dict_type_code);
}
