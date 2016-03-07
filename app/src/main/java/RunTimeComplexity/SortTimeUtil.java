package RunTimeComplexity;

import java.util.Arrays;

/**
 * A utility class that will return the runtime of
 * common sort algorithms.
 */
public class SortTimeUtil {
    /**
     * A watch util class to retrieve the runtime in microseconds.
     */
    private Watch mWatch;

    /**
     * Construct a new sort runtime util.
     */
    public SortTimeUtil() {
        mWatch = new Watch();
    }

    /**
     * Return the runtime to sort the array using bubble sort.
     * @param array the array to be sorted.
     * @return the sorting runtime in microseconds.
     */
    public long bubbleSortTime(int[] array) {
        mWatch.start();
        boolean swapped = true;
        int temp;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return mWatch.getTime();
    }

    /**
     * Return the runtime to sort the array using mergesort.
     * @param array the array to be sorted.
     * @return the sorting runtime in microseconds.
     */
    public long mergeSortTime(int[] array) {
        mWatch.start();
        mergeSort(array);
        return mWatch.getTime();
    }

    /**
     * Main merge sort method to split and merge the arrays for
     * sorting.
     * @param array the array to be sorted.
     * @return the sorted array.
     */
    private int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        // Split the array in half
        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, array);
        return array;
    }

    /**
     * Merge the two given arrays.
     * @param first the first array.
     * @param second the second array.
     * @param result the merged array from first and second.
     */
    private void merge(int[] first, int[] second, int[] result) {
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int j = 0;

        while (firstArrayIndex < first.length && secondArrayIndex < second.length) {
            if (first[firstArrayIndex] < second[secondArrayIndex]) {
                result[j] = first[firstArrayIndex];
                firstArrayIndex++;
            } else {
                result[j] = second[secondArrayIndex];
                secondArrayIndex++;
            }
            j++;
        }
        System.arraycopy(first, firstArrayIndex, result, j, first.length - firstArrayIndex);
        System.arraycopy(second, secondArrayIndex, result, j, second.length - secondArrayIndex);
    }

    /**
     * Return the runtime to sort the array using quicksort, using
     * the built-in java quicksort for arrays.
     * @param array the array to be sorted.
     * @return the sorting runtime in microseconds.
     */
    public long quickSortTime(int[] array) {
        mWatch.start();
        Arrays.sort(array);
        return mWatch.getTime();
    }

    /**
     * Return the runtime to sort the array using insertion sort.
     * @param array the array to be sorted.
     * @return the sorting runtime in microseconds.
     */
    public long insertionSortTime(int[] array) {
        mWatch.start();
        for (int i = 1; i < array.length; i++) {
            int currentVal = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] > currentVal; j--) {
                array[j] = array[j - 1];
            }
            array[j] = currentVal;
        }
        return mWatch.getTime();
    }

    /**
     * Return the runtime to sort the array using selection sort.
     * @param array the array to be sorted.
     * @return the sorting runtime in microseconds.
     */
    public long selectionSortTime(int[] array) {
        mWatch.start();
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            int minValIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= array[minValIndex]) {
                    minValIndex = j;
                }
            }
            temp = array[minValIndex];
            array[minValIndex] = array[i];
            array[i] = temp;
        }
        return mWatch.getTime();
    }

}
