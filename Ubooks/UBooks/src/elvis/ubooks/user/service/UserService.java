package elvis.ubooks.user.service;

import elvis.ubooks.user.dao.UserDao;
import elvis.ubooks.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();

	public void register(User form) throws UserException {
		if(userDao.findByUsername(form.getUsername()) != null) throw new UserException("Username had been used");
		else if(userDao.findByEmail(form.getEmail()) != null) throw new UserException("Email had been used");
		userDao.add(form);
	}

	public void active(String code) throws UserException {
		User user = userDao.findByCode(code);
		if(user ==  null) throw new UserException("Invalid activation code");
		else if(user.isState()) throw new UserException("already Active");
		
		userDao.updateState(code,true);
	}

	public User login(User form) throws UserException {
		User user = userDao.findByUsername(form.getUsername());
		if(user == null) throw new UserException("username doesn't exist ");
		else if(!user.isState()) throw new UserException("user hasn't active yet");
		else if(!user.getPassword().equals(form.getPassword()))
			throw new UserException("username or password wrong");
		return user;
	}
	
	public User adminLogin(User form) throws UserException{
		User user = userDao.findByUsername(form.getUsername());
		if(user == null) throw new UserException("Access denied, username and password don't match");
		else if(!user.isState()) throw new UserException("Access denied, account not activated");
		else if(!user.isAdmin()) throw new UserException("Access denied, unauthrized");
		else if(!user.getPassword().equals(form.getPassword())) throw new UserException("Access denied, username and password don't match");
		return user;
		
	}
}
