package com.clothing.model.base;

public class Entity<Integer> implements java.io.Serializable {

	private Integer id;
	/**
	 * 店铺ID
	 */
	private int cu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCu() {
		return cu;
	}

	public void setCu(int cu) {
		this.cu = cu;
	}
}
