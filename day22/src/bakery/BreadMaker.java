package bakery;

public class BreadMaker implements Runnable{

	BakeryPlate bread;
	
	public BreadMaker(BakeryPlate bread) {
		super();
		this.bread = bread;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				bread.makeBread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("영업 종료");
	}

}
