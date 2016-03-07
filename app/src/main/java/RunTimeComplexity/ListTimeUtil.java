package RunTimeComplexity;

import java.util.List;
import java.util.Random;

/**
 * A utility class that will return the runtime of
 * the list interface's common operations.
 */
public class ListTimeUtil {
    /**
     * Random object to retrieve random indexes and numbers.
     */
	private Random mRand;

    /**
     * A watch util class to retrieve the runtime in microseconds.
     */
	private Watch mWatch;

	/**
	 * Construct a new list runtime util.
	 */
	public ListTimeUtil() {
		mRand = new Random();
		mWatch = new Watch();
	}

	/**
	 * Return the access time given a list object and a size of n.
	 * @param list the object to compute runtime.
	 * @param n the size of n to compute the complexity.
	 * @return the runtime of access in microseconds.
	 */
	public long accessTime(List<Integer> list, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			list.get(mRand.nextInt(n));
		}
		return mWatch.getTime();
	}

	/**
	 * Return the search time given a list object and a size of n.
	 * @param list the object to compute runtime.
	 * @param n the size of n to compute the complexity.
	 * @return the runtime of search in microseconds.
	 */
	public long searchTime(List<Integer> list, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			list.contains(mRand.nextInt(n));
		}
		return mWatch.getTime();
	}

    /**
     * Return the insertion time in random index given a list object and a size of n.
     * @param list the object to compute runtime.
     * @param n the size of n to compute the complexity.
     * @return the runtime of random index insertion in microseconds.
     */
	public long randomInsertionTime(List<Integer> list, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			list.add(mRand.nextInt(n), i);
		}
		return mWatch.getTime();
	}

    /**
     * Return the sequential insertion time given a list object and a size of n.
     * @param list the object to compute runtime.
     * @param n the size of n to compute the complexity.
     * @return the runtime of sequential insertion in microseconds.
     */
	public long sequentialInsertionTime(List<Integer> list, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		return mWatch.getTime();
	}

    /**
     * Return the random deletion time given a list object and a size of n.
     * @param list the object to compute runtime.
     * @param n the size of n to compute the complexity.
     * @return the runtime of random deletion in microseconds.
     */
	public long randomDeletionTime(List<Integer> list, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			list.remove(mRand.nextInt(n - i));
		}
		return mWatch.getTime();
	}

    /**
     * Return the sequential deletion time given a list object and a size of n.
     * @param list the object to compute runtime.
     * @param n the size of n to compute the complexity.
     * @return the runtime of sequential deletion in microseconds.
     */
	public long sequentialDeletionTime(List<Integer> list, int n) {
		mWatch.start();
		for (int i = n - 1; i >= 0; i--) {
			list.remove(i);
		}
		return mWatch.getTime();
	}

	
}
