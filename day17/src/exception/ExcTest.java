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
//			Integer.parseInt(JOptionPane.showInputDialog("정수입력"));
//			JOptionPane.showMessageDialog(null, "입력성공");
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "정수가 아닙니다.");
//			// TODO: handle exception
//		}finally {
//			JOptionPane.showMessageDialog(null, "안녕히가세요.");
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
