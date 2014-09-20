package utils;

public class LoginBean {
	
	private String userName;
	private String userPassword;
	
	private boolean autorize;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean getAutorize() {
		// If user name anda password is correct
		if (userName.equals("banana") && userPassword.equals("pera"))
			autorize = true;
		else if (userName.equals("abacaxi") && userPassword.equals("uva"))
			autorize = true;
		else
			autorize = false;
		return autorize;
	}
}
