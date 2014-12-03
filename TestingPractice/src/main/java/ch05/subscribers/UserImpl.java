package main.java.ch05.subscribers;

public class UserImpl implements User {

	private String mPassword;
	
	@Override
	public String getPassword() {
		return mPassword;
	}

	@Override
	public void setPassword(String password) {
		mPassword = password;
	}

}
