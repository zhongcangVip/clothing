package com.clothing.model.base;

import java.util.List;

/**
 * 分页对象
 * @author yangmin
 * @date  2018年9月28日
 * @param <T>
 */
public class Pagination<T> {

    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Long total;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> rows;

    public Pagination() {
        super();
    }

    public Pagination(Integer currentPage, Integer pageSize, Long totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = totalNum;
        this.totalPage = (int) ((this.total+this.pageSize-1)/this.pageSize);
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long totalNum) {
        this.total = totalNum;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> items) {
        this.rows = items;
    }
}
