package day16;

//대중교통
class Transportaion {
}

class Bus extends Transportaion {
}

public class InstanceTest {
	public static void main(String[] args) {
//		System.out.println(new Integer(10) instanceof Integer);
//		System.out.println("안녕" instanceof String);
//		System.out.println(new Float(3.156F) instanceof Float);
//		
//		Object[] a = {1,"안녕",3.14};
		
		Transportaion t = new Transportaion();
		Bus b = new Bus();
		
		Transportaion upcasting = new Bus();
		Bus downcasting = (Bus) upcasting;
		
		//upcasting된 객체를 downcasting하는 이유
		//upcasting되면서 자식 클래스에 새롭게 추가된 필드는 모두 잘려서 들어간다.
		// 따라서 자식 필드에서 새로 추가된 기능을 모두 사용하고싶다면
		//downcasting을 해야한다.
		//instanceof를 사용해야 하는 이유
		//upcasting된 객체에 어떤 자식값이 들어가 있는 지를 검사할 필요가 있다.
		//들어가 있는 자식 타입에 맞게 downcasting을 하기 위해 사용한다.
		
		
	}
}
