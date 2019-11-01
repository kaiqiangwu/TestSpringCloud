package com.cy.hisystem.pojo;

import java.util.List;

/**
 * 封装分页信息
 * @author Leo 徐忠春
 *
 * @param <T>
 */
public class PagePojo<T> {
	//查询总记录数
	private long total;

	//查询所有记录
    private List<T> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PagePojo [total=" + total + ", rows=" + rows + "]";
	}
	
    
}
