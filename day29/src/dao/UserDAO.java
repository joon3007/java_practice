package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import vo.UserVO;

public class UserDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	UserVO user;
	private final int key = 3;
	// ���̵� �˻�
	public boolean check_id(String id) {
		String query = "SELECT COUNT(*) FROM \"USER\" WHERE ID = ?";
		boolean check = false;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			//resultset��ü�� ����� �������� �� next()�޼ҵ带  �ݵ�� ����� �־�� �Ѵ�.
			rs.next();
			if (rs.getInt(1) == 0) {
				check = false;
			} else
				check = true;
		} catch (SQLException e) {
			System.out.println("check_id() ������ ����");
		} catch (Exception e) {
			System.out.println("�� �� ���� ����");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}

	// ȸ������
	public boolean join(String id, String pw, String name, int age, String phone_number) {
		String query = "";
		int idx = 0;
		boolean check = false;
		if(!check_id(id)) {
			query = "INSERT INTO \"USER\" (USER_NUMBER, ID, PW, NAME, AGE, PHONE_NUMBER)"
					+ "VALUES(USER_SEQ.NEXTVAL,?,?,?,?,?)";
			try {
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setString(++idx, id);
				pstm.setString(++idx, encrypt(pw));
				pstm.setString(++idx, name);
				pstm.setInt(++idx, age);
				pstm.setString(++idx, phone_number);
				pstm.executeQuery();
				check = true;
				
			} catch (SQLException e) {
				System.out.println("join() ������ ����");
			} catch (Exception e) {
				System.out.println("�� �� ���� ����");
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return check;
	}
	private String encrypt(String pw) {
		String en_pw ="";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * key);
		}
		return en_pw;
	}
	
	private String decrypt(String pw) {
		String de_pw ="";
		for (int i = 0; i < pw.length(); i++) {
			de_pw += (char)(pw.charAt(i) / key);
		}
		return de_pw;
	}
	// �α���
	// ����
	// ����
	// �˻�
	// ���
	// ���̵� ã��
	// ��� ã��
}
