package day02;

public class Casting {
	
	public static void main(String[] args) {
		System.out.println(11/9);
		System.out.println(11.0/9);
		
		//강제 형변환
		System.out.println(11/(double)9);
		System.err.println((int)8.43+2.59);
		System.err.println((int)(8.43+2.59));
		System.err.println((int)8.43+(int)2.59);
		
		
	}
}
