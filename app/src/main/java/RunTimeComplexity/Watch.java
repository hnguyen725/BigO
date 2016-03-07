package RunTimeComplexity;

import java.util.concurrent.TimeUnit;

/**
 * A watch utility class to calculate the runtime
 * of complexity operations and return those them
 * in microseconds.
 */
public class Watch {
	/**
	 * The current start time.
	 */
	private long mStartTime;

	/**
	 * Start the watch and set the current start time.
	 */
	public void start() {
		mStartTime = System.nanoTime();
	}

	/**
	 * Return the overall time from the previous start time in microseconds.
	 * @return the overall time in microseconds.
	 */
	public long getTime() {
		return (TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - mStartTime));
	}
}
