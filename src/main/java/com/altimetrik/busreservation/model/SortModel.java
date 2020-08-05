package com.altimetrik.busreservation.model;

import java.util.List;

public class SortModel {
	
	String sortColumn;
	
	boolean sortOrder;
	
	List<Long> busIdList;

	public SortModel() {
		super();
	}

	public SortModel(String sortColumn, boolean sortOrder, List<Long> busIdList) {
		super();
		this.sortColumn = sortColumn;
		this.sortOrder = sortOrder;
		this.busIdList = busIdList;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public boolean getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<Long> getBusIdList() {
		return busIdList;
	}

	public void setBusIdList(List<Long> busIdList) {
		this.busIdList = busIdList;
	}

}
