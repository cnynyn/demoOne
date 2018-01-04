package com.mybatis.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// �������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			// ͨ�������������ȡ���ݿ�����
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?characterEncoding=utf-8",
					"root", "root");
			// ����sql��� ?��ʾռλ��
			String sql = "select * from user where name = ?";
			// ��ȡԤ����statement
			preparedStatement = connection.prepareStatement(sql);
			// ���ò�������һ������Ϊsql����в�������ţ���1��ʼ�����ڶ�������Ϊ���õĲ���ֵ
			preparedStatement.setString(1, "С��");
			// �����ݿⷢ��sqlִ�в�ѯ����ѯ�������
			resultSet = preparedStatement.executeQuery();
			// ������ѯ�����
			while (resultSet.next()) {
				System.out.println("id:" + resultSet.getString("id") + "\tname:"
						+ resultSet.getString("name") + "\tage:"
						+ resultSet.getString("age") + "\taddress:"
						+ resultSet.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
