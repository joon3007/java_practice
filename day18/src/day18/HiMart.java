package day18;

public class HiMart {
	public static void main(String[] args) {
		FactoryElectronics factory = new FactoryElectronics();
		Electronics oled = factory.getElectronics("tv");
		Electronics bespoke = factory.getElectronics("refrigerator");
		Electronics dyson = factory.getElectronics("vacuum");
		
		oled.on();
		bespoke.on();
		dyson.on();
		
	}
}
