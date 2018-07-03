package cn.probuing.service.impl;


import cn.probuing.dao.LinkManDao;
import cn.probuing.domain.LinkMan;
import cn.probuing.service.LinkManService;
import cn.probuing.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class LinkManServiceImpl implements LinkManService {
	
	private LinkManDao lmd ;
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = lmd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<LinkMan> list = lmd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		return lmd.getById(lkm_id);
	}
	@Override
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	
	

}
