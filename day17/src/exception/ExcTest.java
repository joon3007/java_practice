package exception;

import javax.swing.JOptionPane;

public class ExcTest {
	public static void main(String[] args) {

		
		try {
			System.out.println(10/0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			Integer.parseInt(JOptionPane.showInputDialog("�����Է�"));
//			JOptionPane.showMessageDialog(null, "�Է¼���");
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "������ �ƴմϴ�.");
//			// TODO: handle exception
//		}finally {
//			JOptionPane.showMessageDialog(null, "�ȳ���������.");
//		}
		
		
		//		try {
//			System.out.println(10 / 0);
//		} catch (Exception e) {
//			System.out.println(e);
//		}finally {
//			
//		}
	}
}
