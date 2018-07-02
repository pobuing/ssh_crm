package cn.probuing.service;

import cn.probuing.domain.LinkMan;
import cn.probuing.util.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/7/2 12:09
 * @Description:
 */
public interface LinkManService {

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void save(LinkMan linkMan);

    LinkMan getById(Long lkm_id);

}
