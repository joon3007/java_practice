package inter;

public class Private implements Soldier {

	@Override
	public void eat() {
		System.out.println("허리를 곧게 펴고 식사를 한다.");
	}

	@Override
	public void sleep() {
		System.out.println("고향 생각에 어디간다.");
	}

	@Override
	public void work() {
		System.out.println("열심히 하지만 결과가 없기 때문에 어디간다.");
	}

	@Override
	public void salute() {
		System.out.println("충!!!!!!!!!!!!!!!!!!!!!성!!!!!!!!!!!!!!!!!!!");
	}

}
