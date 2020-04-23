package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import vo.UserVO;

public class UserDAO {
	// ���� ��ü
	Connection conn;
	// ������ ��ü
	PreparedStatement pstm;
	// ��� ��ü
	ResultSet rs;
	// ���� ��ü
	UserVO user;
	String session = null;
	// ��ȣȭ Ű
	private final int key = 3;

	// ���̵� �˻�
	public boolean check_id(String id) {
		// DB���� �ܺο��� ���޹��� id�� �˻��ϰ� �˻� ��� �Ǽ��� �����´�.
		String query = "SELECT COUNT(*) FROM \"USER\" WHERE ID = ?";
		boolean check = false;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			// ?�ڸ��� ���ϴ� �� �ֱ�
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			// resultset��ü�� ����� �������� �� next()�޼ҵ带 �ݵ�� ����� �־�� �Ѵ�.
			rs.next();
			if (rs.getInt(1) == 0) {
				// �˻� ����� 0��, �� �ߺ�����
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
		if (!check_id(id)) {
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
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char) (pw.charAt(i) * key);
		}
		return en_pw;
	}

	private String decrypt(String pw) {
		String de_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			de_pw += (char) (pw.charAt(i) / key);
		}
		return de_pw;
	}

	// �α���
	public int login(String id, String pw) {
		// ���̵�� �н������ �α��� �õ�
		// db���� id�˻��� pw��
		// �α��� ������ session��ü�� id����ֱ�
		// ������ ������ USER_NUMBER�� 0�̴�.
		// ���� Ÿ���� INT�� �Ѵ�.
		// -1 �α��� ����
		// 0 ������ ����
		// 1 �׿� �Ϲݰ���
		String query = "";
		int check = -1;
		if (check_id(id)) {
			query = "SELECT USER_NUMBER, PW FROM \"USER\" WHERE ID = ? and PW = ?";
			try {
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setString(1, id);
				pstm.setString(2, encrypt(pw));
				rs = pstm.executeQuery();
				// �α��� ���� true
				// �α��� ���� false
				if (rs.next()) { // ��(�ν��Ͻ�, �ο�)
					String temp = rs.getString(2);
					System.out.println(temp == encrypt(pw));
					System.out.println(decrypt(temp));
					if (rs.getInt(1) == 1) { // �� ������(�÷�)
						check = 0;
					} else {
						check = 1;
					}
					session = id;
				}

			} catch (SQLException e) {
				System.out.println("login() ������ ����");
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

	// ����
	public boolean update(String pw, String new_pw) {
		String query = "";
		boolean check = false;
		if (session != null) {
			query = "UPDATE \"USER\" SET PW ? WHERE ID = ? AND PW = ?";
			try {
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setString(1, encrypt(new_pw));
				pstm.setString(2, session);
				pstm.setString(3, encrypt(pw));
				check = pstm.execute();

			} catch (SQLException e) {
				System.out.println("update() ������ ����");
			} catch (Exception e) {
				System.out.println("�� �� ���� ����");
			} finally {
				try {
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

	public void logout() {
		session = null;
	}

	// ����
	public boolean delete(String id) {
		String query = "";
		boolean check = false;
		try {
			if (check_adim(session)) {
				query = "DELETE FROM \"USER\" WHERE ID = ?";
				pstm = conn.prepareStatement(query);
				pstm.setString(1, id);
				check = pstm.execute();
			}
		} catch (SQLException e) {
			System.out.println("delete() ������ ����");
		} catch (Exception e) {
			System.out.println("�� �� ���� ����");
		} finally {
			try {
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

	// �˻�
	public UserVO selectAll() {
		String query = "";
		UserVO user = null;
		try {
			query = "SELECT * FROM \"USER\" WHERE ID = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session);
			rs = pstm.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setPhone_number(rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("select() ������ ����");
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
		return user;
	}
	// ���
	// ���̵� ã��
	// ��� ã��

	private boolean check_adim(String id) throws SQLException {
		String query = "SELECT USER_NUMBER FROM \"USER\" WHERE ID = ?";
		boolean check = false;
		conn = DBConnection.getConnection();
		pstm = conn.prepareStatement(query);
		pstm.setString(1, id);
		rs = pstm.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) == 1) {
				check = true;
			}
		}
		return check;
	}
}
