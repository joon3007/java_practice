package day23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTest2 {
	public static void main(String[] args) throws IOException {
		String fileName = "animals.txt";
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		// 동물이름
//		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
//		//추가
//		System.out.println("추가하실 동물이름 : ");
//		bw.write(sc.next()+ "\n");
//		bw.close();
		// 수정
		
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.println("수정하실 동물이름 : ");
//		String name = sc.next();
//		String temp = "";
//		while (true) {
//			String data = br.readLine();
//			if (data == null) {
//				break;
//			} else if (data.equals(name)) {
//				check = true;
//				System.out.println("변경하실 동물이름");
//				temp += sc.next() + "\n";
//			} else {
//				temp += data;
//			}
//		}
//		if (check) {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//			bw.write(temp);
//			bw.close();
//		}else {
//			System.out.println("수정하실 동물이 없습니다.");
//		}
//		// 삭제
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.println("삭제하실 동물이름 : ");
//		name = sc.next();
//		temp = "";
//		while (true) {
//			String data = br.readLine();
//			if (data == null) {
//				break;
//			} else if (data.equals(name)) {
//				check = true;
//				System.out.println("삭제하실 동물이름");
//			} else {
//				temp += data;
//			}
//		}
//		if (check) {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//			bw.write(temp);
//			bw.close();
//		}else {
//			System.out.println("삭제하실 동물이 없습니다.");
//		}
		// 검색
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		ArrayList<String> resultList = new ArrayList<>();
//		System.out.println("검색하실 동물이름 : ");
//		String name = sc.next();
//		String line = null;
//		while(true) {
//			line = br.readLine();
//			
//			if(line == null) {break;}
//			
//			if(line.contains(name)) {
//				resultList.add(line);
//			}
//		}
//		if(resultList.size() == 0) {
//			System.out.println("검색결과없음");
//		}else {
//			System.out.println("검색결과");
//			for(String data : resultList) {
//				System.out.println(data);
//			}
//		}
		// 목록
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		while(true) {
			line = br.readLine();
			if(line == null) {break;}
			
			System.out.println(line);
		}
		br.close();
	}
}
