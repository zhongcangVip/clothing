package com.clothing.model.vo;

/**
 * 分页查询VO
 * 
 * @author yangmin
 * @Date:2018年10月31日
 * @param <T>
 */
public class PaginationCondition<T> implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7964335101037721510L;

	private int page;
	
	private int pageSize;

	private T condition;

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}

	

	public PaginationCondition(T condition) {
		super();
		this.condition = condition;
	}

	public PaginationCondition() {
		super();

	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
