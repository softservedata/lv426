package com.softserve.edu.opencart.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface IFirstName {
	ILastName setFirstName(String firstName);
}

interface ILastName {
	IEMail setLastName(String lastName);
}

interface IEMail {
	ITelephone seteMail(String eMail);
}

interface ITelephone {
	IAddress1 setTelephone(String telephone);
}

interface IAddress1 {
	ICity setAddress1(String address1);
}

interface ICity {
	IPostCode setCity(String city);
}

interface IPostCode {
	ICountry setPostCode(String postCode);
}

interface ICountry {
	IRegionState setCountry(String country);
}

interface IRegionState {
	IPassword setRegionState(String regionState);
}

interface IPassword {
	ISubscribe setPassword(String password);
}

interface ISubscribe {
	IUserBuild setSubscribe(boolean subscribe);
}

interface IUserBuild {
	IUserBuild setFax(String fax);
	IUserBuild setCompany(String company);
	IUserBuild setAddress2(String address2);
	// 5. Add Builder
	//User build();
	// 6. Add Dependency Inversion
	IUser build();
}

public class User implements IFirstName, ILastName,
			IEMail, ITelephone, IAddress1, ICity,
			IPostCode, ICountry, IRegionState,
			IPassword, ISubscribe, IUserBuild, IUser {

    public static enum UserColumns {
        FIRST_NAME(0),
        LAST_NAME(1),
        EMAIL(2),
        TELEPHONE(3),
        ADDRESS1(4),
        CITY(5),
        POST_CODE(6),
        COUNTRY(7),
        REGION_STATE(8),
        PASSWORD(9),
        SUBSCRIBE(10),
        FAX(11),
        COMPANY(12),
        ADDRESS2(13);
        //
        private int index;

        private UserColumns(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    private static final String EMAIL_SEPARATOR = "@";
    private static final String EMPTY_STRING = new String();
    private static final Logger logger = LoggerFactory.getLogger(User.class);

	private String firstName;
	private String lastName;
	private String eMail;
	private String telephone;
	private String fax; // optional
	private String company; // optional
	private String address1;
	private String address2; // optional
	private String city;
	private String postCode;
	private String country;
	private String regionState;
	private String password;
	private boolean subscribe;

	// 1. Classic Constructor
//	public User(String firstName, String lastName, String eMail, String telephone,
//			String address1, String city, String postCode, String country, String regionState,
//			String password, boolean subscribe) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.eMail = eMail;
//		this.telephone = telephone;
//		fax = "";
//		company = "";
//		this.address1 = address1;
//		address2 = "";
//		this.city = city;
//		this.postCode = postCode;
//		this.country = country;
//		this.regionState = regionState;
//		this.password = password;
//		this.subscribe = subscribe;
//	}

//	public User(String firstName, String lastName, String eMail, String telephone, String fax, String company,
//			String address1, String address2, String city, String postCode, String country, String regionState,
//			String password, boolean subscribe) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.eMail = eMail;
//		this.telephone = telephone;
//		this.fax = fax;
//		this.company = company;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.city = city;
//		this.postCode = postCode;
//		this.country = country;
//		this.regionState = regionState;
//		this.password = password;
//		this.subscribe = subscribe;
//	}

	// 2. Use Setters
	// public User() {
	// 4. Add Static Factory
//	private User() {
//		firstName = new String();
//		lastName = new String();
//		eMail = new String();
//		telephone = new String();
//		fax = "";
//		company = "";
//		address1 = new String();
//		address2 = "";
//		city = new String();
//		postCode = new String();
//		country = new String();
//		regionState = new String();
//		password = new String();
//		subscribe = true;
//	}
	
	// 5. Add Builder
	private User() {
		fax = "";
		company = "";
		address2 = "";
	}
	
	// 4. Add Static Factory
	//public static User get() {
	// 5. Add Builder
	public static IFirstName get() {
		return new User();
	} 
	
	// setters
	
	// 1. Classic Constructor
	// 2. Use Setters
	//public void setFirstName(String firstName) {
	// 3. Add Fluent Interface
	// public User setFirstName(String firstName) {
	// 5. Add Builder
	public ILastName setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public IEMail setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ITelephone seteMail(String eMail) {
		this.eMail = eMail;
		return this;
	}

	public IAddress1 setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public IUserBuild setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public IUserBuild setCompany(String company) {
		this.company = company;
		return this;
	}

	public ICity setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public IUserBuild setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public IPostCode setCity(String city) {
		this.city = city;
		return this;
	}

	public ICountry setPostCode(String postCode) {
		this.postCode = postCode;
		return this;
	}

	public IRegionState setCountry(String country) {
		this.country = country;
		return this;
	}

	public IPassword setRegionState(String regionState) {
		this.regionState = regionState;
		return this;
	}

	public ISubscribe setPassword(String password) {
		this.password = password;
		return this;
	}

	public IUserBuild setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
		return this;
	}

	// 5. Add Builder
	//public User build() {
	// 6. Add Dependency Inversion
	public IUser build() {
		return this;
	}
	
	// getters
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getFax() {
		return fax;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCountry() {
		return country;
	}

	public String getRegionState() {
		return regionState;
	}

	public String getPassword() {
		return password;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static IUser getByList(List<String> row) {
        //logger.trace("row.size() = " + row.size() + " UserColumns.values().length = " + UserColumns.values().length);
        List<String> userData = new ArrayList<>(row);
        for (int i = userData.size(); i < UserColumns.values().length; i++) {
            userData.add(EMPTY_STRING);
        }
        return User.get()
                .setFirstName(userData.get(UserColumns.FIRST_NAME.getIndex()))
                .setLastName(userData.get(UserColumns.LAST_NAME.getIndex()))
                .seteMail(userData.get(UserColumns.EMAIL.getIndex()))
                .setTelephone(userData.get(UserColumns.TELEPHONE.getIndex()))
                .setAddress1(userData.get(UserColumns.ADDRESS1.getIndex()))
                .setCity(userData.get(UserColumns.CITY.getIndex()))
                .setPostCode(userData.get(UserColumns.POST_CODE.getIndex()))
                .setCountry(userData.get(UserColumns.COUNTRY.getIndex()))
                .setRegionState(userData.get(UserColumns.REGION_STATE.getIndex()))
                .setPassword(userData.get(UserColumns.PASSWORD.getIndex()))
                .setSubscribe(Boolean.parseBoolean(userData
                		.get(UserColumns.SUBSCRIBE.getIndex()).toLowerCase()))
                .setFax(userData.get(UserColumns.FAX.getIndex()) != null ? userData.get(UserColumns.FAX.getIndex()) : EMPTY_STRING)
                //.setFax( userData.get(UserColumns.FAX.getIndex()) == null
                //            || userData.get(UserColumns.FAX.getIndex()).isEmpty()
                //        ? EMPTY_STRING : userData.get(UserColumns.FAX.getIndex()))
                .setCompany(userData.get(UserColumns.COMPANY.getIndex()) != null ? userData.get(UserColumns.COMPANY.getIndex()) : EMPTY_STRING)
                .setAddress2(userData.get(UserColumns.ADDRESS2.getIndex()) != null ? userData.get(UserColumns.ADDRESS2.getIndex()) : EMPTY_STRING)
                .build();
    }
	
    public static List<IUser> getByLists(List<List<String>> rows) {
        List<IUser> result = new ArrayList<>();
        // TODO Verify Test Data as Valid
        if (!rows.get(0).get(UserColumns.EMAIL.getIndex())
                .contains(EMAIL_SEPARATOR)) {
            rows.remove(0);
        }
        for (List<String> currentRow : rows) {
            result.add(getByList(currentRow));
        }
        return result;
    }

	@Override
	public String toString() {
		return "\n\tFirstname: " + getFirstName()
			+ "\tLastname: " + getLastName()
			+ "\tEmail: " + geteMail()
			+ "\tTelephone: " + getTelephone()
			+ "\tFax: " + getFax()
			+ "\tCompany: " + getCompany()
			+ "\tAddress1: " + getAddress1()
			+ "\tAddress2: " + getAddress2()
			+ "\tCity: " + getCity()
			+ "\tPostcode: " + getPostCode()
			+ "\tCountry: " + getCountry()
			+ "\tRegion: " + getRegionState()
			+ "\tPassword: " + getPassword();
	}
	
}
