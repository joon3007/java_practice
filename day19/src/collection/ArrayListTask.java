package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTask {
	public static void main(String[] args) {
		//상품명, 가격을 관리해주는 ArrayList 선언(2차원)
		ArrayList<ArrayList> products = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		//1. 상품등록
		ArrayList product = new ArrayList<>();
		System.out.print("상품명 : ");
		product.add(sc.next());
		System.out.print("가격 : ");
		product.add(sc.nextInt());
		products.add(product);
		for(ArrayList prod : products) {
			System.out.println(prod);
		}
		//2. 상품수정
		//3. 상품 검색
		//4. 상품 삭제
		//5.상품 목록
		//6. 나가기
	}
}
