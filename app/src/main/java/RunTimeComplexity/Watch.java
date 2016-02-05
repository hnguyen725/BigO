package RunTimeComplexity;

import java.util.concurrent.TimeUnit;

public class Watch {
	private static long startTime;
	
	public static void start() {
		startTime = System.nanoTime();
	}
	
	public static float getTime() {
//		return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
		return (float) (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
	}
}
