package exception;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class ExcTask {
	public static void main(String[] args) {
		// 5ĭ �迭�� 6���� ���� ���� ��
		// try~ catch������ ���� �޽��� ���

		try {
			int[] number = new int[5];
			int i = 0;
			while (true) {
				number[i++] = Integer.parseInt(JOptionPane.showInputDialog("�����Է�"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("�ε��� �ʰ�");			
		}

	}
}
