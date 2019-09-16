package com.softserve.edu.opencart.data;

public class SearchFilter {

	private Product product;
	private boolean isSimpleSearch;
	private String categoryName;
	private boolean useSubcategory;
	private boolean useDescriptions;

	public SearchFilter(Product product) {
		this.product = product;
		isSimpleSearch = true;
		categoryName = new String();
		useSubcategory = false;
		useDescriptions = false;
	}
	
	public SearchFilter(Product product, boolean isSimpleSearch,
			String categoryName, boolean useSubcategory,
			boolean useDescriptions) {
		this.product = product;
		this.isSimpleSearch = isSimpleSearch;
		this.categoryName = categoryName;
		this.useSubcategory = useSubcategory;
		this.useDescriptions = useDescriptions;
	}

	// setters
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setSimpleSearch(boolean isSimpleSearch) {
		this.isSimpleSearch = isSimpleSearch;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setUseSubcategory(boolean useSubcategory) {
		this.useSubcategory = useSubcategory;
	}

	public void setUseDescriptions(boolean useDescriptions) {
		this.useDescriptions = useDescriptions;
	}

	// getters
	
	public Product getProduct() {
		return product;
	}

	public boolean isSimpleSearch() {
		return isSimpleSearch;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public boolean isUseSubcategory() {
		return useSubcategory;
	}

	public boolean isUseDescriptions() {
		return useDescriptions;
	}

}
