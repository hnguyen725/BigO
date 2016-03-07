package RunTimeComplexity;

import java.util.Map;
import java.util.Random;

/**
 * A utility class that will return the runtime of
 * the map interface's common operations.
 */
public class MapTimeUtil {
	/**
	 * Random object to retrieve random indexes and numbers.
	 */
	private Random mRand;

	/**
	 * A watch util class to retrieve the runtime in microseconds.
	 */
	private Watch mWatch;

	/**
	 * Construct a new map runtime util.
	 */
	public MapTimeUtil() {
		mRand = new Random();
		mWatch = new Watch();
	}

    /**
     * Return the access time given a map object and the a size of n.
     * @param map the map object to compute with.
     * @param n the size of n or complexity to compute.
     * @return the access time of the given map object in microseconds.
     */
	public long accessTime(Map<Integer, Integer> map, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			map.get(mRand.nextInt(n));
		}
		return mWatch.getTime();
	}

    /**
     * Return the search time given a map object and the a size of n.
     * @param map the map object to compute with.
     * @param n the size of n or complexity to compute.
     * @return the search time of the given map object in microseconds.
     */
	public long searchTime(Map<Integer, Integer> map, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
            map.containsKey(mRand.nextInt(n));
		}
		return mWatch.getTime();
	}

    /**
     * Return the insertion time given a map object and the a size of n.
     * @param map the map object to compute with.
     * @param n the size of n or complexity to compute.
     * @return the insertion time of the given map object in microseconds.
     */
	public long insertionTime(Map<Integer, Integer> map, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
            map.put(mRand.nextInt(n), i);
		}
		return mWatch.getTime();
	}

    /**
     * Return the deletion time given a map object and the a size of n.
     * @param map the map object to compute with.
     * @param n the size of n or complexity to compute.
     * @return the deletion time of the given map object in microseconds.
     */
	public long deletionTime(Map<Integer, Integer> map, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
            map.remove(mRand.nextInt(n - i));
		}
		return mWatch.getTime();
	}
	
}
