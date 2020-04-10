package bakery;

public class BakeryPlate {
	int breadCnt;
	int eatCnt;
	
	synchronized public void makeBread() throws InterruptedException {
		if(breadCnt > 9) {
			System.out.println("빵이 가듣 찼습니다. 먹으세요.");
			wait();
		}
		breadCnt++;
		System.out.println("빵을 1개 만들었습니다. 총"+breadCnt+"개");
	}
	
	synchronized public void eatBread() {
		if(eatCnt ==20) {
			System.out.println("빵이 다 떨어졌습니다.");
		}else if(breadCnt < 1) {
			System.out.println("기다리세요.");
		}else {
			breadCnt--;
			eatCnt++;
			System.out.println("빵을 1개 먹었습니다. 총"+breadCnt+"개");
			this.notify();
		}
	}
}
