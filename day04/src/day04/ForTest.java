package day04;

public class ForTest {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i = i + 1) {
//			System.out.println(i+1+". ±èÈÖÁØ");
//			System.out.printf("%02d. ±èÈÖÁØ\n",i+1);
			System.out.printf("%02d. ±èÈÖÁØ\n",10 - i);
		}
	}
}
