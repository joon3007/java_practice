package vo;

public class ProductDTO {
	
	private int num;
	private String name;
	private int price;
	private String description;
	
	public ProductDTO() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "��ȣ : "+this.num+" �̸� : "+this.name+" ���� : "+this.price+" ���� : "+this.description;
	}
}
