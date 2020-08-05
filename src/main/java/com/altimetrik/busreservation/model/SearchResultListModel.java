package com.altimetrik.busreservation.model;

import java.util.List;

public class SearchResultListModel {
	
	List<SearchResultModel> searchResultModelList;
	
	int totalResultCount;

	public SearchResultListModel(List<SearchResultModel> modelList, int totalResultCount) {
		this.searchResultModelList = modelList;
		this.totalResultCount = totalResultCount;
	}

	public SearchResultListModel() {
	}

	public List<SearchResultModel> getSearchResultModelList() {
		return searchResultModelList;
	}

	public void setSearchResultModelList(List<SearchResultModel> searchResultModelList) {
		this.searchResultModelList = searchResultModelList;
	}

	public int getTotalResultCount() {
		return totalResultCount;
	}

	public void setTotalResultCount(int totalResultCount) {
		this.totalResultCount = totalResultCount;
	}

}
