package RunTimeComplexity;

import java.util.List;
import java.util.Random;


public class ListRunTime {
	private static final Random RAND = new Random();
	
	public static float accessTime(List<Integer> list, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			list.get(RAND.nextInt(n));
		}
		return Watch.getTime();
	}
	
	public static float searchTime(List<Integer> list, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			list.contains(RAND.nextInt(n));
		}
		return Watch.getTime();
	}
	
	public static float randomInsertionTime(List<Integer> list, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			list.add(RAND.nextInt(n), i);
		}
		return Watch.getTime();
	}
	
	public static float sequentialInsertionTime(List<Integer> list, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		return Watch.getTime();
	}
	
	public static float randomDeletionTime(List<Integer> list, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			list.remove(RAND.nextInt(n - i));
		}
		return Watch.getTime();
	}
	
	public static float sequentialDeletionTime(List<Integer> list, int n) {
		Watch.start();
		for (int i = n - 1; i >= 0; i--) {
			list.remove(i);
		}
		return Watch.getTime();
	}

	
}
