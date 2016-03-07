package RunTimeComplexity;

import java.util.Random;
import java.util.Set;

/**
 * A utility class that will return the runtime of
 * the set interface's common operations.
 */
public class SetTimeUtil {
    /**
     * Random object to retrieve random indexes and numbers.
     */
	private Random mRand;

    /**
     * A watch util class to retrieve the runtime in microseconds.
     */
	private Watch mWatch;

    /**
     * Construct a new set runtime util.
     */
	public SetTimeUtil() {
		mRand = new Random();
		mWatch = new Watch();
	}

    /**
     * Return the access time given a set object and the a size of n.
     * @param set the set object to compute with.
     * @param n the size of n or complexity to compute.
     * @return the access time of the given set object in microseconds.
     */
	public long searchTime(Set<Integer> set, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			set.contains(mRand.nextInt(n));
		}
		return mWatch.getTime();
	}

    /**
     * Return the insertion time given a set object and the a size of n.
     * @param set the set object to compute with.
     * @param n the size of n or complexity to compute.
     * @return the insertion time of the given set object in microseconds.
     */
	public long insertionTime(Set<Integer> set, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			set.add(mRand.nextInt(n));
		}
		return mWatch.getTime();
	}

    /**
     * Return the deletion time given a set object and the a size of n.
     * @param set the set object to compute with.
     * @param n the size of n or complexity to compute.
     * @return the deletion time of the given set object in microseconds.
     */
	public long deletionTime(Set<Integer> set, int n) {
		mWatch.start();
		for (int i = 0; i < n; i++) {
			set.remove(mRand.nextInt(n));
		}
		return mWatch.getTime();
	}
}
