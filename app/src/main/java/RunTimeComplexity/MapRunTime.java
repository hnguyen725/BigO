package RunTimeComplexity;

import java.util.Map;
import java.util.Random;

public class MapRunTime {
	private static final Random RAND = new Random();
	
	public static long accessTime(Map<Integer, Integer> map, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			map.get(RAND.nextInt(n));
		}
		return Watch.getTime();
	}
	
	public static long searchTime(Map<Integer, Integer> table, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			table.containsKey(RAND.nextInt(n));
		}
		return Watch.getTime();
	}
	
	public static long insertionTime(Map<Integer, Integer> table, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			table.put(RAND.nextInt(n), i);
		}
		return Watch.getTime();
	}
	
	public static long deletionTime(Map<Integer, Integer> table, int n) {
		Watch.start();
		for (int i = 0; i < n; i++) {
			table.remove(RAND.nextInt(n - i));
		}
		return Watch.getTime();
	}
	
}
