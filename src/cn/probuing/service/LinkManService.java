package cn.probuing.service;


import cn.probuing.domain.LinkMan;
import cn.probuing.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {
	//保存联系人
	void save(LinkMan linkMan);
	//联系人列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//根据id获得LinkMan对象
	LinkMan getById(Long lkm_id);

}
