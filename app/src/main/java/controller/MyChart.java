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

import RunTimeComplexity.ListTimeUtil;
import RunTimeComplexity.MapTimeUtil;
import RunTimeComplexity.SetTimeUtil;
import RunTimeComplexity.SortTimeUtil;

/**
 * My chart util class to retrieve the runtime data and
 * draw the chart accordingly to the runtime.
 */
public class MyChart {
    /**
     * Random object to retrieve random indexes and numbers.
     */
    private Random mRand;

    /**
     * Construct a new my chart util class.
     */
    public MyChart() {
        mRand = new Random();
    }

    /**
     * Return the selected data structure runtime for its operations with the given
     * size input (n).
     * @param sizeInput the input size of n to compute the runtime complexity.
     * @param dataStructureType the spinner to get selected data structure type.
     * @return list of bar data sets for the selected data structure type.
     */
    public List<IBarDataSet> getDataStructuresTime(int sizeInput, Spinner dataStructureType) {
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

    /**
     * Set the given data sets with bar entries of with the set interface's operations runtime.
     * @param dataSets the given empty datasets list.
     * @param sizeInput the input size of n to compute the runtime.
     */
    private void getSetsData(List<IBarDataSet> dataSets, int sizeInput) {
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < sizeInput; i++) {
            hashSet.add(mRand.nextInt(sizeInput));
            treeSet.add(mRand.nextInt(sizeInput));
        }

        SetTimeUtil setTimeUtil = new SetTimeUtil();

        List<BarEntry> hashSetEntries = new ArrayList<>();
        hashSetEntries.add(new BarEntry(setTimeUtil.searchTime(hashSet, sizeInput), 0));
        hashSetEntries.add(new BarEntry(setTimeUtil.insertionTime(hashSet, sizeInput), 1));
        hashSetEntries.add(new BarEntry(setTimeUtil.deletionTime(hashSet, sizeInput), 2));

        List<BarEntry> treeSetEntries = new ArrayList<>();
        treeSetEntries.add(new BarEntry(setTimeUtil.searchTime(treeSet, sizeInput), 0));
        treeSetEntries.add(new BarEntry(setTimeUtil.insertionTime(treeSet, sizeInput), 1));
        treeSetEntries.add(new BarEntry(setTimeUtil.deletionTime(treeSet, sizeInput), 2));

        BarDataSet hashSetDataSet = new BarDataSet(hashSetEntries, "HashSet");
        BarDataSet treeSetDataSet = new BarDataSet(treeSetEntries, "TreeSet");

        hashSetDataSet.setColor(getRandomColor());
        treeSetDataSet.setColor(getRandomColor());

        dataSets.add(hashSetDataSet);
        dataSets.add(treeSetDataSet);
    }

    /**
     * Set the given data sets with bar entries of with the list interface's operations runtime.
     * @param dataSets the given empty datasets list.
     * @param sizeInput the input size of n to compute the runtime.
     */
    private void getListsData(List<IBarDataSet> dataSets, int sizeInput) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < sizeInput; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        ListTimeUtil listTimeUtil = new ListTimeUtil();

        List<BarEntry> arrayListEntries = new ArrayList<>();
        arrayListEntries.add(new BarEntry(listTimeUtil.accessTime(arrayList, sizeInput), 0));
        arrayListEntries.add(new BarEntry(listTimeUtil.searchTime(arrayList, sizeInput), 1));
        arrayListEntries.add(new BarEntry(listTimeUtil.randomInsertionTime(new ArrayList<Integer>(arrayList), sizeInput), 2));
        arrayListEntries.add(new BarEntry(listTimeUtil.sequentialInsertionTime(new ArrayList<Integer>(arrayList), sizeInput), 3));
        arrayListEntries.add(new BarEntry(listTimeUtil.randomDeletionTime(new ArrayList<Integer>(arrayList), sizeInput), 4));
        arrayListEntries.add(new BarEntry(listTimeUtil.sequentialDeletionTime(new ArrayList<Integer>(arrayList), sizeInput), 5));

        List<BarEntry> linkedListEntries = new ArrayList<>();
        linkedListEntries.add(new BarEntry(listTimeUtil.accessTime(linkedList, sizeInput), 0));
        linkedListEntries.add(new BarEntry(listTimeUtil.searchTime(linkedList, sizeInput), 1));
        linkedListEntries.add(new BarEntry(listTimeUtil.randomInsertionTime(new LinkedList<Integer>(linkedList), sizeInput), 2));
        linkedListEntries.add(new BarEntry(listTimeUtil.sequentialInsertionTime(new LinkedList<Integer>(linkedList), sizeInput), 3));
        linkedListEntries.add(new BarEntry(listTimeUtil.randomDeletionTime(new LinkedList<Integer>(linkedList), sizeInput), 4));
        linkedListEntries.add(new BarEntry(listTimeUtil.sequentialDeletionTime(new LinkedList<Integer>(linkedList), sizeInput), 5));

        BarDataSet arrayListDataSet = new BarDataSet(arrayListEntries, "ArrayList");
        BarDataSet linkedListDataSet = new BarDataSet(linkedListEntries, "LinkedList");

        arrayListDataSet.setColor(getRandomColor());
        linkedListDataSet.setColor(getRandomColor());

        dataSets.add(arrayListDataSet);
        dataSets.add(linkedListDataSet);
    }

    /**
     * Set the given data sets with bar entries of with the map interface's operations runtime.
     * @param dataSets the given empty datasets list.
     * @param sizeInput the input size of n to compute the runtime.
     */
    private void getMapsData(List<IBarDataSet> dataSets, int sizeInput) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < sizeInput; i++) {
            hashMap.put(mRand.nextInt(sizeInput), i);
            treeMap.put(mRand.nextInt(sizeInput), i);
        }

        MapTimeUtil mapTimeUtil = new MapTimeUtil();

        List<BarEntry> hashMapEntries = new ArrayList<>();
        hashMapEntries.add(new BarEntry(mapTimeUtil.accessTime(hashMap, sizeInput), 0));
        hashMapEntries.add(new BarEntry(mapTimeUtil.searchTime(hashMap, sizeInput), 1));
        hashMapEntries.add(new BarEntry(mapTimeUtil.insertionTime(hashMap, sizeInput), 2));
        hashMapEntries.add(new BarEntry(mapTimeUtil.deletionTime(hashMap, sizeInput), 3));

        List<BarEntry> treeMapEntries = new ArrayList<>();
        treeMapEntries.add(new BarEntry(mapTimeUtil.accessTime(treeMap, sizeInput), 0));
        treeMapEntries.add(new BarEntry(mapTimeUtil.searchTime(treeMap, sizeInput), 1));
        treeMapEntries.add(new BarEntry(mapTimeUtil.insertionTime(treeMap, sizeInput), 2));
        treeMapEntries.add(new BarEntry(mapTimeUtil.deletionTime(treeMap, sizeInput), 3));

        BarDataSet hashMapDataSet = new BarDataSet(hashMapEntries, "HashMap");
        BarDataSet treeMapDataSet = new BarDataSet(treeMapEntries, "TreeMap");

        hashMapDataSet.setColor(getRandomColor());
        treeMapDataSet.setColor(getRandomColor());

        dataSets.add(hashMapDataSet);
        dataSets.add(treeMapDataSet);
    }

    /**
     * Return a list of bar data sets with all sort algorithms runtime.
     * Given input size and array setting.
     * @param sizeInput the input size of n to compute the runtime complexity.
     * @param currentArraySetting the spinner to get selected array setting before sort.
     * @return list of bar data sets of sort algorithms runtime.
     */
    public List<IBarDataSet> getSortAlgorithmsTime(int sizeInput, Spinner currentArraySetting) {
        int[] array = generateArray(sizeInput, currentArraySetting);

        List<IBarDataSet> dataSets = new ArrayList<>();

        SortTimeUtil sortTimeUtil = new SortTimeUtil();

        List<BarEntry> sortTimeEntries = new ArrayList<>();
        sortTimeEntries.add(new BarEntry(sortTimeUtil.bubbleSortTime(Arrays.copyOf(array, array.length)), 0));
        sortTimeEntries.add(new BarEntry(sortTimeUtil.mergeSortTime(Arrays.copyOf(array, array.length)), 1));
        sortTimeEntries.add(new BarEntry(sortTimeUtil.insertionSortTime(Arrays.copyOf(array, array.length)), 2));
        sortTimeEntries.add(new BarEntry(sortTimeUtil.selectionSortTime(Arrays.copyOf(array, array.length)), 3));
        sortTimeEntries.add(new BarEntry(sortTimeUtil.quickSortTime(Arrays.copyOf(array, array.length)), 4));

        BarDataSet sortTimeDataSet = new BarDataSet(sortTimeEntries, "Algorithms");
        sortTimeDataSet.setBarSpacePercent(50f);

        int[][] colorTemplates =  {
                ColorTemplate.JOYFUL_COLORS, ColorTemplate.COLORFUL_COLORS,
                ColorTemplate.VORDIPLOM_COLORS, ColorTemplate.PASTEL_COLORS
        };
        sortTimeDataSet.setColors(colorTemplates[mRand.nextInt(colorTemplates.length)]);

        dataSets.add(sortTimeDataSet);

        return dataSets;
    }

    /**
     * Generate and return an array to sort given a spinner to get the selected
     * array setting and a input size of n for the array size.
     * @param n input size of the size of the array.
     * @param currentArraySetting spinner to get the selected array setting.
     * @return an initial array to be sorted.
     */
    private int[] generateArray(int n, Spinner currentArraySetting) {
        String arraySetting = currentArraySetting.getSelectedItem().toString();
        int[] array = new int[n];
        if (arraySetting.equalsIgnoreCase("Random")) {
            for (int i = 0; i < n; i++) {
                array[i] = mRand.nextInt(n);
            }
        } else if (arraySetting.equalsIgnoreCase("Nearly Sorted")) {
            double sortedChance = 0.85;
            for (int i = 0; i < n; i++) {
                double currentChance = mRand.nextDouble();
                if (currentChance >= sortedChance) {
                    array[i] = mRand.nextInt(n);
                } else {
                    array[i] = i;
                }
            }
        } else if (arraySetting.equalsIgnoreCase("Reversed")) {
            for (int i = 0; i < n; i++) {
                array[i] = n - i - 1;
            }
        } else if (arraySetting.equalsIgnoreCase("Few Unique")) {
            double uniqueChance = 0.85;
            for (int i = 0; i < n; i++) {
                double currentChance = mRand.nextDouble();
                if (currentChance >= uniqueChance) {
                    array[i] = mRand.nextInt(n);
                } else {
                    array[i] = n;
                }
            }
        }
        return array;
    }

    /**
     * Display the chart information with the given bar data sets and labels.
     * @param chart the chart object to set display with.
     * @param dataSets the bar data sets to of runtime information to display.
     * @param labels the top x-axis labels.
     */
    public void display(BarChart chart, List<IBarDataSet> dataSets, String[] labels) {
        BarData data = new BarData(labels, dataSets);
        data.setValueTextSize(10f);

        chart.setData(data);
        setChartLegend(chart);
        chart.notifyDataSetChanged();

        setChartAxis(chart);

        chart.setGridBackgroundColor(Color.TRANSPARENT);
        chart.fitScreen();
        chart.setVisibleXRangeMaximum(10);

        setCharAnimation(chart);

        // disable zooming
        chart.setPinchZoom(false);
        chart.setDoubleTapToZoomEnabled(false);

        chart.invalidate();
    }

    /**
     * Helper method to set the chart's axis settings.
     * @param chart the bar chart to set axis settings with.
     */
    private void setChartAxis(BarChart chart) {
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
    }

    /**
     * Helper method to set the chart's legend.
     * @param chart the bar chart to set legend with.
     */
    private void setChartLegend(BarChart chart) {
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setFormSize(10f);
        legend.setTextSize(12f);
        legend.setFormToTextSpace(5f);
        legend.setXEntrySpace(20f);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        legend.setExtra(new int[]{Color.BLACK}, new String[]{"Unit - Microseconds"});
    }

    /**
     * Helper method to set the chart's random animation.
     * @param chart the bar chart to set animation with.
     */
    private void setCharAnimation(BarChart chart) {
        Easing.EasingOption[] easingOptions = {
                Easing.EasingOption.EaseInBack, Easing.EasingOption.EaseInBounce,
                Easing.EasingOption.EaseInOutBack, Easing.EasingOption.EaseInOutBounce,
                Easing.EasingOption.EaseOutBack, Easing.EasingOption.EaseOutBounce
        };
        chart.animateY(3000, easingOptions[mRand.nextInt(easingOptions.length)]);
    }

    /**
     * Helper method to get random color for the data structure's runtime bar.
     * @return a random integer value that represents the random generated color.
     */
    private int getRandomColor() {
        String[] hexVals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "b", "c", "d", "e", "f"};
        StringBuilder colorSequence = new StringBuilder();
        colorSequence.append("#");
        for (int i = 0; i < 6; i++) {
            colorSequence.append(hexVals[mRand.nextInt(hexVals.length)]);
        }
        return Color.parseColor(colorSequence.toString());
    }
}
