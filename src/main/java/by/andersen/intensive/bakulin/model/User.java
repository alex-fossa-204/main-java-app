package by.andersen.intensive.bakulin.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -8323533356102744580L;
	
	private Long userId;
	
	private String userName;
	
	private String firstName;
	
	private String secondName;
	
	private String lastName;
	
	private int age;
	
	private String phoneNumber;
	
	private String emailAddress;

	private Role userRole;
	
	
}
