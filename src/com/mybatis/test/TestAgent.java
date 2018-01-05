package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;

public class TestAgent {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void config() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void t3() throws IOException{
		// ����ȫ�������ļ�
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// ��������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ����session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> list = userDao.findAll();
		System.out.println(list);
	}
	
	@Test
	public void findUserByID() throws IOException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = userDao.findUserByID(2);
		System.out.println(user);
	}
	
	@Test
	public void findUserByName() throws IOException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> list = userDao.findUserByName("С");
		System.out.println(list);
	}
	
	@Test
	public void insertUser() throws IOException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = new User();
		user.setAge(25);
		user.setName("С��");
		user.setAddress("��������");
		userDao.insertUser(user);
		sqlSession.commit();
		System.out.println(user);
	}
	
	@Test
	public void updateUser() throws IOException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = new User();
		user.setId(12);
		user.setAge(25);
		user.setName("����");
		user.setAddress("���»�");
		userDao.updateUser(user);
		sqlSession.commit();
		System.out.println(user);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void findUserByVague(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		Map map = new HashMap<String,String>();
		map.put("name", "С��");
		map.put("age", "25");
		map.put("address", "��������");
		List<User> list = userDao.findUserByVague(map);
		System.out.println(list);
	}
	
	@Test
	public void findUserByNum(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = new User();
		user.setName("С��");
		user.setAge(25);
		int findUserByNum = userDao.findUserByNum(user);
		System.out.println(findUserByNum);
	}
	
	@Test
	public void findUserByProxy(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = new User();
		user.setName("С��");
		user.setAge(25);
//		user.setAddress("����˳��");
//		User userByProxy = mapper.findUserByProxy(user);
//		System.out.println(userByProxy);
		
		List<User> list = mapper.findUserByProxy(user);
		System.out.println(list);
	}
}
