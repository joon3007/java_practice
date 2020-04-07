package day18;

public class TV implements Electronics{

	@Override
	public void on() {
		System.out.println("리모컨으로 켬.");
	}

	@Override
	public void off() {
		System.out.println("리모컨으로 끔.");		
	}
	
}
