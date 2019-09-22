<<<<<<< HEAD
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
=======
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
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
