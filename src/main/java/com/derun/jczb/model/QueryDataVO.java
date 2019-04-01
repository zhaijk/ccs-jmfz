package com.derun.jczb.model;

import java.util.List;

//import com.github.pagehelper.PageInfo;

public class QueryDataVO<T> {
	
	private int draw; 				// Client request times
	private int recordsTotal; 		// Total records number without conditions
	private int recordsFiltered; 	// Total records number with conditions
	private List<T> data; 			// The data we should display on the page
	
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

}
