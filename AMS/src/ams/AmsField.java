package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsField {
	// �װ��� ��ȣ, �װ���, �ִ�°���, �����, ������
	String[][] arPlane = new String[100][5];
	int routeCount;
	int selectNum;
	int rowNum = -1;
	String msg = "�װ����ȣ/�װ���/�ִ�°���/�����/������";
	final String title = "AMS";

	// �߰�
	private boolean insert(String[] plane) {
		// �װ���� ���� �߰�
		if (checkDup(plane[0]) == null) {
			if (rowNum == arPlane.length)
				return false;
			arPlane[routeCount++] = plane;
			return true;
		} else
			return false;
	}

	// �ߺ��˻�
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

	// ����
	private void update(String[] plane, int idx, String new_value) {
		idx += 3;
		plane[idx] = new_value;
			
	}

	// ����
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

	// �˻�(�װ��� ��ȣ, �װ���, �ִ�°���, �����, ������)
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

	// ������ ���� ���
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

	// ���
	private void selectAll() {
		printInfo(arPlane, routeCount);
	}

	// view
	void view() {
		String[] menu = { "�߰��ϱ�", "�����ϱ�", "�����ϱ�", "�˻��ϱ�", "��Ϻ���" };
		String[] search_category = { "�װ��� ��ȣ", "�װ���", "�ִ�°���", "�����", "������" };
		
		// ���� ��� : ���� � ��ġ�� �ִ��� ã�ư� �� �ִ� ���
		// ��� ��� : ���� ��ġ�� ���� ����Ǵ� ��� .(��������), ..(��������)
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
			// �߰�
			case 0:
				plane = ("" + JOptionPane.showInputDialog(null, "���� ��Ŀ� ���缭 �װ��⸦ �߰����ּ���\n" + "�װ����ȣ,�װ���,�ִ�°���,�����,������",
						title, JOptionPane.PLAIN_MESSAGE, icon, null, null)).split(",");
				if (plane.length != 5) {
					JOptionPane.showMessageDialog(null, "�߸� �Է��ϼ̽��ϴ�.");
					continue;
				}
				insert_result = insert(plane);
				if (insert_result) {
					msg = "�߰� ����";
				} else {
					msg = "�߰� ���� / �� �̻� �߰��� �� ����";
				}
				JOptionPane.showMessageDialog(null, msg);
				break;
			// ����
			case 1:
				
				keyword = "" + JOptionPane.showInputDialog(null, "�����Ͻ� " + search_category[choice] + "��(��) �Է��ϼ���",
						title, JOptionPane.PLAIN_MESSAGE, icon, null, null);
		
				break;
			// ����
			case 2:
				break;
			// �˻�
			case 3:
				choice = JOptionPane.showOptionDialog(null, "", title, JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, icon, search_category, null);

				keyword = "" + JOptionPane.showInputDialog(null, "�˻��Ͻ� " + search_category[choice] + "��(��) �Է��ϼ���",
						title, JOptionPane.PLAIN_MESSAGE, icon, null, null);

				msg = printInfo(select(choice, keyword),selectNum);
				JOptionPane.showMessageDialog(null, msg.equals("") ? "�˻� ��� ����" : msg);

				break;
			// ���
			case 4:
				msg = printInfo(arPlane, routeCount);
				JOptionPane.showMessageDialog(null, msg.equals("") ? "��� ����" : msg);
				break;
			}

		}
	}
}
