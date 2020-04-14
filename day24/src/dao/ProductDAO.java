package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProductDAO {
	// 번호, 이름, 가격, 설명
	Connection conn = new Connection();
	public final String FILE_NAME = "products.txt";

	// 추가
	public void insert(int num, String name, int price, String description) throws IOException {
		BufferedWriter bw = null;
		if (!check_duplicate_num(num)) {
			bw = conn.connect_file_for_appending(FILE_NAME);
			bw.write(num + ",");
			bw.write(name + ",");
			bw.write(price + ",");
			bw.write(description + "\n");
			bw.close();
		}
	}

	// 중복검사
	private boolean check_duplicate_num(int num) {
		BufferedReader br = null;
		String line = "";
		try {
			br = conn.connect_file_for_reading(FILE_NAME);
			while (true) {
				line = br.readLine();
				if (line == null) {
					return false;
				}
				if (num == Integer.parseInt(line.split(",")[0])) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			;
		} catch (IOException e) {
			;
		}
		return false;

	}

	// 수정
	// 번호, 이름, 가격, 설명
	public int update(int idx, int num, String new_data) {
		int result = -1;
		try {
			BufferedReader br = conn.connect_file_for_reading(FILE_NAME);
			String line = null;
			String temp = "";
			String[] arTemp = null;
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				arTemp = line.split(",");
				if (Integer.parseInt(arTemp[0]) == num) {
					if (idx == 0) {
						if (check_duplicate_num(Integer.parseInt(new_data.split(",")[0]))) {
							arTemp[0] = new_data.split(",")[0];
							arTemp[1] = new_data.split(",")[1];
							result = 1;
						}else {
							result = 0;
						}
					} else {
						arTemp[++idx] = new_data;
					}
					for (int i = 0; i < arTemp.length; i++) {
						temp += arTemp[i];
						temp += i == arTemp.length - 1 ? "\n" : ",";
					}
					continue;
				}
				temp += line;
			}
			if(result ==1) {
				BufferedWriter bw = conn.connect_file_for_writing(FILE_NAME);
				bw.write(temp);
				bw.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 삭제
	// 검색
	// 목록
}
