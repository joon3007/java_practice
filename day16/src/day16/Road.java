package day16;

public class Road {
	public static void main(String[] args) {
		StarBucks gangnam = new StarBucks();

		gangnam.regist(new Cafe() {

			@Override
			public String[] getMenu() {
				String[] menus = { "아메리카노", "카페라떼" };
				return menus;
			}

			@Override
			public void sell(String menu) {
				String[] menus = getMenu();
				for (int i = 0; i < menus.length; i++) {
					if (menu.equals(menus[i])) {
						System.out.println(menu + " 주문성공");
					}
				}
			}

		});
	}
}
