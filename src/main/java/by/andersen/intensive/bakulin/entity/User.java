package by.andersen.intensive.bakulin.entity;

import java.io.Serializable;
import java.util.Objects;

import by.andersen.intensive.bakulin.entity.impl.Entity;

public class User extends Entity implements Serializable {

	private static final long serialVersionUID = -8323533356102744580L;

	private String userName;

	private String firstName;

	private String secondName;

	private String lastName;

	private int age;

	private String phoneNumber;

	private String emailAddress;
	
	private String password;

	private String userRole;
	
	public User(String userName, String firstName, String secondName, String lastName, int age, String phoneNumber,
			String emailAddress, String password, String userRole) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.userRole = userRole;
	}

	public User(String userName, String firstName, String secondName, String lastName, int age, String phoneNumber,
			String emailAddress, String userRole) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.userRole = userRole;
	}
	
	public User(String userName, String firstName, String secondName, String lastName, int age, String phoneNumber,
			String emailAddress) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public User() {
		super();
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(age, emailAddress, firstName, lastName, password, phoneNumber,
				secondName, userName, userRole);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(emailAddress, other.emailAddress)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(secondName, other.secondName) && Objects.equals(userName, other.userName)
				&& Objects.equals(userRole, other.userRole);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userName=");
		builder.append(userName);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", secondName=");
		builder.append(secondName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", age=");
		builder.append(age);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userRole=");
		builder.append(userRole);
		builder.append("]");
		return builder.toString();
	}

}
