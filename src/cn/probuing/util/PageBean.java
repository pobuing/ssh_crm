package cn.probuing.util;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/27 10:55
 * @Description:分页实体类
 */
public class PageBean {
    //当前页数
    private Integer currentPage;
    //总页数
    private Integer totalPage;
    //总记录数
    private Integer totalCount;
    //显示条数
    private Integer pageSize;
    //list数据
    private List list;

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        //判断currentPage没有值得情况
        if (currentPage == null) {
            this.currentPage = 1;
        }
        //判断pagesize没有值的情况
        if (pageSize == null) {
            this.pageSize = 3;
        }
        //计算总页数
        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
        // 页数最小值不能小于1
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        //页数最大值不能大于总页数
        if (this.currentPage > totalPage) {
            this.currentPage = this.totalPage;
        }
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    /**
     * 获得起始页
     * @return
     */
    public int getStart() {
        return (this.currentPage - 1) * pageSize;
    }
}
