package day16;

public class Road {
	public static void main(String[] args) {
		StarBucks gangnam = new StarBucks();

		gangnam.regist(new Cafe() {

			@Override
			public String[] getMenu() {
				String[] menus = { "�Ƹ޸�ī��", "ī���" };
				return menus;
			}

			@Override
			public void sell(String menu) {
				String[] menus = getMenu();
				for (int i = 0; i < menus.length; i++) {
					if (menu.equals(menus[i])) {
						System.out.println(menu + " �ֹ�����");
					}
				}
			}

		});
	}
}
