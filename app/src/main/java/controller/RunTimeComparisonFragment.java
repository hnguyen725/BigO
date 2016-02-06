package controller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.hieunguyen725.bigo.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

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

import RunTimeComplexity.ListRunTime;
import RunTimeComplexity.MapRunTime;
import RunTimeComplexity.SetRunTime;
import RunTimeComplexity.SortRunTime;

/**
 * Created by hieunguyen725 on 1/15/2016.
 */
public class RunTimeComparisonFragment extends Fragment {
    public final String TAG = "RunTimeComparison";

    private Spinner sizeSpinner;
    private Spinner dsTypeSpinner;
    private Spinner arraySettingSpinner;

    private RadioGroup radioGroup;

    private BarChart chart;

    private String currentTestChoice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_run_time_comparison, container, false);

        setUpSpinners(view);
        setRadioGroupListener(view);
        setRunButton(view);

        return view;
    }

    private void setUpSpinners(View view) {
        // Set up input size spinner
        sizeSpinner = (Spinner) view.findViewById(R.id.inputSizeSpinner);
        ArrayAdapter<CharSequence> sizeAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.input_size, R.layout.spinner_item);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeAdapter);

        // set up data structure operation spinner
        dsTypeSpinner = (Spinner) view.findViewById(R.id.dsTypeSpinner);
        ArrayAdapter<CharSequence> operationAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.ds_type, R.layout.spinner_item);
        operationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dsTypeSpinner.setAdapter(operationAdapter);
        dsTypeSpinner.setVisibility(View.VISIBLE);

        // set up array setting spinner
        arraySettingSpinner = (Spinner) view.findViewById(R.id.arraySettingSpinner);
        ArrayAdapter<CharSequence> arraySettingAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.array_setting, R.layout.spinner_item);
        arraySettingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arraySettingSpinner.setAdapter(arraySettingAdapter);
        arraySettingSpinner.setVisibility(View.INVISIBLE);
    }

    private void setRadioGroupListener(View view) {
        radioGroup = (RadioGroup) view.findViewById(R.id.runType);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.dataStructuresRB) {
                    dsTypeSpinner.setVisibility(View.VISIBLE);
                    arraySettingSpinner.setVisibility(View.INVISIBLE);
                } else if (checkedId == R.id.arraySortingAlgorithmsRB) {
                    arraySettingSpinner.setVisibility(View.VISIBLE);
                    dsTypeSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void setRunButton(View view) {
        Button runButton = (Button) view.findViewById(R.id.runButton);
        chart = (BarChart) view.findViewById(R.id.chart);



        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sizeInput = sizeSpinner.getSelectedItem().toString();
                int n = Integer.parseInt(sizeInput);
                int currentRadioId = radioGroup.getCheckedRadioButtonId();
                if (currentRadioId == R.id.dataStructuresRB) {
                    runDataStructuresComparison(n);
                } else if (currentRadioId == R.id.arraySortingAlgorithmsRB) {
                    runSortAlgorithmsComparison(n);
                }
            }
        });
    }

    private void runDataStructuresComparison(int n) {
        String dsType = dsTypeSpinner.getSelectedItem().toString();
        Random rand = new Random();

        if (dsType.equalsIgnoreCase("Lists")) {
            List<Integer> arrayList = new ArrayList<Integer>();
            List<Integer> linkedList = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                arrayList.add(i);
                linkedList.add(i);
            }
            Log.d(TAG, "List selected");
            String[] labels = {"Access", "Search", "Random Insertion", "Sequential Insertion",
                "Random Deletion", "Sequential Deletion"};
            List<BarEntry> arrayListEntries = new ArrayList<>();
            arrayListEntries.add(new BarEntry(ListRunTime.accessTime(arrayList, n), 0));
            arrayListEntries.add(new BarEntry(ListRunTime.searchTime(arrayList, n), 1));
            arrayListEntries.add(new BarEntry(ListRunTime.randomInsertionTime(new ArrayList<Integer>(arrayList), n), 2));
            arrayListEntries.add(new BarEntry(ListRunTime.sequentialInsertionTime(new ArrayList<Integer>(arrayList), n), 3));
            arrayListEntries.add(new BarEntry(ListRunTime.randomDeletionTime(new ArrayList<Integer>(arrayList), n), 4));
            arrayListEntries.add(new BarEntry(ListRunTime.sequentialDeletionTime(new ArrayList<Integer>(arrayList), n), 5));

            Log.d(TAG, "Added arrayList entries");

            List<BarEntry> linkedListEntries = new ArrayList<>();
            linkedListEntries.add(new BarEntry(ListRunTime.accessTime(linkedList, n), 0));
            linkedListEntries.add(new BarEntry(ListRunTime.searchTime(linkedList, n), 1));
            linkedListEntries.add(new BarEntry(ListRunTime.randomInsertionTime(new LinkedList<Integer>(linkedList), n), 2));
            linkedListEntries.add(new BarEntry(ListRunTime.sequentialInsertionTime(new LinkedList<Integer>(linkedList), n), 3));
            linkedListEntries.add(new BarEntry(ListRunTime.randomDeletionTime(new LinkedList<Integer>(linkedList), n), 4));
            linkedListEntries.add(new BarEntry(ListRunTime.sequentialDeletionTime(new LinkedList<Integer>(linkedList), n), 5));

            Log.d(TAG, "Added LinkedList Entries");

            BarDataSet arrayListDataSet = new BarDataSet(arrayListEntries, "ArrayList");
            BarDataSet linkedListDataSet = new BarDataSet(linkedListEntries, "LinkedList");

            arrayListDataSet.setColor(Color.BLUE);

            Log.d(TAG, "BarDataSet created");

            List<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(arrayListDataSet);
            dataSets.add(linkedListDataSet);

            drawChart(dataSets, labels);

        } else if (dsType.equalsIgnoreCase("Sets")) {
            Set<Integer> hashSet = new HashSet<Integer>();
            Set<Integer> treeSet = new TreeSet<Integer>();
            for (int i = 0; i < n; i++) {
                hashSet.add(rand.nextInt(n));
                treeSet.add(rand.nextInt(n));
            }
            String[] labels = {"Search", "Insertion", "Deletion"};
            List<BarEntry> hashSetEntries = new ArrayList<>();
            hashSetEntries.add(new BarEntry(SetRunTime.searchTime(hashSet, n), 0));
            hashSetEntries.add(new BarEntry(SetRunTime.insertionTime(hashSet, n), 1));
            hashSetEntries.add(new BarEntry(SetRunTime.deletionTime(hashSet, n), 2));

            List<BarEntry> treeSetEntries = new ArrayList<>();
            treeSetEntries.add(new BarEntry(SetRunTime.searchTime(treeSet, n), 0));
            treeSetEntries.add(new BarEntry(SetRunTime.insertionTime(treeSet, n), 1));
            treeSetEntries.add(new BarEntry(SetRunTime.deletionTime(treeSet, n), 2));

            BarDataSet hashSetDataSet = new BarDataSet(hashSetEntries, "HashSet");
            BarDataSet treeSetDataSet = new BarDataSet(treeSetEntries, "TreeSet");

            hashSetDataSet.setColor(Color.BLUE);

            List<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(hashSetDataSet);
            dataSets.add(treeSetDataSet);

            drawChart(dataSets, labels);

        } else if (dsType.equalsIgnoreCase("Maps")) {
            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                hashMap.put(rand.nextInt(n), i);
                treeMap.put(rand.nextInt(n), i);
            }
            String[] labels = {"Access", "Search", "Insertion", "Deletion"};

            List<BarEntry> hashMapEntries = new ArrayList<>();
            hashMapEntries.add(new BarEntry(MapRunTime.accessTime(hashMap, n), 0));
            hashMapEntries.add(new BarEntry(MapRunTime.searchTime(hashMap, n), 1));
            hashMapEntries.add(new BarEntry(MapRunTime.insertionTime(hashMap, n), 2));
            hashMapEntries.add(new BarEntry(MapRunTime.deletionTime(hashMap, n), 3));

            List<BarEntry> treeMapEntries = new ArrayList<>();
            treeMapEntries.add(new BarEntry(MapRunTime.accessTime(treeMap, n), 0));
            treeMapEntries.add(new BarEntry(MapRunTime.searchTime(treeMap, n), 1));
            treeMapEntries.add(new BarEntry(MapRunTime.insertionTime(treeMap, n), 2));
            treeMapEntries.add(new BarEntry(MapRunTime.deletionTime(treeMap, n), 3));

            BarDataSet hashMapDataSet = new BarDataSet(hashMapEntries, "HashMap");
            BarDataSet treeMapDataSet = new BarDataSet(treeMapEntries, "TreeMap");

            hashMapDataSet.setColor(Color.BLUE);

            List<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(hashMapDataSet);
            dataSets.add(treeMapDataSet);

            drawChart(dataSets, labels);

        }
    }

    private void runSortAlgorithmsComparison(int n) {
        int[] array = generateArray(n);

        String[] labels = {"Bubble sort", "Merge sort", "Insertion sort", "Selection sort", "Quicksort"};
        List<BarEntry> sortTimeEntries = new ArrayList<>();
        sortTimeEntries.add(new BarEntry(SortRunTime.BubbleSort.sort(Arrays.copyOf(array, array.length)), 0));
        sortTimeEntries.add(new BarEntry(SortRunTime.MergeSort.sort(Arrays.copyOf(array, array.length)), 1));
        sortTimeEntries.add(new BarEntry(SortRunTime.InsertionSort.sort(Arrays.copyOf(array, array.length)), 2));
        sortTimeEntries.add(new BarEntry(SortRunTime.SelectionSort.sort(Arrays.copyOf(array, array.length)), 3));
        sortTimeEntries.add(new BarEntry(SortRunTime.QuickSort.sort(Arrays.copyOf(array, array.length)), 4));

        BarDataSet sortTimeDataSet = new BarDataSet(sortTimeEntries, "Algorithms");
        sortTimeDataSet.setBarSpacePercent(50f);

        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(sortTimeDataSet);

        drawChart(dataSets, labels);

    }

    private int[] generateArray(int n) {
        String arraySetting = arraySettingSpinner.getSelectedItem().toString();
        Random rand = new Random();
        int[] array = new int[n];
        if (arraySetting.equalsIgnoreCase("Random")) {
            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt(n);
            }
        } else if (arraySetting.equalsIgnoreCase("Nearly Sorted")) {
            double sortedChance = 0.9;
            for (int i = 0; i < n; i++) {
                double currentChance = rand.nextDouble();
                if (currentChance >= sortedChance) {
                    array[i] = rand.nextInt(i);
                } else {
                    array[i] = i;
                }
            }
        } else if (arraySetting.equalsIgnoreCase("Reverse")) {
            for (int i = 0; i < n; i++) {
                array[i] = n - i - 1;
            }
        }
        return array;
    }

    private void drawChart(List<IBarDataSet> dataSets, String[] labels) {
        BarData data = new BarData(labels, dataSets);
        data.setValueTextSize(10f);

        Log.d(TAG, "Prepare to draw");

        chart.setData(data);

        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setFormSize(10f);
        legend.setTextSize(12f);
        legend.setFormToTextSpace(5f);
        legend.setXEntrySpace(20f);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        legend.setExtra(new int[] {Color.BLACK}, new String[] {"Unit - Microseconds"});
        chart.notifyDataSetChanged();

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(8f); // top labels
        xAxis.setSpaceBetweenLabels(0);

        chart.setDescription("");
        chart.setDescriptionTextSize(10f);
        chart.setDescriptionPosition(300f, 100f);

        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisLeft().setDrawLabels(false);
        chart.getAxisLeft().setDrawGridLines(false); // vertical line grid
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false); // horizontal line grid

//            chart.animateXY(3000, 3000);
        chart.animateY(3000, Easing.EasingOption.EaseInOutBounce);
        chart.setGridBackgroundColor(Color.TRANSPARENT);
        chart.fitScreen();
        chart.setVisibleXRangeMaximum(10);

        // disable zooming
        chart.setPinchZoom(false);
        chart.setDoubleTapToZoomEnabled(false);

        // draw
        chart.invalidate();

        Log.d(TAG, "Started Drawing Chart");
    }
}
