package com.connext.springdatajpa.util;

import java.util.List;

public class Page {

	//??????
	public static final int PAGE_SIZE = 3;
	
	//????
	private int currPage = 1;
	
	//??????
	private int totalCount;
	
	//?????
	private int totalPage;
	
	//????
	private List data;
	
	/**
	 * ?????????
	 */
	public void init() {
		if(this.totalCount % PAGE_SIZE == 0) {
			this.totalPage = this.totalCount/PAGE_SIZE;
		}else {
			this.totalPage = this.totalCount/PAGE_SIZE+1;
		}
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public static int getPageSize() {
		return PAGE_SIZE;
	}
	
	
}

