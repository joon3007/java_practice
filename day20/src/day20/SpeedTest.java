package day20;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SpeedTest {
	public static void main(String[] args) {
		final int SIZE = 10_000_000;
		final int DATA = 9_000_000;
		
		final List<Integer> arrList = new ArrayList<>();
		final Set<Integer> hashSet = new HashSet<>();
		
		//���� ���� ���� ����
		IntStream.range(0, SIZE).forEach(value ->{
			arrList.add(value);
			hashSet.add(value);
		});
		
		Instant start = Instant.now();
		arrList.contains(DATA);
		Instant end = Instant.now();
		long elapsedTime = Duration.between(start, end).toMillis();
		System.out.println("array list �˻� �ð� : " + elapsedTime * 0.001 + "��");
		
		start = Instant.now();
		hashSet.contains(DATA);
		end = Instant.now();
		elapsedTime = Duration.between(start, end).toMillis();
		System.out.println("hash set �˻� �ð� : " + elapsedTime * 0.001 + "��");
		
	}
}






