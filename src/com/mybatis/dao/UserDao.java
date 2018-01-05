package com.mybatis.dao;

import java.util.List;
import java.util.Map;

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
	
	// 使用parameterType输入映射"map"
	@SuppressWarnings("rawtypes")
	public List<User> findUserByVague(Map map);
	
	// 使用resultType结果int类型
	public int findUserByNum(User user);
	
	// 使用resultMap输出映射
	public List<User> findUserByProxy(User user);
}
