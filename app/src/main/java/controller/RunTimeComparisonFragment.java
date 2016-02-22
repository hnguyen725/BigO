package controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.hieunguyen725.bigo.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.List;

/**
 * Created by hieunguyen725 on 1/15/2016.
 */
public class RunTimeComparisonFragment extends Fragment {
    public final String TAG = "RunTimeComparison";

    private Spinner sizeSpinner;
    private Spinner dsTypeSpinner;
    private Spinner arraySettingSpinner;

    private RadioGroup radioGroup;
    private int currentRadioButtonId;

    private BarChart chart;

    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_run_time_comparison, container, false);

        chart = (BarChart) view.findViewById(R.id.chart);
        progressBar = (ProgressBar) view.findViewById(R.id.displayProgress);
        progressBar.setVisibility(View.INVISIBLE);

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

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTestProcess();
            }
        });
    }

    private void startTestProcess() {
        int sizeInput = Integer.parseInt(sizeSpinner.getSelectedItem().toString());
        int currentRadioId = radioGroup.getCheckedRadioButtonId();

        RetrieveData currentTask = new RetrieveData();
        currentTask.execute(sizeInput, currentRadioId);
    }

    public class RetrieveData extends AsyncTask<Integer, Void, List<IBarDataSet>> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<IBarDataSet> doInBackground(Integer... params) {
            int sizeInput = params[0];
            currentRadioButtonId = params[1];
            if (currentRadioButtonId == R.id.dataStructuresRB) {
                return MyChart.getDataStructuresTime(sizeInput, dsTypeSpinner);
            } else if (currentRadioButtonId == R.id.arraySortingAlgorithmsRB) {
                return MyChart.getSortAlgorithmsTime(sizeInput, arraySettingSpinner);
            } else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<IBarDataSet> dataSets) {
            progressBar.setVisibility(View.INVISIBLE);
            if (dataSets != null) {
                MyChart.display(chart, dataSets, chooseLabels());
            }
        }
    }

    private String[] chooseLabels() {
        if (currentRadioButtonId == R.id.dataStructuresRB) {
            String dataStructureType = dsTypeSpinner.getSelectedItem().toString();
            if (dataStructureType.equalsIgnoreCase("Sets")) {
                return new String[] {"Search", "Insertion", "Deletion"};
            } else if (dataStructureType.equalsIgnoreCase("Lists")) {
                return new String[] {"Access", "Search", "Random Insertion",
                        "Sequential Insertion", "Random Deletion", "Sequential Deletion"};
            } else {
                return new String[] {"Access", "Search", "Insertion", "Deletion"};
            }
        } else if (currentRadioButtonId == R.id.arraySortingAlgorithmsRB) {
            return new String[] {"Bubble sort", "Merge sort", "Insertion sort",
                    "Selection sort", "Quicksort"};
        } else {
            return null;
        }
    }
}
