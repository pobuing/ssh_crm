package cn.probuing.dao;


import cn.probuing.domain.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer> {

    List<Object[]> getIndustryCount();

}
