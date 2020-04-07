package caffe_system;

import java.util.Random;

import javax.swing.JOptionPane;

public class CaffeSystem {
	public static void main(String[] args) {
		// �ó�����
		// �⺻ �ֹ� �ó�����
		// 1. �� ���α׷��� ī�信�� ���� ���ϴ� �޴��� �����ϰ� �޴��� ���� �߰������� ������ �� ���ϴ�
		// ���ϴ� ���ҹ������ ������ �� �� �ִ� �ý����̴�.
		// 2. ī���� �޴��� �� ī�װ��� "Ŀ��, �꽺, ������"�� ������, �� ī�װ��� "�Ƹ޸�ī��,
		// ����������, īǪġ��, ī����", "������ �꽺, �����꽺, �ڸ� �꽺", "��ȭ��, ������"�ִ�.
		// 4. ������ ��� ����, ī��, ����Ʈ�� ��� �� �� �ִ�. ����Ʈ ����� ��� �κ� ���� ��ü ������� ������ ����.

		// �����ý���
		// 1. ī��� ��ü �޴��� ���� 20%���� ������ ������, 4�ڸ��� �̷���� ������ 1000�� �߱��Ѵ�.
		// 2. ������ȣ�� 4�ڸ� ������ �����̸�, ������ �ߺ� ��� �� ������.

		// ����Ʈ �ý���
		// 1. �ֹ��� �� �����ݾ��� 20%�� ������ �Ǹ�, 500����Ʈ �̻���� ��� �����ϴ�.
		// 2. ���� ����Ʈ ��뿩�θ� ���� �� �� ������, ����Ʈ�� ����� ��� ����Ʈ ������ �����ʴ´�.

		// title
		
		String title = "��Ŀ���ֹ��ý��ۡ�";
		// ���θ޴�
		String[] menu_category = { "���� ����", "��ٱ��� Ȯ��", "����Ʈ Ȯ��", "�����ϱ�", "������" };
		// �����޴�
		String[] payment_category = { "����Ʈ ���", "�������", "��������", "���� �޴���" };
		// ���� ī�װ�
		String[] A_category = { "Ŀ��", "�꽺", "������" };
		String[][] B_category = { { "����������", "�Ƹ޸�ī��", "īǪġ��", "ī����" }, { "������ �꽺", "���� �꽺", "�ڸ� �꽺" },
				{ "��ȭ��", "������" } };
		// �޽��� ����
		String good_bye_msg = "�����մϴ�.";
		String nullMsg = "��ٱ��ϰ� ������ϴ�.";
		String confirmMsg = "��ǰ�� ��ٱ��Ͽ� �����ϴ�.";
		String errMsg = "�ٽ� �õ����ּ���";

		// ���� ����
		int[][] B_price = { { 2000, 3000, 3500, 3500 }, { 3500, 3500, 3500 }, { 3000, 2000 } };
		int[] Additional_price = { 500, 500, 500, 500 };

		int point = 0;
		int money = 1_000_000;

		// ���� ������ ���� �����Լ�
		Random r = new Random();
		int coupon = r.nextInt(9000) + 1000;
		// ������ �׽�Ʈ
		System.out.println(coupon);

		int myCoupon = 0;
		String CouponMsg = "[20% ���� ����]\n";
		// ���� ��뿩�� üũ
		boolean usePoint = false;
		boolean couponCheck = false;

		int choice = 0;

		for (int i = 0; i < menu_category.length; i++) {
			title += "\n" + (i + 1) + ". " + menu_category[i];
		}
		// ��ٱ��Ͽ� ��� �޴��� ��
		int choice_num = 0;
		// ��ٱ��� ����
		String[] shopping_basket = new String[5];
		int[] shopping_price = new int[5];

		// ��ٱ��Ͽ� ��� �� �ݾ�
		int total = 0;
		while (choice != 5) {
			// ��ٱ��Ͽ� ��� �޴��� 5�� �̻��϶� ������ ������.
			// �̱���
			String msg = "";
			choice = Integer.parseInt(JOptionPane.showInputDialog(title));
			switch (choice) {
			// �޴� ���� : �޴� ���ý� ��ٱ��Ͽ� ����.
			// �ڷΰ��� �̱���
			case 1:
				// �޴� ���ÿ� ���� ī���ڸ� ���� �� ����
				String[] next_category;
				int[] next_price;

				for (int i = 0; i < A_category.length; i++) {
					msg += "\n" + (i + 1) + ". " + A_category[i];
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(msg));
				msg = "";
				// �޴� ���ý� �ε����� ���ٿ� �׿� �´� �� ī�װ��� ������ �Ҵ�ȴ�.
				if (choice != A_category.length + 1) {
					next_category = B_category[choice - 1];
					next_price = B_price[choice - 1];
				} else {
					JOptionPane.showMessageDialog(null, good_bye_msg);
					break;
				}
				// �� ī�׼Ҹ��� �����ֱ� ���� msg�ۼ� �κ�
				for (int i = 0; i < next_category.length; i++) {
					msg += (i + 1) + ". " + next_category[i] + " " + next_price[i] + "��\n";
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(msg));

				// �޴��� �����ϸ� �޴��� ��ٱ��� ������ �Ҵ�ȴ�.
				shopping_basket[choice_num] = next_category[choice - 1];
				shopping_price[choice_num] = next_price[choice - 1];
				total += next_price[choice - 1];
				choice_num++;
				JOptionPane.showMessageDialog(null, confirmMsg);
				break;
			// ��ٱ��Ͽ� ����� �޴��� �� �ݾ��� ������ش�.
			// ��ٱ��� ���� �̱���
			case 2:
				msg += "����ٱ��ϡ�\n";
				if (shopping_basket[0].equals(null)) {
					JOptionPane.showMessageDialog(null, nullMsg);
				} else {
					for (int i = 0; i < choice_num; i++) {
						msg += (i + 1) + ". " + shopping_basket[i] + "\n";
					}
					JOptionPane.showMessageDialog(null, msg + "�� ����: " + total + "��");
				}
				continue;
			// ����Ʈ Ȯ��
			case 3:
				JOptionPane.showMessageDialog(null, "���� ����Ʈ : " + point);
				continue;
			// �����ϱ�
			case 4:
				choice = 0;
				int result = total;
				while (choice != 4) {
					msg = "";
					msg += "�� ���� : " + result + "��\n";
					// ���� ��ٱ��Ͽ� ��� ��ǰ�� �ѱݾ��� ����Ѵ�.
					for (int i = 0; i < payment_category.length; i++) {
						msg += "\n" + (i + 1) + ". " + payment_category[i];
					}
					choice = Integer.parseInt(JOptionPane.showInputDialog(msg));

					switch (choice) {
					// ����Ʈ ���
					case 1:
						// ����Ʈ�� 500�� ������ ��� ����� �� ����.
						if (point > 500) {
							int use_point = 500 * (point / 500);
							result = total - use_point;
							point -= use_point;
							usePoint = true;
							JOptionPane.showMessageDialog(null, "����Ʈ�� " + use_point + "�� ���Ǿ����ϴ�.");
						} else {
							JOptionPane.showMessageDialog(null, "����Ʈ�� 500�̻��� �� ��밡�� �մϴ�.");
						}
						continue;
					// ������ �Է��ϰ� �׿� �´� ���� ������ �����Ѵ�.
					case 2:
						if (!couponCheck) {
							myCoupon = Integer.parseInt(JOptionPane.showInputDialog("���� ��ȣ �Է�"));
							if (myCoupon == coupon) {
								JOptionPane.showMessageDialog(null, CouponMsg + "��� ����!");
								couponCheck = true;
								result = (int) (result * 0.8);
							} else
								JOptionPane.showMessageDialog(null, "�߸��� ������ȣ �Դϴ�.");
						} else
							JOptionPane.showMessageDialog(null, "�̹� ������ ����ϼ̽��ϴ�.");
						continue;
					// ���������κ�
					case 3:
						String result_msg = "�����Ϸ�. ���� �ݾ� : %d\n";
						money -= result;
						if (!usePoint) {
							point += 0.2 * result;
							result_msg += "����Ʈ ���� �Ϸ�!";
						}
						result_msg = String.format(result_msg, money);
						JOptionPane.showMessageDialog(null, result_msg);
						choice = 4;

						// ��ٱ��� �ʱ�ȭ
						// ������ �Ϸ��ϰ� ��ٱ��ϸ� ����.
						usePoint = false;
						couponCheck = false;
						shopping_basket = new String[5];
						shopping_price = new int[5];
						total = 0;
						break;
					case 4:
						break;
					default:
						JOptionPane.showMessageDialog(null, errMsg);
					}
				}
				choice = 0;
			case 5:
				JOptionPane.showMessageDialog(null, good_bye_msg);
				continue;
			default:
				JOptionPane.showMessageDialog(null, errMsg);
			}
		} // while�� ����

	}
}
