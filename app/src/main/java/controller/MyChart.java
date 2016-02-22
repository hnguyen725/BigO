package controller;

import android.graphics.Color;
import android.widget.Spinner;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

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
 * Created by hieunguyen725 on 2/5/2016.
 */
public class MyChart {
    private static Random rand = new Random();

    public static List<IBarDataSet> getDataStructuresTime(int sizeInput, Spinner dataStructureType) {
        String dsType = dataStructureType.getSelectedItem().toString();

        List<IBarDataSet> dataSets = new ArrayList<>();

        if (dsType.equalsIgnoreCase("Sets")) {
            getSetsData(dataSets, sizeInput);
        } else if (dsType.equalsIgnoreCase("Lists")) {
            getListsData(dataSets, sizeInput);
        } else if (dsType.equalsIgnoreCase("Maps")) {
            getMapsData(dataSets, sizeInput);
        }

        return dataSets;
    }

    private static void getSetsData(List<IBarDataSet> dataSets, int sizeInput) {
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < sizeInput; i++) {
            hashSet.add(rand.nextInt(sizeInput));
            treeSet.add(rand.nextInt(sizeInput));
        }
        List<BarEntry> hashSetEntries = new ArrayList<>();
        hashSetEntries.add(new BarEntry(SetRunTime.searchTime(hashSet, sizeInput), 0));
        hashSetEntries.add(new BarEntry(SetRunTime.insertionTime(hashSet, sizeInput), 1));
        hashSetEntries.add(new BarEntry(SetRunTime.deletionTime(hashSet, sizeInput), 2));

        List<BarEntry> treeSetEntries = new ArrayList<>();
        treeSetEntries.add(new BarEntry(SetRunTime.searchTime(treeSet, sizeInput), 0));
        treeSetEntries.add(new BarEntry(SetRunTime.insertionTime(treeSet, sizeInput), 1));
        treeSetEntries.add(new BarEntry(SetRunTime.deletionTime(treeSet, sizeInput), 2));

        BarDataSet hashSetDataSet = new BarDataSet(hashSetEntries, "HashSet");
        BarDataSet treeSetDataSet = new BarDataSet(treeSetEntries, "TreeSet");

        hashSetDataSet.setColor(Color.BLUE);

        dataSets.add(hashSetDataSet);
        dataSets.add(treeSetDataSet);
    }

    private static void getListsData(List<IBarDataSet> dataSets, int sizeInput) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < sizeInput; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        List<BarEntry> arrayListEntries = new ArrayList<>();
        arrayListEntries.add(new BarEntry(ListRunTime.accessTime(arrayList, sizeInput), 0));
        arrayListEntries.add(new BarEntry(ListRunTime.searchTime(arrayList, sizeInput), 1));
        arrayListEntries.add(new BarEntry(ListRunTime.randomInsertionTime(new ArrayList<Integer>(arrayList), sizeInput), 2));
        arrayListEntries.add(new BarEntry(ListRunTime.sequentialInsertionTime(new ArrayList<Integer>(arrayList), sizeInput), 3));
        arrayListEntries.add(new BarEntry(ListRunTime.randomDeletionTime(new ArrayList<Integer>(arrayList), sizeInput), 4));
        arrayListEntries.add(new BarEntry(ListRunTime.sequentialDeletionTime(new ArrayList<Integer>(arrayList), sizeInput), 5));

        List<BarEntry> linkedListEntries = new ArrayList<>();
        linkedListEntries.add(new BarEntry(ListRunTime.accessTime(linkedList, sizeInput), 0));
        linkedListEntries.add(new BarEntry(ListRunTime.searchTime(linkedList, sizeInput), 1));
        linkedListEntries.add(new BarEntry(ListRunTime.randomInsertionTime(new LinkedList<Integer>(linkedList), sizeInput), 2));
        linkedListEntries.add(new BarEntry(ListRunTime.sequentialInsertionTime(new LinkedList<Integer>(linkedList), sizeInput), 3));
        linkedListEntries.add(new BarEntry(ListRunTime.randomDeletionTime(new LinkedList<Integer>(linkedList), sizeInput), 4));
        linkedListEntries.add(new BarEntry(ListRunTime.sequentialDeletionTime(new LinkedList<Integer>(linkedList), sizeInput), 5));

        BarDataSet arrayListDataSet = new BarDataSet(arrayListEntries, "ArrayList");
        BarDataSet linkedListDataSet = new BarDataSet(linkedListEntries, "LinkedList");

        arrayListDataSet.setColor(Color.BLUE);

        dataSets.add(arrayListDataSet);
        dataSets.add(linkedListDataSet);
    }

    private static void getMapsData(List<IBarDataSet> dataSets, int sizeInput) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < sizeInput; i++) {
            hashMap.put(rand.nextInt(sizeInput), i);
            treeMap.put(rand.nextInt(sizeInput), i);
        }

        List<BarEntry> hashMapEntries = new ArrayList<>();
        hashMapEntries.add(new BarEntry(MapRunTime.accessTime(hashMap, sizeInput), 0));
        hashMapEntries.add(new BarEntry(MapRunTime.searchTime(hashMap, sizeInput), 1));
        hashMapEntries.add(new BarEntry(MapRunTime.insertionTime(hashMap, sizeInput), 2));
        hashMapEntries.add(new BarEntry(MapRunTime.deletionTime(hashMap, sizeInput), 3));

        List<BarEntry> treeMapEntries = new ArrayList<>();
        treeMapEntries.add(new BarEntry(MapRunTime.accessTime(treeMap, sizeInput), 0));
        treeMapEntries.add(new BarEntry(MapRunTime.searchTime(treeMap, sizeInput), 1));
        treeMapEntries.add(new BarEntry(MapRunTime.insertionTime(treeMap, sizeInput), 2));
        treeMapEntries.add(new BarEntry(MapRunTime.deletionTime(treeMap, sizeInput), 3));

        BarDataSet hashMapDataSet = new BarDataSet(hashMapEntries, "HashMap");
        BarDataSet treeMapDataSet = new BarDataSet(treeMapEntries, "TreeMap");

        hashMapDataSet.setColor(Color.BLUE);

        dataSets.add(hashMapDataSet);
        dataSets.add(treeMapDataSet);
    }

    public static List<IBarDataSet> getSortAlgorithmsTime(int sizeInput, Spinner currentArraySetting) {
        int[] array = generateArray(sizeInput, currentArraySetting);

        List<IBarDataSet> dataSets = new ArrayList<>();

        List<BarEntry> sortTimeEntries = new ArrayList<>();
        sortTimeEntries.add(new BarEntry(SortRunTime.BubbleSort.sort(Arrays.copyOf(array, array.length)), 0));
        sortTimeEntries.add(new BarEntry(SortRunTime.MergeSort.sort(Arrays.copyOf(array, array.length)), 1));
        sortTimeEntries.add(new BarEntry(SortRunTime.InsertionSort.sort(Arrays.copyOf(array, array.length)), 2));
        sortTimeEntries.add(new BarEntry(SortRunTime.SelectionSort.sort(Arrays.copyOf(array, array.length)), 3));
        sortTimeEntries.add(new BarEntry(SortRunTime.QuickSort.sort(Arrays.copyOf(array, array.length)), 4));

        BarDataSet sortTimeDataSet = new BarDataSet(sortTimeEntries, "Algorithms");
        sortTimeDataSet.setBarSpacePercent(50f);

        // setting colors
        int[][] colorTemplates =  {
                ColorTemplate.JOYFUL_COLORS, ColorTemplate.COLORFUL_COLORS,
                ColorTemplate.VORDIPLOM_COLORS, ColorTemplate.PASTEL_COLORS
        };
        sortTimeDataSet.setColors(colorTemplates[rand.nextInt(colorTemplates.length)]);

        dataSets.add(sortTimeDataSet);

        return dataSets;
    }


    private static int[] generateArray(int n, Spinner currentArraySetting) {
        String arraySetting = currentArraySetting.getSelectedItem().toString();
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
                    array[i] = rand.nextInt(n);
                } else {
                    array[i] = i;
                }
            }
        } else if (arraySetting.equalsIgnoreCase("Reversed")) {
            for (int i = 0; i < n; i++) {
                array[i] = n - i - 1;
            }
        }
        return array;
    }

    public static void display(BarChart chart, List<IBarDataSet> dataSets, String[] labels) {
        BarData data = new BarData(labels, dataSets);
        data.setValueTextSize(10f);

        chart.setData(data);

        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setFormSize(10f);
        legend.setTextSize(12f);
        legend.setFormToTextSpace(5f);
        legend.setXEntrySpace(20f);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        legend.setExtra(new int[]{Color.BLACK}, new String[]{"Unit - Microseconds"});
        chart.notifyDataSetChanged();

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(8f); // top labels
        xAxis.setLabelsToSkip(0);// number of labels to skip
        xAxis.setSpaceBetweenLabels(0); // space in characters
        chart.setDescription("");
        chart.setDescriptionTextSize(10f);
        chart.setDescriptionPosition(300f, 100f);

        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisLeft().setDrawLabels(false);
        chart.getAxisLeft().setDrawGridLines(false); // vertical line grid
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false); // horizontal line grid

        chart.setGridBackgroundColor(Color.TRANSPARENT);
        chart.fitScreen();
        chart.setVisibleXRangeMaximum(10);


        // disable zooming
        chart.setPinchZoom(false);
        chart.setDoubleTapToZoomEnabled(false);

        // animation
        //            chart.animateXY(3000, 3000);
        Easing.EasingOption[] easingOptions = {
                Easing.EasingOption.EaseInBack, Easing.EasingOption.EaseInBounce,
                Easing.EasingOption.EaseInOutBack, Easing.EasingOption.EaseInOutBounce,
                Easing.EasingOption.EaseOutBack, Easing.EasingOption.EaseOutBounce
        };
//        chart.animateY(3000, Easing.EasingOption.EaseInOutBounce);
        chart.animateY(3000, easingOptions[rand.nextInt(easingOptions.length)]);

        // draw
        chart.invalidate();

    }
}
