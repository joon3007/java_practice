package day07;

public class ArrTest {
	public static void main(String[] args) {
		int[][] arrData = new int[2][3];
		int length = arrData.length * arrData[0].length;
		for (int i = 0; i < length; i++) {
			arrData[i / arrData[0].length][i % arrData[0].length] = i + 1;
		}
		for (int i = 0; i < arrData.length; i++) {
			for (int j = 0; j < arrData[0].length; j++) {
				System.out.println(arrData[i][j]);
			}
		}
		
		
	}
}
