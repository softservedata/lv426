<<<<<<< HEAD
package com.softserve.edu.opencart.data;

public final class ApplicationStatus {
    private static volatile ApplicationStatus instance = null;
    //
    private boolean isLogged;

    private ApplicationStatus() {
        isLogged = false;
    }

    public static ApplicationStatus get() {
        if (instance == null) {
            synchronized (ApplicationStatus.class) {
                if (instance == null) {
                    instance = new ApplicationStatus();
                }
            }
        }
        return instance;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
}
=======
package com.softserve.edu.opencart.data;

public final class ApplicationStatus {

	private static volatile ApplicationStatus instance = null;
	//
	private boolean isLogged;
	
	private ApplicationStatus() {
		isLogged = false;
	}
	
	public static ApplicationStatus get() {
        if (instance == null) {
            synchronized (ApplicationStatus.class) {
                if (instance == null) {
                    instance = new ApplicationStatus();
                }
            }
        }
        return instance;
    }

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
}
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
