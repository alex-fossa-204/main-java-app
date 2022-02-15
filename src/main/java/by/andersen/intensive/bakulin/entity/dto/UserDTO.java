package by.andersen.intensive.bakulin.entity.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 8624712857029705309L;

	private String firstName;

	private String secondName;

	private String lastName;

	public UserDTO(String firstName, String secondName, String lastName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
	}

	public UserDTO() {
		super();
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

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, secondName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(secondName, other.secondName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [firstName=");
		builder.append(firstName);
		builder.append(", secondName=");
		builder.append(secondName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}

}
