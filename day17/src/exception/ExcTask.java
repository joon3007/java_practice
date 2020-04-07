package exception;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class ExcTask {
	public static void main(String[] args) {
		// 5칸 배열에 6개의 값을 넣을 때
		// try~ catch문으로 오류 메시지 출력

		try {
			int[] number = new int[5];
			int i = 0;
			while (true) {
				number[i++] = Integer.parseInt(JOptionPane.showInputDialog("정수입력"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("인덱스 초과");			
		}

	}
}
