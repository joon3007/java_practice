package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsField {
	// 항공기 번호, 항공사, 최대승객수, 출발지, 도착지
	String[][] arPlane = new String[100][5];
	int routeCount;
	int selectNum;
	int rowNum = -1;
	String msg = "항공기번호/항공사/최대승객수/출발지/도착지";
	final String title = "AMS";

	// 추가
	private boolean insert(String[] plane) {
		// 항공경로 정보 추가
		if (checkDup(plane[0]) == null) {
			if (rowNum == arPlane.length)
				return false;
			arPlane[routeCount++] = plane;
			return true;
		} else
			return false;
	}

	// 중복검사
	private String[] checkDup(String plane_num) {
		String[] plane = null;
		for (int i = 0; i < routeCount; i++) {
			if (arPlane[i][0].equals(plane_num)) {
				plane = arPlane[i];
				rowNum = i;
				break;
			}
		}
		return plane;
	}

	// 수정
	private void update(String[] plane, int idx, String new_value) {
		idx += 3;
		plane[idx] = new_value;
			
	}

	// 삭제
	private boolean delete(String plane_num) {
		String[] plane = checkDup(plane_num);
		if (plane != null) {
			if (rowNum == 99) {
				arPlane[rowNum--] = null;
				return true;
			}
			for (int i = rowNum; i < routeCount; i++) {
				arPlane[i] = arPlane[i + 1];
			}
			routeCount--;
			return true;
		} else
			return false;
	}

	// 검색(항공기 번호, 항공사, 최대승객수, 출발지, 도착지)
	// method name : select
	// parameter type : (String)
	// return type : String[]
	// function : find route information using parameter(plane number)
	private String[][] select(int idx, String keyword) {
		String[][] result = new String[10][5];
		int cnt = 0;
		for (int i = 0; i < routeCount; i++) {
			if (arPlane[i][idx].contains(keyword)) {
				if (result.length == cnt)
					result = resize(result);
				result[cnt++] = arPlane[i];
			}
		}
		selectNum = cnt;
		return result;
	}

	// 비행경로 정보 출력
	private String printInfo(String[][] arrPlane, int count) {
		if (count == 0) {
			return "";
		}
		String result = "";
		System.out.println(msg);
		for (int i = 0; i < count; i++) {
			result += (i + 1) + ". ";
			for (int j = 0; j < 5; j++) {
				result += arrPlane[i][j] + "/ ";
			}
			result += "\n";
		}
		return result;
	}

	private String[][] resize(String[][] arr) {
		String[][] newArray = new String[2 * arr.length][5];
		for (int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}
		return newArray;
	}

	// 목록
	private void selectAll() {
		printInfo(arPlane, routeCount);
	}

	// view
	void view() {
		String[] menu = { "추가하기", "수정하기", "삭제하기", "검색하기", "목록보기" };
		String[] search_category = { "항공기 번호", "항공사", "최대승객수", "출발지", "도착지" };
		
		// 절대 경로 : 현재 어떤 위치에 있더라도 찾아갈 수 있는 경로
		// 상대 경로 : 현재 위치에 따라서 변경되는 경로 .(현재폴더), ..(이전폴더)
		ImageIcon icon = new ImageIcon("src/img/main.gif");
		int choice = 0;
		String[] plane = null;
		boolean insert_result = false;
		String msg = "";
		String keyword = "";

		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", title, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, icon, menu, null);

			if (choice == -1) {
				break;
			}

			switch (choice) {
			// 추가
			case 0:
				plane = ("" + JOptionPane.showInputDialog(null, "밑의 양식에 맞춰서 항공기를 추가해주세요\n" + "항공기번호,항공사,최대승객수,출발지,도착지",
						title, JOptionPane.PLAIN_MESSAGE, icon, null, null)).split(",");
				if (plane.length != 5) {
					JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
					continue;
				}
				insert_result = insert(plane);
				if (insert_result) {
					msg = "추가 성공";
				} else {
					msg = "추가 실패 / 더 이상 추가할 수 없음";
				}
				JOptionPane.showMessageDialog(null, msg);
				break;
			// 수정
			case 1:
				
				keyword = "" + JOptionPane.showInputDialog(null, "수정하실 " + search_category[choice] + "을(를) 입력하세요",
						title, JOptionPane.PLAIN_MESSAGE, icon, null, null);
		
				break;
			// 삭제
			case 2:
				break;
			// 검색
			case 3:
				choice = JOptionPane.showOptionDialog(null, "", title, JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, icon, search_category, null);

				keyword = "" + JOptionPane.showInputDialog(null, "검색하실 " + search_category[choice] + "을(를) 입력하세요",
						title, JOptionPane.PLAIN_MESSAGE, icon, null, null);

				msg = printInfo(select(choice, keyword),selectNum);
				JOptionPane.showMessageDialog(null, msg.equals("") ? "검색 결과 없음" : msg);

				break;
			// 목록
			case 4:
				msg = printInfo(arPlane, routeCount);
				JOptionPane.showMessageDialog(null, msg.equals("") ? "목록 없음" : msg);
				break;
			}

		}
	}
}
