package com.mybatis.dao;

import java.util.List;
import java.util.Map;

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
	
	// ʹ��parameterType����ӳ��"map"
	@SuppressWarnings("rawtypes")
	public List<User> findUserByVague(Map map);
	
	// ʹ��resultType���int����
	public int findUserByNum(User user);
	
	// ʹ��resultMap���ӳ��
	public List<User> findUserByProxy(User user);
}
