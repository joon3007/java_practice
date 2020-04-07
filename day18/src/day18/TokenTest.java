package day18;

import java.util.StringTokenizer;

public class TokenTest {
	public static void main(String[] args) {
		String str = "�ȳ��ϼ���,. �������Դϴ�!";
		
		String[] arData = str.split(".");
		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
		
		StringTokenizer token = new StringTokenizer(str,". ,!");
		while(token.hasMoreElements()) {
			System.out.println(token.nextToken());
		}
	}
}
