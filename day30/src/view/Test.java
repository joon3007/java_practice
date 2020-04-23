package view;

import dao.DBConnection;
import dao.UserDAO;

public class Test {
	public static void main(String[] args) {
		System.out.println(DBConnection.getConnection());		
		UserDAO dao = new UserDAO();
		//System.out.println(dao.join("joon1", "1234", "ศึมุ4", 29, "01041418105"));
		System.out.println(dao.login("joon3008", "1234"));
	}
	
}
