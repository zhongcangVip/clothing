package com.clothing.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.clothing.model.user.User;

@Mapper
public interface UserDao {

	public User getUserById(String id);
	
	public User getUserByUserName(String userName);
	
	public List<User> getUserByList(Map<String,Object> params);

	public int insertUser(User user);
	
	public int updateUser(User user);
	
	
}
