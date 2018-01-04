package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.User;

public interface UserDao {

	// ��ѯ����
	public List<User> findAll();

	// ����id��ѯ�û�
	public User findUserByID(int id);

	// ����������ѯ�û�
	public List<User> findUserByName(String name);

	// ��������
	public void insertUser(User user);
	
	public void updateUser(User user);
}
