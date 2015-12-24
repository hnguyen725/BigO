package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hieunguyen725 on 12/23/2015.
 */
public class MyDatabase extends SQLiteOpenHelper {

    private static final String TAG = "MyDatabase";

    private static final String DATABASE_NAME = "bigO.db";
    private static final int DATABASE_VERSION = 1;

    public static final class DSBigOTable {
        public static final String NAME = "DataStructureComplexity";

        public static final class Columns {
            public static final String DS_NAME = "dataStructureName";
            public static final String A_ACCESS = "averageAccess";
            public static final String A_SEARCH = "averageSearch";
            public static final String A_INSERTION = "averageInsertion";
            public static final String A_DELETION = "averageDeletion";
            public static final String W_ACCESS = "worstAccess";
            public static final String W_SEARCH = "worstSearch";
            public static final String W_INSERTION = "worstInsertion";
            public static final String W_DELETION = "worstDeletion";
            public static final String W_SPACE = "worstSpace";
        }
    }

    public static final String CREATE_DATA_STRUCTURE_TABLE =
            "CREATE TABLE " + DSBigOTable.NAME + " (" +
                    DSBigOTable.Columns.DS_NAME + " TEXT PRIMARY KEY, " +
                    DSBigOTable.Columns.A_ACCESS + " TEXT, " +
                    DSBigOTable.Columns.A_SEARCH + " TEXT, " +
                    DSBigOTable.Columns.A_INSERTION + " TEXT, " +
                    DSBigOTable.Columns.A_DELETION + " TEXT, " +
                    DSBigOTable.Columns.W_ACCESS + " TEXT, " +
                    DSBigOTable.Columns.W_SEARCH + " TEXT, " +
                    DSBigOTable.Columns.W_INSERTION + " TEXT, " +
                    DSBigOTable.Columns.W_DELETION + " TEXT, " +
                    DSBigOTable.Columns.W_SPACE + " TEXT " +
                    ")";

    public static final String DS_DATA[][] = {
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

    public static final class SortingBigOTable {
        public static final String NAME = "SortingAlgorithmsComplexity";

        public static final class Columns {
            public static final String SA_NAME = "SortingAlgorithmName";
            public static final String B_CASE = "bestCaseComplexity";
            public static final String A_CASE = "averageCaseComplexity";
            public static final String W_CASE = "worstCaseComplexity";
            public static final String W_SPACE = "worstSpace";
        }
    }

    public static final String CREATE_SORTING_ALGORITHM_TABLE =
            "CREATE TABLE " + SortingBigOTable.NAME + " (" +
                    SortingBigOTable.Columns.SA_NAME + " TEXT PRIMARY KEY, " +
                    SortingBigOTable.Columns.B_CASE + " TEXT, " +
                    SortingBigOTable.Columns.A_CASE + " TEXT, " +
                    SortingBigOTable.Columns.W_CASE + " TEXT, " +
                    SortingBigOTable.Columns.W_SPACE + " TEXT " +
                    ")";

    public static final String SA_DATA[][] = {
            {"Quicksort", "n log(n)", "n log(n)", "n^2", "log(n)"},
            {"Mergesort", "n log(n)", "n log(n)", "n log(n)", "n"},
            {"Timsort", "n", "n log(n)", "n log(n)", "n"},
            {"Heapsort", "n log(n)", "n log(n)", "n log(n)", "1"},
            {"Bubble Sort", "n", "n^2", "n^2", "1"},
            {"Insertion Sort", "n", "n^2", "n^2", "1"},
            {"Selection Sort", "n^2", "n^2", "n^2", "1"}
    };


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATA_STRUCTURE_TABLE);
        db.execSQL(CREATE_SORTING_ALGORITHM_TABLE);
        initializeData(db);
        Log.i(TAG, "Tables have been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DSBigOTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SortingBigOTable.NAME);
        onCreate(db);
    }

    private void initializeData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        for (int i = 0; i < DS_DATA.length; i++) {
            String[] dataStructure = DS_DATA[i];
            for (int j = 0; j < dataStructure.length; j++) {
                values.put(DSBigOTable.Columns.DS_NAME, dataStructure[0]);
                values.put(DSBigOTable.Columns.A_ACCESS, dataStructure[1]);
                values.put(DSBigOTable.Columns.A_SEARCH, dataStructure[2]);
                values.put(DSBigOTable.Columns.A_INSERTION, dataStructure[3]);
                values.put(DSBigOTable.Columns.A_DELETION, dataStructure[4]);
                values.put(DSBigOTable.Columns.W_ACCESS, dataStructure[5]);
                values.put(DSBigOTable.Columns.W_SEARCH, dataStructure[6]);
                values.put(DSBigOTable.Columns.W_INSERTION, dataStructure[7]);
                values.put(DSBigOTable.Columns.W_DELETION, dataStructure[8]);
                values.put(DSBigOTable.Columns.W_SPACE, dataStructure[9]);
                db.insert(DSBigOTable.NAME, null, values);
            }
            values.clear();
        }

        for (int i = 0; i < SA_DATA.length; i++) {
            String[] sortingAlgorithm = SA_DATA[i];
            for (int j = 0; j < sortingAlgorithm.length; j++) {
                values.put(SortingBigOTable.Columns.SA_NAME, sortingAlgorithm[0]);
                values.put(SortingBigOTable.Columns.B_CASE, sortingAlgorithm[1]);
                values.put(SortingBigOTable.Columns.A_CASE, sortingAlgorithm[2]);
                values.put(SortingBigOTable.Columns.W_CASE, sortingAlgorithm[3]);
                values.put(SortingBigOTable.Columns.W_SPACE, sortingAlgorithm[4]);
                db.insert(SortingBigOTable.NAME, null, values);
            }
            values.clear();
        }
    }
}
