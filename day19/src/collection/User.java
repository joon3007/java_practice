package collection;

import java.util.ArrayList;

public class User {
	ArrayList<ArrayList<String>> users = new ArrayList<>();
	private static ArrayList<String> session;
	
	public static ArrayList<String> getSession() {
		return session;
	}
	
	//회원가입(아이디, 패스워드, 이름)
	public void signIn(ArrayList<String> user) {
		user.set(1, encrypt(user.get(1)));
		users.add(user);
	}
	//로그인(아이디, 패스워드)
	public boolean login(String id, String pw) {
		for(ArrayList<String> user : users) {
			if(user.get(0).equals(id) && decrypt(user.get(1)).equals(pw)) {
				session = user;
				return true;
			}
		}
		return false;
	}
	public void logout() {
		session = null;
	}
	//암호화
	final int key  = 3;
	public String encrypt(String pw) {
		String result = "";
		for (int i = 0; i < pw.length(); i++) {
			result += (char)(pw.charAt(i) * key);
		}
		return result;
	}
	//복호화
	public String decrypt(String pw) {
		String result = "";
		for (int i = 0; i < pw.length(); i++) {
			result += (char)(pw.charAt(i) / key);
		}
		return result;
	}
}
