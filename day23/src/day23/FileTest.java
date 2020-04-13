package day23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
										// 해당 메소드에서 발생하는 예외를 발생시키지 않기 위해 사용한다.
	public static void main(String[] args) throws IOException {
		//1. 기존에 있는 내용에 추가하기 위해서는
		//   FileWriter 생성자 경로 뒤에 true를 작성해준다.
		//	 default는 false
		//2. 코드상에 작성한 문자열을 파일에 입력하기 위해서는
		//  write(문자열) 을 사용하고 반듯시 close()를 해준다.
//		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true));
//		
//		/*
//		 * JAVA는 운영체제의 종류에 맞게 자동으로 줄바꿈 문자를 변경해준다.
//		 * Windows에서 텍스트 파잉ㄹ의 줄바꿈은\r\n이다.
//		 * \n으로 작성을 해도 JVM이 \r\n으로 바꿔준다.
//		 */
//		bw.write("기쁨\n");
//		bw.write("슬픔\n");
//		bw.write("흥분\n");
//		bw.close();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			while(true) {
				String data = br.readLine();
				if(data == null) break;
				System.out.println(data);
			}
			br.close();
		} catch (FileNotFoundException e) {System.out.println("잘못된 파일입니다.");}finally {
//			br.close();
		}
		
		
		
	}
}
