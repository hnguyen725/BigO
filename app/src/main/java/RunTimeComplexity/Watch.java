package RunTimeComplexity;

import java.util.concurrent.TimeUnit;

public class Watch {
	private static long startTime;
	
	public static void start() {
		startTime = System.nanoTime();
	}
	
	public static long getTime() {
//		return (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
		return (TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime));
//		return System.nanoTime() - startTime;
	}
}
