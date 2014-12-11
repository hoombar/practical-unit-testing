package main.java.ch05.subscribers;

public class UserServiceImpl {

	private UserDAO mUserDAO;
	private SecurityService mSecurityService;
	
	public UserServiceImpl(UserDAO dao, SecurityService security) {
		this.mUserDAO = dao;
		this.mSecurityService = security;
	}

	public void assignPassword(User user, String newPassword) throws RuntimeException {
		String passwordMd5 = mSecurityService.md5(newPassword);
		user.setPassword(passwordMd5);
		mUserDAO.updateUser(user);
	}
}
