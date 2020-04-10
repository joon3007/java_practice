package bakery;

import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BakeryPlate bread = new BakeryPlate();
		BreadMaker maker = new BreadMaker(bread);
		
		Thread t = new Thread(maker);
		
		Object[] menu = null;
		int choice = 0 ;
		
		t.start();
		
		while(true) {
			choice = JOptionPane.showOptionDialog(null, "","파리바게트" ,JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE
					, null, menu, null);
			
			if(choice == -1) {
				break;
			}else {
				bread.eatBread();
			}
		}
	}
}
