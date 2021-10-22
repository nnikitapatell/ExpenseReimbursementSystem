package main.model;

import main.constants.UserType;

/**
 * @author niki3
 *
 */
public class User {
//	private static final long serialVersionUID = 1L; //automatically generates a unique identifier
	private int ersUsersID;
	private String ersUsername;
	private String ersPassword;
	private String usersFirstName;
	private String usersLastName; 
	private String usersEmail;
	private UserType userType;

	
	
	/**
	 * argument constructor
	 * @param ersUsersID
	 * @param ersUsername
	 * @param ersPassword
	 * @param usersFirstName
	 * @param usersLastName
	 * @param usersEmail
	 * @param userRoleID
	 * @param userType
	 */
	public User(int ersUsersID, String ersUsername, String ersPassword, String usersFirstName, String usersLastName,
			String usersEmail, int userRoleID) {
		super();
		this.ersUsersID = ersUsersID;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.usersFirstName = usersFirstName;
		this.usersLastName = usersLastName;
		this.usersEmail = usersEmail;
		this.userType = UserType.fromInt(userRoleID);
	}

	/*
	 * getters and setters: 
	 */
	
	/**
	 * @return the ersUsersID
	 */
	public int getErsUsersID() {
		return ersUsersID;
	}

	/**
	 * @param ersUsersID the ersUsersID to set
	 */
	public void setErsUsersID(int ersUsersID) {
		this.ersUsersID = ersUsersID;
	}
	/**
	 * @return the ersUsername
	 */
	public String getErsUsername() {
		return ersUsername;
	}
	/**
	 * @param ersUsername the ersUsername to set
	 */
	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}
	/**
	 * @return the ersPassword
	 */
	public String getErsPassword() {
		return ersPassword;
	}
	/**
	 * @param ersPassword the ersPassword to set
	 */
	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}
	/**
	 * @return the usersFirstName
	 */
	public String getUsersFirstName() {
		return usersFirstName;
	}
	/**
	 * @param usersFirstName the usersFirstName to set
	 */
	public void setUsersFirstName(String usersFirstName) {
		this.usersFirstName = usersFirstName;
	}
	/**
	 * @return the usersLastName
	 */
	public String getUsersLastName() {
		return usersLastName;
	}
	/**
	 * @param usersLastName the usersLastName to set
	 */
	public void setUsersLastName(String usersLastName) {
		this.usersLastName = usersLastName;
	}
	/**
	 * @return the usersEmail
	 */
	public String getUsersEmail() {
		return usersEmail;
	}
	/**
	 * @param usersEmail the usersEmail to set
	 */
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [ersUsersID=" + ersUsersID + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", usersFirstName=" + usersFirstName + ", usersLastName=" + usersLastName + ", usersEmail="
				+ usersEmail + ", userType=" + userType + "]";
	}



}
