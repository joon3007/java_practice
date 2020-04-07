package day16;

public class Seoul {
	public static void main(String[] args) {
		// �������� ����������
		// �������� �Ǹ����� �ʴ´�.(sell�� �������� �ʴ´�)
		Nike gangnam = new Nike();
		Nike shinchon = new Nike();

		gangnam.regist_sell(new Store() {
			@Override
			public void sell(String product) {
				String[] products = getMenu();
				for (int i = 0; i < products.length; i++) {
					if (product.equals(products[i])) {
						System.out.println(product + " �ֹ�����");
					}
				}
			}
	

			@Override
			public String[] getMenu() {
				String[] products = { "����", "����" };
				return products;
			}
		});

		shinchon.regist(new StoreAdapter() {
			@Override
			public String[] getMenu() {
				String[] products = { "����", "����" };
				return products;
			}
		});
	}
}
