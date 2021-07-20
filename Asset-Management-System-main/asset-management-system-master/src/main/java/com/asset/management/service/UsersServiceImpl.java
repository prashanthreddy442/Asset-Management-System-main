package com.asset.management.service;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asset.management.dao.UsersDao;
import com.asset.management.entity.Users;
@Service
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao usersDao;
	public UsersServiceImpl() {
		
	}

	@Override
	public List<Users> getUser() {
		return usersDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Users getUsers(long usersId) {
		return usersDao.getOne(usersId);
	}

	@Override
	public Users addUsers(Users users)
	{
		usersDao.save(users);
		return users;
	}

	@Override
	public Users updateUsers(Users users) {
		usersDao.save(users);
		return users;
	}

	@Override
	public void deleteUsers(long parseLong) {
		@SuppressWarnings("deprecation")
		Users entity=usersDao.getOne(parseLong);
		usersDao.delete(entity);
		
	}
	@Override
	public Users fetchUserByEmail(String email) {
		return usersDao.findByEmail(email);
	}

}
