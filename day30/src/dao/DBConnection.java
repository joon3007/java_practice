package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//jdbc : java database connectivity
	
	public static Connection getConnection() {
		Connection conn = null;
		//url, id, pw
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:Orcl";
			String user = "hr";
			String pw = "1234";
			//����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�ε��� ��ü ����
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("DB ���� ����!");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����!");
		} catch(SQLException sqle) {
			System.out.println("DB ���� ����");
		} catch(Exception e) {
			System.out.println("�� �� ���� ����");
		}
		return conn;
	}
}
