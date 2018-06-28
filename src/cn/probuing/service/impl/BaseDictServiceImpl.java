package cn.probuing.service.impl;

import cn.probuing.dao.BaseDictDao;
import cn.probuing.domain.BaseDict;
import cn.probuing.service.BaseDictService;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/28 16:21
 * @Description:
 */
public class BaseDictServiceImpl implements BaseDictService {
    private BaseDictDao bdd;
    @Override
    public List<BaseDict> getListByTypeCode(String dict_type_code) {
        //通过dao查询数据库获得BaseDict列表
        return bdd.getListByTypeCode(dict_type_code);
    }

    public void setBdd(BaseDictDao bdd) {
        this.bdd = bdd;
    }
}
