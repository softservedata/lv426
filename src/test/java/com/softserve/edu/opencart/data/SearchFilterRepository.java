package com.softserve.edu.opencart.data;

public final class SearchFilterRepository {

	private SearchFilterRepository() {
	}

	public static SearchFilter getDefault() {
		return searchMacBook();
	}

	public static SearchFilter searchMacBook() {
		return new SearchFilter(ProductRepository.getMacBook());
	}
}
