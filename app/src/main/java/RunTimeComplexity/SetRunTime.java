package RunTimeComplexity;

import java.util.Random;
import java.util.Set;

public class SetRunTime {
	private static final Random RAND = new Random();
	
	public static long searchTime(Set<Integer> set, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			set.contains(RAND.nextInt(n));
		}
		return Watch.getTime();
	}
	
	public static long insertionTime(Set<Integer> set, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			set.add(RAND.nextInt(n));
		}
		return Watch.getTime();
	}
	
	public static long deletionTime(Set<Integer> set, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			set.remove(RAND.nextInt(n));
		}
		return Watch.getTime();
	}
}
