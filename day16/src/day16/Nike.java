package day16;

public class Nike{
	//����ϴ� �޼ҵ� ����
	//�Ű������� Store ��ü ���޹ޱ�
	//�޴��� ��� �� ��ǰ �����ϱ�
	
	//��ǰ�� �����ϴ� �޼ҵ�
	//��ǰ�� �������� �ʴ� �޼ҵ�
	void regist_sell(Store s) {
		String[] products = s.getMenu();
		System.out.println("========�޴�========");
		for (int i = 0; i < products.length; i++) {
			System.out.println(i+1+". "+products[i]);
		}
		s.sell("����");
	}
	
	void regist(StoreAdapter s) {
		String[] products = s.getMenu();
		System.out.println("========�޴�========");
		for (int i = 0; i < products.length; i++) {
			System.out.println(i+1+". "+products[i]);
		}
	}
}
