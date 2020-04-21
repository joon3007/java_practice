package view;

import dao.DBConnection;
import dao.UserDAO;

public class Test {
	public static void main(String[] args) {
		System.out.println(DBConnection.getConnection());		
		UserDAO dao = new UserDAO();
		System.out.println(dao.check_id("JOON"));
		System.out.println(dao.join("joon4141", "1234", "ศึมุ2", 29, "01041418105"));
	}
	
}
