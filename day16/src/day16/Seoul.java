package day16;

public class Seoul {
	public static void main(String[] args) {
		// 강남점은 판패하지만
		// 신촌점은 판매하지 않는다.(sell을 구현하지 않는다)
		Nike gangnam = new Nike();
		Nike shinchon = new Nike();

		gangnam.regist_sell(new Store() {
			@Override
			public void sell(String product) {
				String[] products = getMenu();
				for (int i = 0; i < products.length; i++) {
					if (product.equals(products[i])) {
						System.out.println(product + " 주문성공");
					}
				}
			}
	

			@Override
			public String[] getMenu() {
				String[] products = { "에어", "조던" };
				return products;
			}
		});

		shinchon.regist(new StoreAdapter() {
			@Override
			public String[] getMenu() {
				String[] products = { "에어", "조던" };
				return products;
			}
		});
	}
}
