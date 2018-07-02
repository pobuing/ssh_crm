package cn.probuing.service.impl;

import cn.probuing.dao.LinkManDao;
import cn.probuing.domain.LinkMan;
import cn.probuing.service.LinkManService;
import cn.probuing.util.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/7/2 12:10
 * @Description:
 */
public class LinkManServiceImpl implements LinkManService {
    private LinkManDao lmd;

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //调用dao查询数据库数据总条数
        Integer totalCount = lmd.getTotalCount(dc);
        //创建PageBean对象
        PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
        //查询数据库LinkMan数据
        List<LinkMan> list = lmd.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
        //封装数据到pagebean中
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(LinkMan linkMan) {
        lmd.saveOrUpdate(linkMan);
    }

    @Override
    public LinkMan getById(Long lkm_id) {
        return lmd.getById(lkm_id);
    }

    public LinkManDao getLmd() {
        return lmd;
    }

    public void setLmd(LinkManDao lmd) {
        this.lmd = lmd;
    }
}
