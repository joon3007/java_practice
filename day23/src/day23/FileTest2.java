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
		// �����̸�
//		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
//		//�߰�
//		System.out.println("�߰��Ͻ� �����̸� : ");
//		bw.write(sc.next()+ "\n");
//		bw.close();
		// ����
		
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.println("�����Ͻ� �����̸� : ");
//		String name = sc.next();
//		String temp = "";
//		while (true) {
//			String data = br.readLine();
//			if (data == null) {
//				break;
//			} else if (data.equals(name)) {
//				check = true;
//				System.out.println("�����Ͻ� �����̸�");
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
//			System.out.println("�����Ͻ� ������ �����ϴ�.");
//		}
//		// ����
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.println("�����Ͻ� �����̸� : ");
//		name = sc.next();
//		temp = "";
//		while (true) {
//			String data = br.readLine();
//			if (data == null) {
//				break;
//			} else if (data.equals(name)) {
//				check = true;
//				System.out.println("�����Ͻ� �����̸�");
//			} else {
//				temp += data;
//			}
//		}
//		if (check) {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//			bw.write(temp);
//			bw.close();
//		}else {
//			System.out.println("�����Ͻ� ������ �����ϴ�.");
//		}
		// �˻�
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		ArrayList<String> resultList = new ArrayList<>();
//		System.out.println("�˻��Ͻ� �����̸� : ");
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
//			System.out.println("�˻��������");
//		}else {
//			System.out.println("�˻����");
//			for(String data : resultList) {
//				System.out.println(data);
//			}
//		}
		// ���
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
