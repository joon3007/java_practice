package di;

public class Cook {
	private Knife knife;

	public Cook() {
	}
	// ������ ����
	// 1.�����ڸ� ���� ���޹���
	// ������
//	public Cook(Knife knife) {
//		this.knife = knife;
//	}
	// 2. setter�� ���� ���� ����
	public void setKnife(Knife knife) {
		this.knife = knife;
	}

	public void cook(Food food) {
		knife.cut(food);
	}

}
