package day13;

class Food {

	String name;
	int price;

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	void cook(String how) {
		System.out.println(how);
	}

}

public class ObjArTest {
	public static void main(String[] args) {
//		Food ham = new Food("«‹",3000);
//		Food egg = new Food("¥ﬁ∞ø",500);
		Food[] foods = { new Food("«‹", 3000), new Food("∞Ë∂ı", 500), new Food("ªß", 1500) };
		String[] hows = { "»ƒ∂Û¿Ã∆“ø° ≥÷∞Ì ∫∫±‚", "¿ª ≥ø∫Òø° ≥÷∞Ì ∫∏±€∫∏±€", "¿ª ≈‰Ω∫∆Æ±‚ø° ≥÷±‚" };
		for (int i = 0; i < foods.length; i++) {
			System.out.println(foods[i].name + hows[i]);
		}

	}
}
