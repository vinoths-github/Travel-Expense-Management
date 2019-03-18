package com.svinoth.io.resource;

public class UserDetails {
	
	private String UserName;
	//private boolean Participant;
	
	public UserDetails(String userName) {
		super();
		UserName = userName;
		//Participant = participant;

	}
	public UserDetails() {
		super();
	}
	
	/*public boolean isParticipant() {
		return Participant;
	}
	public void setParticipant(boolean participant) {
		Participant = participant;
	}*/

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	@Override
	public String toString() {
		return "UserDetails [UserName=" + UserName + "]";
	}
}
