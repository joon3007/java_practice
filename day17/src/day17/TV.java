package day17;

public class TV {
	// 애니메이션인지 아닌지 검사하는 메소드 선언
	// 000은 애니메이션입니다.
	// 000은 애니메이션입니다
	void checkAni(Video v) {
		String msg = v.toString() + "은 ";
		if (v instanceof AnimationMarker) {
			msg += "애니메이션 입니다.";
		} else {
			msg += "애니메이션이 아닙니다.";
		}
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Video[] v = { new Digimon("디지몬"), new Frozen("겨울왕국"), new Avengers("어벤져스"), new Ddolbi("똘비") };
		TV tv = new TV();
		for (int i = 0; i < v.length; i++) {
			tv.checkAni(v[i]);
		}
	}

}
