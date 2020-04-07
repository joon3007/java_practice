package day19;

public class ForEachTest {
	public static void main(String[] args) {
		//up casting
		//auto boxing
		Object[] arObj = {"ABC", 'a', 10, 10.987};
		Object[][] arrObj = {{"ABC",10},{3.41415,3.587F},{'a',"ÄÄÇ»ÅÍ"}};
		
		
		for (int i = 0; i < arObj.length; i++) {
			System.out.println(arObj[i]);
		}
		//foreach
		for(Object obj:arObj) {
			System.out.println(obj);
		}
		
		for(Object[] obj:arrObj) {
			for(Object obj2:obj) {
				System.out.println(obj2);
			}
		}
	}
}
