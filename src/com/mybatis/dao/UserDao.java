package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.User;

public interface UserDao {

	// 查询所有
	public List<User> findAll();

	// 根据id查询用户
	public User findUserByID(int id);

	// 根据姓名查询用户
	public List<User> findUserByName(String name);

	// 插入数据
	public void insertUser(User user);
	
	public void updateUser(User user);
}
