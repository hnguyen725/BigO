package model;

import android.app.Application;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hieunguyen725 on 12/24/2015.
 */
public class ApplicationData extends Application {
    /**
     * Information about data structures complexity
     * index values are in the following order:
     * 0 - name, 1 - average access time complexity, 2 - average search complexity,
     * 3 - average insertion, 4 - average deletion, 5 - worst case access, 6 - worst case search,
     * 7 - worst case insertion, 8 - worst case deletion, and 9 - worst case space complexity.
     */
    private final String DS_DATA[][] = {
            {"Array", "1", "n", "n", "n", "1", "n", "n", "n", "n"},
            {"Stack", "n", "n", "1", "1", "n", "n", "1", "1", "n"},
            {"Queue", "n", "n", "1", "1", "n", "n", "1", "1", "n"},
            {"Singly-Linked List", "n", "n", "-", "-", "n", "n", "n", "n", "n"},
            {"Doubly-Linked List", "n", "n", "-", "-", "n", "n", "n", "n", "n"},
            {"Skip List", "log(n)", "log(n)", "log(n)", "log(n)", "n", "n", "n", "n", "n log(n)"},
            {"Hash Table", "-", "1", "1", "1", "-", "n", "n", "n", "n"},
            {"Binary Search Tree", "log(n)", "log(n)", "log(n)", "log(n)", "n", "n", "n", "n", "n"},
            {"Cartesian Tree", "-", "log(n)", "log(n)", "log(n)", "-", "n", "n", "n", "n"},
            {"B-Tree", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "n"},
            {"Red-Black Tree", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "n"},
            {"Splay Tree", "-", "log(n)", "log(n)", "log(n)", "-", "log(n)", "log(n)", "log(n)", "n"},
            {"AVL Tree", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "n"},
    };

    /**
     * Information about sorting algorithms complexity
     * index values are in the following order
     * 0 - algorithm name, 1 - best case time complexity, 2 - average case, 3 - worst case,
     * and 4 - worst case space complexity
     */
    private final String SA_DATA[][] = {
            {"Quicksort", "n log(n)", "n log(n)", "n<sup>2</sup>", "log(n)"},
            {"Mergesort", "n log(n)", "n log(n)", "n log(n)", "n"},
            {"Timsort", "n", "n log(n)", "n log(n)", "n"},
            {"Heapsort", "n log(n)", "n log(n)", "n log(n)", "1"},
            {"Bubble Sort", "n", "n<sup>2</sup>", "n<sup>2</sup>", "1"},
            {"Insertion Sort", "n", "n<sup>2</sup>", "n<sup>2</sup>", "1"},
            {"Selection Sort", "n<sup>2</sup>", "n<sup>2</sup>", "n<sup>2</sup>", "1"}
    };


    private List<ParentListItem> mDataStructureParents;
    private List<ParentListItem> mSortAlgorithmParents;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataStructureParents = initializeDataStructures(mDataStructureParents);
        mSortAlgorithmParents = initializeSortAlgorithms(mSortAlgorithmParents);
    }

    private List<ParentListItem> initializeDataStructures(List<ParentListItem> dataStructureParents) {
        dataStructureParents = new ArrayList<>();
        for (int i = 0; i < DS_DATA.length; i++) {
            DataStructureParent dataStructureParent = new DataStructureParent(DS_DATA[i][0]);
            DataStructureChild dataStructureChild = new DataStructureChild(
                    DS_DATA[i][1], DS_DATA[i][2], DS_DATA[i][3], DS_DATA[i][4], DS_DATA[i][5],
                    DS_DATA[i][6], DS_DATA[i][7], DS_DATA[i][8], DS_DATA[i][9]);
            List<Object> dataStructureChildList = new ArrayList<>();
            dataStructureChildList.add(dataStructureChild);
            dataStructureParent.setChildrenList(dataStructureChildList);
            dataStructureParents.add(dataStructureParent);
        }
        return dataStructureParents;
    }

    private List<ParentListItem> initializeSortAlgorithms(List<ParentListItem> sortAlgorithmParents) {
        sortAlgorithmParents = new ArrayList<>();
        for (int i = 0; i < SA_DATA.length; i++) {
            SortAlgorithmParent sortAlgorithmParent = new SortAlgorithmParent(SA_DATA[i][0]);
            SortAlgorithmChild sortAlgorithmChild = new SortAlgorithmChild(
                    SA_DATA[i][1], SA_DATA[i][2], SA_DATA[i][3], SA_DATA[i][4]);
            List<Object> sortAlgorithmChildList = new ArrayList<>();
            sortAlgorithmChildList.add(sortAlgorithmChild);
            sortAlgorithmParent.setChildrenList(sortAlgorithmChildList);
            sortAlgorithmParents.add(sortAlgorithmParent);
        }
        return sortAlgorithmParents;
    }

    public List<ParentListItem> getAllDataStructure() {
        return mDataStructureParents;
    }

    public List<ParentListItem> getAllSortAlgorithm() {
        return mSortAlgorithmParents;
    }
}
