package com.softserve.edu.opencart.data;

public class UserApp {

	public static void main(String[] args) {
		// 1. Classic Constructor
//		User user = new User("1firstName", "1lastName",
//				"1eMail", "1telephone", "1fax", "1company",
//				"1address1", "1address2", "1city",
//				"1postCode", "1country", "1regionState",
//				"1password", true);
//		System.out.println("user.geteMail() = " + user.geteMail());
		//
		// 2. Use Setters
//		User user = new User();
//		user.setFirstName("2firstName");
//		user.setLastName("2lastName");
//		user.seteMail("2eMail");
//		user.setTelephone("2telephone");
//		user.setFax("2fax");
//		user.setCompany("2company");
//		user.setAddress1("2address1");
//		user.setAddress2("2address2");
//		user.setCity("2city");
//		user.setPostCode("2postCode");
//		user.setCountry("2country");
//		user.setRegionState("2regionState");
//		user.setPassword("2password");
//		user.setSubscribe(true);
//		System.out.println("user.geteMail() = " + user.geteMail());
		//
		// 3. Add Fluent Interface
//		User user = new User()
//			.setFirstName("3firstName")
//			.setLastName("3lastName")
//			.seteMail("3eMail")
//			.setTelephone("3telephone")
//			.setFax("3fax")
//			.setCompany("3company")
//			.setAddress1("3address1")
//			.setAddress2("3address2")
//			.setCity("3city")
//			.setPostCode("3postCode")
//			.setCountry("3country")
//			.setRegionState("3regionState")
//			.setPassword("3password")
//			.setSubscribe(true);
//		System.out.println("user.geteMail() = " + user.geteMail());
		//
		// 4. Add Static Factory
//		User user = User.get()
//				.setFirstName("4firstName")
//				.setLastName("4lastName")
//				.seteMail("4eMail")
//				.setTelephone("4telephone")
//				.setFax("4fax")
//				.setCompany("4company")
//				.setAddress1("4address1")
//				.setAddress2("4address2")
//				.setCity("4city")
//				.setPostCode("4postCode")
//				.setCountry("4country")
//				.setRegionState("4regionState")
//				.setPassword("4password")
//				.setSubscribe(true);
//			System.out.println("user.geteMail() = " + user.geteMail());
		//
		// 5. Add Builder
//		User user = User.get()
//				.setFirstName("5firstName")
//				.setLastName("5lastName")
//				.seteMail("5eMail")
//				.setTelephone("5telephone")
//				.setAddress1("5address1")
//				.setCity("5city")
//				.setPostCode("5Code")
//				.setCountry("5country")
//				.setRegionState("5State")
//				.setPassword("5password")
//				.setSubscribe(true)
//				.setAddress2("5address2")
//				.setCompany("5company")
//				.build();
//		System.out.println("user.geteMail() = " + user.geteMail());
//		System.out.println("user.geteMail() = " + user.seteMail("hahaha")); // Code Smell
		// CODE...
//		System.out.println("user.geteMail() = " + user.geteMail());
		//
		// 6. Add Dependency Inversion
//		IUser user = User.get()
//				.setFirstName("6firstName")
//				.setLastName("6lastName")
//				.seteMail("6eMail")
//				.setTelephone("6telephone")
//				.setAddress1("6address1")
//				.setCity("6city")
//				.setPostCode("6Code")
//				.setCountry("6country")
//				.setRegionState("6State")
//				.setPassword("6password")
//				.setSubscribe(true)
//				.setAddress2("6address2")
//				.setCompany("6company")
//				.build();
		//System.out.println("user.geteMail() = " + ((User) user).seteMail("hahaha")); // Code Smell
		//System.out.println("user.geteMail() = " + user.seteMail("hahaha")); // Compile Error
		// CODE...
//		System.out.println("user.geteMail() = " + user.geteMail());
		//
		// 7. 8. Add Singleton, Repository
		IUser user = UserRepository.get().getHahahaUser();
		System.out.println("user.geteMail() = " + user.geteMail());
		System.out.println("user.getPassword() = " + user.getPassword());
	}

}
