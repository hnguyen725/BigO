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
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import RunTimeComplexity.ListRunTime;
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
                if (checkedId == R.id.dataStructuresRB ) {
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
                    Log.d(TAG, "ds checked");
                    runDataStructuresComparison(n);
//                    TestRun.testDS(n);
//                    Log.d(TAG, "Test run finished");
                } else if (currentRadioId == R.id.arraySortingAlgorithmsRB) {
                    Log.d(TAG, "sa checked");
                    runSortAlgorithmsComparison(n);
                }
            }
        });
    }

    private void runDataStructuresComparison(int n) {
        String dsType = dsTypeSpinner.getSelectedItem().toString();

        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
//        Set<Integer> hashSet = new HashSet<Integer>();
//        Set<Integer> treeSet = new TreeSet<Integer>();
//        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
//            hashSet.add(rand.nextInt(n));
//            treeSet.add(rand.nextInt(n));
//            hashMap.put(rand.nextInt(n), i);
//            treeMap.put(rand.nextInt(n), i);
        }

        if (dsType.equalsIgnoreCase("Lists")) {
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

            BarData data = new BarData(labels, dataSets);
            data.setValueTextSize(11f);

            Log.d(TAG, "Prepare to draw");

            chart.setData(data);

            Legend legend = chart.getLegend();
            legend.setForm(Legend.LegendForm.CIRCLE);
            legend.setFormSize(10f);
            legend.setTextSize(12f);
            legend.setFormToTextSpace(5f);
            legend.setXEntrySpace(20f);
            legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);

            XAxis xAxis = chart.getXAxis();
            xAxis.setTextSize(12f);

            chart.setDescription("Time unit - Milliseconds");
            chart.setDescriptionTextSize(12f);
            chart.setDescriptionPosition(400f, 150f);

            chart.getAxisRight().setDrawLabels(false);
            chart.getAxisLeft().setDrawLabels(false);
            chart.getAxisLeft().setDrawGridLines(false); // vertical line grid
            chart.getXAxis().setDrawGridLines(false);
            chart.getAxisRight().setDrawGridLines(false); // horizontal line grid
//            chart.animateXY(3000, 3000);
            chart.animateY(3000, Easing.EasingOption.EaseInOutBounce);
            chart.setVisibleXRangeMaximum(9);
            chart.setGridBackgroundColor(Color.TRANSPARENT);
            chart.invalidate();

            Log.d(TAG, "Started Drawing Chart");

        } else if (dsType.equalsIgnoreCase("Sets")) {
            String[] labels = {"Search", "Insertion", "Deletion"};

        } else if (dsType.equalsIgnoreCase("Maps")) {
            String[] labels = {"Access", "Search", "Insertion", "Deletion"};

        }
    }

    private void runSortAlgorithmsComparison(int n) {
        Random rand = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n);
        }
        Log.d(TAG, "" + SortRunTime.QuickSort.sort(array));
    }
}
