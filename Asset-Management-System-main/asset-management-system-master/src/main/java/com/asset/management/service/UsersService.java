package com.asset.management.service;

import java.util.List;
import com.asset.management.entity.Users;

public interface UsersService {
	public List<Users>getUser();
	public Users getUsers(long usersId);
	public Users addUsers(Users users);
	public Users updateUsers(Users users);
	public void deleteUsers(long parseLong);
	public Users fetchUserByEmail(String email);
}
