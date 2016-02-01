package RunTimeComplexity;

import java.util.Arrays;


public class SortRunTime {

	public static class BubbleSort {
		public static long sort(int[] array) {
			Watch.start();
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
			return Watch.getTime();
		}
	}


	public static class MergeSort {
		public static long sort(int[] array) {
			Watch.start();
			mergeSort(array);
			return Watch.getTime();
		}

		private static int[] mergeSort(int [] array) {
			// base case
			if (array.length <= 1) {
				return array;
			}

			// Split the array in half
			int[] first = new int[array.length / 2];
			int[] second = new int[array.length - first.length];
			System.arraycopy(array, 0, first, 0, first.length);
			System.arraycopy(array, first.length, second, 0, second.length);

			// Sort each half
			mergeSort(first);
			mergeSort(second);

			// Merge the halves together, overwriting the original array
			merge(first, second, array);
			return array;
		}

		private static void merge(int[] first, int[] second, int [] result) {
			// Merge both halves into the result array
			// Next element to consider in the first array
			int iFirst = 0;
			// Next element to consider in the second array
			int iSecond = 0;

			// Next open position in the result
			int j = 0;
			// As long as neither iFirst nor iSecond is past the end, move the
			// smaller element into the result.
			while (iFirst < first.length && iSecond < second.length) {
				if (first[iFirst] < second[iSecond]) {
					result[j] = first[iFirst];
					iFirst++;
				} else {
					result[j] = second[iSecond];
					iSecond++;
				}
				j++;
			}
			// copy what's left
			System.arraycopy(first, iFirst, result, j, first.length - iFirst);
			System.arraycopy(second, iSecond, result, j, second.length - iSecond);
		}
	}

	public static class QuickSort {
		public static long sort(int[] array) {
			Watch.start();
			Arrays.sort(array);
			return Watch.getTime();
		}
	}

	public static class InsertionSort {
		public static long sort(int[] array) {
			Watch.start();
			for (int i = 1; i < array.length; i++) {
				int currentVal = array[i];
				int j;
				for (j = i; j > 0 && array[j - 1] > currentVal; j--) {
					array[j] = array[j - 1];
				}
				array[j] = currentVal;
			}
			return Watch.getTime();
		}
	}

	public static class SelectionSort {
		public static long sort(int[] array) {
			Watch.start();
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
			return Watch.getTime();
		}
	}

}
