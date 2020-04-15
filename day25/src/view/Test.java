package view;

import java.io.IOException;

import dao.ProductDAO;
import vo.ProductDTO;

public class Test {
	public static void main(String[] args) throws IOException {
		ProductDAO dao = new ProductDAO();
		dao.insert(999, "����", 1500, "�� �����ϴ�.");
		dao.insert(444, "���찳", 500, "�� �������ϴ�.");
		
		for(ProductDTO product : dao.selectAll()) {
			System.out.println(product);
		}
		
		System.out.println("-----------------------------------");
		System.out.println("999 ���� ");
		dao.delete(999);
		System.out.println("-----------------------------------");
		for(ProductDTO product : dao.selectAll()) {
			System.out.println(product);
		}
	}
}
