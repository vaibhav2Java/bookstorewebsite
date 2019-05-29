package org.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bookstore.entity.Users;

public class UserDao extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDao() {
	}

	@Override
	public Users create(Users user) {

		return super.create(user);
	}
	
	public Users findByeEmail( String email){
	List<Users> listUser = super.findwithNamedQuery("Users.findByEmail", "email", email);
	if(listUser != null && listUser.size() > 0) {
		return listUser.get(0);
	}
	return null;
	}
	
	

	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);

	}

	@Override
	public List<Users> listAll() {
		return super.findwithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.countwithNamedQuery("Users.countAll");
	}
	
	public boolean checkLogin( String email,String password) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		
		List<Users> listUsers = super.findwithNamedQuery("Users.checkLogin", parameters);
		if(listUsers.size()==1) {
			return true;
		}
		return false;
	}

}
