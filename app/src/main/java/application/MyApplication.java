package application;

import android.app.Application;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import model.DataStructureChild;
import model.DataStructureParent;

/**
 * Created by hieunguyen725 on 12/24/2015.
 */
public class MyApplication extends Application {
    /**
     * Information about data structures complexities
     * index values are in the following order:
     * 0 - name, 1 - average access complexity, 2 - average search complexity,
     * 3 - average insertion, 4 - average deletion, 5 - worst case access, 6 - worst case search,
     * 7 - worst case insertion, 8 - worst case deletion, and 9 - worst case space complexity.
     */
    private final String DS_DATA[][] = {
            {"Array", "1", "n", "n", "n", "1", "n", "n", "n", "n"},
            {"Stack", "n", "n", "1", "1", "n", "n", "1", "1", "n"},
            {"Singly-Linked List", "n", "n", "1", "1", "n", "n", "1", "1", "n"},
            {"Doubly-Linked List", "n", "n", "1", "1", "n", "n", "1", "1", "n"},
            {"Skip List", "log(n)", "log(n)", "log(n)", "log(n)", "n", "n", "n", "n", "n log(n)"},
            {"Hash Table", "-", "1", "1", "1", "-", "n", "n", "n", "n"},
            {"Binary Search Tree", "log(n)", "log(n)", "log(n)", "log(n)", "n", "n", "n", "n", "n"},
            {"Cartesian Tree", "-", "log(n)", "log(n)", "log(n)", "-", "n", "n", "n", "n"},
            {"B-Tree", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "n"},
            {"Red-Black Tree", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "n"},
            {"Splay Tree", "-", "log(n)", "log(n)", "log(n)", "-", "log(n)", "log(n)", "log(n)", "n"},
            {"AVL Tree", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "log(n)", "n"},
    };

    private final String SA_DATA[][] = {
            {"Quicksort", "n log(n)", "n log(n)", "n^2", "log(n)"},
            {"Mergesort", "n log(n)", "n log(n)", "n log(n)", "n"},
            {"Timsort", "n", "n log(n)", "n log(n)", "n"},
            {"Heapsort", "n log(n)", "n log(n)", "n log(n)", "1"},
            {"Bubble Sort", "n", "n^2", "n^2", "1"},
            {"Insertion Sort", "n", "n^2", "n^2", "1"},
            {"Selection Sort", "n^2", "n^2", "n^2", "1"}
    };


    private List<ParentObject> mDataStructureParents;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataStructureParents = initializeData(mDataStructureParents);
    }

    private List<ParentObject> initializeData(List<ParentObject> dataStructureParents) {
        dataStructureParents = new ArrayList<>();
        for (int i = 0; i < DS_DATA.length; i++) {
            DataStructureParent dataStructureParent = new DataStructureParent(DS_DATA[i][0]);
            DataStructureChild dataStructureChild = new DataStructureChild(
                    DS_DATA[i][1], DS_DATA[i][2], DS_DATA[i][3], DS_DATA[i][4], DS_DATA[i][5],
                    DS_DATA[i][6], DS_DATA[i][7], DS_DATA[i][8], DS_DATA[i][9]);
            List<Object> dataStructureChildList = new ArrayList<>();
            dataStructureChildList.add(dataStructureChild);
            dataStructureParent.setChildObjectList(dataStructureChildList);
            dataStructureParents.add(dataStructureParent);
        }
        return dataStructureParents;
    }

    public List<ParentObject> getAllDataStructure() {
        return mDataStructureParents;
    }
}
