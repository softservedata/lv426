<<<<<<< HEAD
package com.softserve.edu.opencart.data;

public enum Currencies {
    EURO("Euro"),
    POUND_STERLING("Pound Sterling"),
    US_DOLLAR("US Dollar");
    //
    private String name;

    private Currencies(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

=======
package com.softserve.edu.opencart.data;

public enum Currencies {
	EURO("Euro"),
	POUND_STERLING("Pound Sterling"),
	US_DOLLAR("US Dollar");
	//
	private String name;

	private Currencies(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
}