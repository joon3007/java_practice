package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import vo.ProductDTO;

public class ProductDAO {
	// ��ȣ, �̸�, ����, ����
	Connection conn = new Connection();
	public final String FILE_NAME = "products.txt";

	// �߰�
	public void insert(int num, String name, int price, String description)  {
		BufferedWriter bw = null;
		if (!check_duplicate_num(num)) {
			try {
				bw = conn.connect_file_for_appending(FILE_NAME);
				bw.write(num + ",");
				bw.write(name + ",");
				bw.write(price + ",");
				bw.write(description + "\n");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// �ߺ��˻�
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

	// ����
	// ��ȣ, �̸�, ����, ����
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
				// ���ο� ��ǰ �ߺ��˻�
				if (Integer.parseInt(arTemp[0]) == num) {
					if (idx == 0) {
						if (check_duplicate_num(Integer.parseInt(new_data.split(",")[0]))) {
							// �ߺ��� ���� �� ����
							arTemp[0] = new_data.split(",")[0];
							arTemp[1] = new_data.split(",")[1];
							result = 1;
						} else {
							result = 0;
						}
					} else {
						arTemp[++idx] = new_data;
					}
					// �������� ���й��� �۾�
					temp += String.join(",", arTemp);
					temp += "\n";
//					for (int i = 0; i < arTemp.length; i++) {
//						//�������� ���й��� �۾�
//						temp += arTemp[i];
//						temp += i == arTemp.length - 1 ? "\n" : ",";
//					}
					continue;
				}
				temp += line;
			}
			// ���� ������ ���� ����
			if (result == 1) {
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

	// ����
	public boolean delete(int num) {
		BufferedReader br = null;
		String line = null;
		String temp = "";
		boolean result = false;
		try {
			br = conn.connect_file_for_reading(FILE_NAME);
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String[] arTemp = line.split(",");
				if (arTemp[0].equals(num + "")) {
					result = true;
					continue;
				}
				temp += line + "\n";
			}
			if (result == true) {
				BufferedWriter bw = conn.connect_file_for_writing(FILE_NAME);
				bw.write(temp);
				bw.close();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	// �˻�
	public ArrayList<ProductDTO> select(String keyword) {
		// ���޹��� keyword�� db���� �˻��Ѵ�.
		// �� �پ� contain()�� ����Ͽ� �˻����ش�.
		// �˻��� ���� �� �����͸� DTO��ü�� setter()�� �̿��ؼ� ����� ��
		// ArrayList<ProdoucDTO> ��ü�� add()�� �߰����ش�
		// while���� ��� ����� �� ArraryList��ü�� �������ش�.

		BufferedReader br = null;
		String line = null;
		ArrayList<ProductDTO> result = new ArrayList<>();

		try {
			br = conn.connect_file_for_reading(FILE_NAME);
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				if (line.contains(keyword) || keyword.equals("ALL")) {
					String[] arTemp = line.split(",");
					ProductDTO temp = new ProductDTO();
					temp.setNum(Integer.parseInt(arTemp[0]));
					temp.setName(arTemp[1]);
					temp.setPrice(Integer.parseInt(arTemp[2]));
					temp.setDescription(arTemp[3]);
					result.add(temp);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	// ���
	public ArrayList<ProductDTO> selectAll(){
		return select("ALL");
	}
	
	
}
