package RunTimeComplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class TestRun {
	
	public static void main(String[] args) {
		int n = 10000;
		testDS(n);
		System.out.println();
		testSA(n);
	}
	
	private static void testSA(int n) {
		Random rand = new Random();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = rand.nextInt(n);
		}
		
		System.out.println("Bubble Sort");
		System.out.println("Runtime: " + SortRunTime.BubbleSort.sort(Arrays.copyOf(array, array.length)));

		
		System.out.println();
		
		System.out.println("Merge Sort");
		System.out.println("Runtime: " + SortRunTime.MergeSort.sort(Arrays.copyOf(array, array.length)));
		
		System.out.println();
		
		System.out.println("Insertion Sort");
		System.out.println("Runtime: " + SortRunTime.InsertionSort.sort(Arrays.copyOf(array, array.length)));
		
		System.out.println();
		
		System.out.println("Selection Sort");
		System.out.println("Runtime: " + SortRunTime.SelectionSort.sort(Arrays.copyOf(array, array.length)));
		
		System.out.println();
		
		System.out.println("QuickSort");
		System.out.println("Runtime: " + SortRunTime.QuickSort.sort(Arrays.copyOf(array, array.length)));
	}
	
	// access: arraylist, linkedlist, hashtable, 
	// search: arraylist, linkedlist, hashtable, treeset
	// insertion: arraylist, linkedlist, hashtable, treeset
	// deletion: arraylist, linkedlist, hashtable, treeset
	private static void testDS(int n) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
			arrayList.add(i);
			linkedList.add(i);
			hashSet.add(rand.nextInt(n));
			treeSet.add(rand.nextInt(n));
			hashMap.put(rand.nextInt(n), i);
			treeMap.put(rand.nextInt(n), i);
		}
		System.out.println("Time is in milliseconds \n");
		
		System.out.println("ArrayList: ");
		System.out.println("Access: " + ListRunTime.accessTime(arrayList, n));
		System.out.println("Search: " + ListRunTime.searchTime(arrayList, n));
		System.out.println("Insertion - Random: " + ListRunTime.randomInsertionTime(new ArrayList<Integer>(arrayList), n));
		System.out.println("Insertion - Sequential: " + ListRunTime.sequentialInsertionTime(new ArrayList<Integer>(arrayList), n));
		System.out.println("Deletion - Random: " + ListRunTime.randomDeletionTime(new ArrayList<Integer>(arrayList), n));
		System.out.println("Deletion - Sequential: " + ListRunTime.sequentialDeletionTime(new ArrayList<Integer>(arrayList), n));
		
		System.out.println();
		
		System.out.println("LinkedList: ");
		System.out.println("Access: " + ListRunTime.accessTime(linkedList, n));
		System.out.println("Search: " + ListRunTime.searchTime(linkedList, n));
		System.out.println("Insertion - Random: " + ListRunTime.randomInsertionTime(new LinkedList<Integer>(linkedList), n));
		System.out.println("Insertion - Sequential: " + ListRunTime.sequentialInsertionTime(new LinkedList<Integer>(linkedList), n));
		System.out.println("Deletion - Random: " + ListRunTime.randomDeletionTime(new LinkedList<Integer>(linkedList), n));
		System.out.println("Deletion - Sequential: " + ListRunTime.sequentialDeletionTime(new LinkedList<Integer>(linkedList), n));
		
		System.out.println();
		
		System.out.println("HashMap: ");
		System.out.println("Access: " + MapRunTime.accessTime(hashMap, n));
		System.out.println("Search: " + MapRunTime.searchTime(hashMap, n));
		System.out.println("Insertion: " + MapRunTime.insertionTime(hashMap, n));
		System.out.println("Deletion: " + MapRunTime.deletionTime(hashMap, n));
		
		System.out.println();
		
		System.out.println("TreeMap: ");
		System.out.println("Access: " + MapRunTime.accessTime(treeMap, n));
		System.out.println("Search: " + MapRunTime.searchTime(treeMap, n));
		System.out.println("Insertion: " + MapRunTime.insertionTime(treeMap, n));
		System.out.println("Deletion: " + MapRunTime.deletionTime(treeMap, n));
	
		System.out.println();
		
		System.out.println("HashSet: ");
		System.out.println("Search: " + SetRunTime.searchTime(hashSet, n));
		System.out.println("Insertion: " + SetRunTime.insertionTime(hashSet, n));
		System.out.println("Deletion: " + SetRunTime.deletionTime(hashSet, n));
		
		System.out.println();
		
		System.out.println("TreeSet: ");
		System.out.println("Search: " + SetRunTime.searchTime(treeSet, n));
		System.out.println("Insertion: " + SetRunTime.insertionTime(treeSet, n));
		System.out.println("Deletion: " + SetRunTime.deletionTime(treeSet, n));
	}
}
