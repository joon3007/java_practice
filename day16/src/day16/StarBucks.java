package day16;

public class StarBucks {
	void regist(Cafe c) {
		String[] menu = c.getMenu();
		System.out.println("========�޴�========");
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i+1+". "+menu[i]);
		}
		c.sell("�Ƹ޸�ī��");
	}
}
