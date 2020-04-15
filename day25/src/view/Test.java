package view;

import java.io.IOException;

import dao.ProductDAO;
import vo.ProductDTO;

public class Test {
	public static void main(String[] args) throws IOException {
		ProductDAO dao = new ProductDAO();
		dao.insert(999, "연필", 1500, "잘 써집니다.");
		dao.insert(444, "지우개", 500, "잘 지워집니다.");
		
		for(ProductDTO product : dao.selectAll()) {
			System.out.println(product);
		}
		
		System.out.println("-----------------------------------");
		System.out.println("999 삭제 ");
		dao.delete(999);
		System.out.println("-----------------------------------");
		for(ProductDTO product : dao.selectAll()) {
			System.out.println(product);
		}
	}
}
