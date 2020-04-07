package day16;

public class Nike{
	//등록하는 메소드 선언
	//매개변수로 Store 객체 전달받기
	//메뉴판 출력 후 상품 구매하기
	
	//상품을 구매하는 메소드
	//상품을 구매하지 않는 메소드
	void regist_sell(Store s) {
		String[] products = s.getMenu();
		System.out.println("========메뉴========");
		for (int i = 0; i < products.length; i++) {
			System.out.println(i+1+". "+products[i]);
		}
		s.sell("조던");
	}
	
	void regist(StoreAdapter s) {
		String[] products = s.getMenu();
		System.out.println("========메뉴========");
		for (int i = 0; i < products.length; i++) {
			System.out.println(i+1+". "+products[i]);
		}
	}
}
