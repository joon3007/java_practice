package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import vo.UserVO;

public class UserDAO {
	// 연결 객체
	Connection conn;
	// 쿼리문 객체
	PreparedStatement pstm;
	// 결과 객체
	ResultSet rs;
	// 유져 객체
	UserVO user;
	String session = null;
	// 암호화 키
	private final int key = 3;

	// 아이디 검사
	public boolean check_id(String id) {
		// DB에서 외부에서 전달받은 id를 검색하고 검색 결과 건수를 가져온다.
		String query = "SELECT COUNT(*) FROM \"USER\" WHERE ID = ?";
		boolean check = false;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			// ?자리에 원하는 값 넣기
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			// resultset객체는 결과를 가져오기 전 next()메소드를 반드시 사용해 주어야 한다.
			rs.next();
			if (rs.getInt(1) == 0) {
				// 검색 결과가 0건, 즉 중복없음
				check = false;
			} else
				check = true;
		} catch (SQLException e) {
			System.out.println("check_id() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
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

	// 회원가입
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
				System.out.println("join() 쿼리문 오류");
			} catch (Exception e) {
				System.out.println("알 수 없는 오류");
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

	// 로그인
	public int login(String id, String pw) {
		// 아이디와 패스워드로 로그인 시도
		// db에서 id검사후 pw비교
		// 로그인 성공시 session객체에 id담아주기
		// 관리자 계정은 USER_NUMBER가 0이다.
		// 리턴 타임은 INT로 한다.
		// -1 로그인 실패
		// 0 관리자 계정
		// 1 그외 일반계정
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
				// 로그인 성공 true
				// 로그인 실패 false
				if (rs.next()) { // 행(인스턴스, 로우)
					String temp = rs.getString(2);
					System.out.println(temp == encrypt(pw));
					System.out.println(decrypt(temp));
					if (rs.getInt(1) == 1) { // 열 데이터(컬럼)
						check = 0;
					} else {
						check = 1;
					}
					session = id;
				}

			} catch (SQLException e) {
				System.out.println("login() 쿼리문 오류");
			} catch (Exception e) {
				System.out.println("알 수 없는 오류");
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

	// 수정
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
				System.out.println("update() 쿼리문 오류");
			} catch (Exception e) {
				System.out.println("알 수 없는 오류");
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

	// 삭제
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
			System.out.println("delete() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
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

	// 검색
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
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
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
	// 목록
	// 아이디 찾기
	// 비번 찾기

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
