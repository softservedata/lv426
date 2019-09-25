package com.softserve.edu.opencart.data;

import java.util.List;

import com.softserve.edu.opencart.tools.CSVReader;
import com.softserve.edu.opencart.tools.ExcelReader;

public final class UserRepository {
	
	private static volatile UserRepository instance = null;
	
	private UserRepository() {
	}
	
	public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }
	
	public IUser getDefault() {
		return getValidUser();
	}

	public IUser getValidUser() {
		return User.get()
				.setFirstName("7firstName")
				.setLastName("7lastName")
				.seteMail("7eMail")
				.setTelephone("7telephone")
				.setAddress1("7address1")
				.setCity("7city")
				.setPostCode("7Code")
				.setCountry("7country")
				.setRegionState("7State")
				.setPassword("7password")
				.setSubscribe(true)
				.setFax("7fax")
				.setCompany("7company")
				.setAddress2("7address2")
				.build();
	} 

	public IUser getInvalidUser() {
		return User.get()
				.setFirstName("7firstName")
				.setLastName("7lastName")
				.seteMail("7eMail")
				.setTelephone("7telephone")
				.setAddress1("7address1")
				.setCity("7city")
				.setPostCode("7Code")
				.setCountry("7country")
				.setRegionState("7State")
				.setPassword("7password")
				.setSubscribe(true)
				.setFax("7fax")
				.setCompany("7company")
				.setAddress2("7address2")
				.build();
	} 

	public IUser getHahahaUser() {
		return User.get()
				.setFirstName("hahaha")
				.setLastName("hahaha")
				.seteMail("hahaha@gmail.com")
				.setTelephone("1234567")
				.setAddress1("7address1")
				.setCity("7city")
				.setPostCode("7Code")
				.setCountry("7country")
				.setRegionState("7State")
				.setPassword(System.getenv().get("MY_PASSWORD"))
				.setSubscribe(true)
				.setFax("1234567")
				.setCompany("7company")
				.setAddress2("7address2")
				.build();
	} 

	public List<IUser> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public List<IUser> fromCsv() {
        return fromCsv("users.csv");
    }

    public List<IUser> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }

    public List<IUser> fromExcel() {
        return fromExcel("users.xlsx");
    }

    // TODO Read data DB, etc.

}
