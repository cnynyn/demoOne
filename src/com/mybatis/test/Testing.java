package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;

public class Testing {
	
	SqlSessionFactory sqlSessionFactory;

	@Before
	public void configSqlMapConfig() throws Exception {
		// 加载全局配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 使用mybatis的类sqlSesionfactoryBuider创建工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void t1() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("test.findAll");
		System.out.println(list.toString());
	}
	
	@Test
	public void t2() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setAge(25);
		user.setName("小胖");
		user.setAddress("北京海淀");
		sqlSession.insert("test.insertUser2", user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println("id:"+user.getId());
	}
	
	@Test
	public void t3() throws IOException{
		// 加载全局配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 开启session
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
		List<User> list = userDao.findUserByName("小");
		System.out.println(list);
	}
	
	@Test
	public void insertUser() throws IOException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = new User();
		user.setAge(25);
		user.setName("小海");
		user.setAddress("北京延庆");
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
		user.setName("聂风");
		user.setAddress("天下会");
		userDao.updateUser(user);
		sqlSession.commit();
		System.out.println(user);
	}
}

