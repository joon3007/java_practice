package day17;

public class TV {
	// �ִϸ��̼����� �ƴ��� �˻��ϴ� �޼ҵ� ����
	// 000�� �ִϸ��̼��Դϴ�.
	// 000�� �ִϸ��̼��Դϴ�
	void checkAni(Video v) {
		String msg = v.toString() + "�� ";
		if (v instanceof AnimationMarker) {
			msg += "�ִϸ��̼� �Դϴ�.";
		} else {
			msg += "�ִϸ��̼��� �ƴմϴ�.";
		}
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Video[] v = { new Digimon("������"), new Frozen("�ܿ�ձ�"), new Avengers("�����"), new Ddolbi("�ʺ�") };
		TV tv = new TV();
		for (int i = 0; i < v.length; i++) {
			tv.checkAni(v[i]);
		}
	}

}
