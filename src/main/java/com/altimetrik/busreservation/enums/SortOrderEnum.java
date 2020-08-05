package com.altimetrik.busreservation.enums;

public enum SortOrderEnum {
	ASCENDING(false), DESENDING(true);

	private boolean value;

	SortOrderEnum(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	public SortOrderEnum getOrder(boolean value) {
		return (value) ? SortOrderEnum.DESENDING : SortOrderEnum.ASCENDING;
	}

}
