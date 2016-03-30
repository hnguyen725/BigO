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
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.List;

import hieunguyen725.bigo.R;

/**
 * A fragment that will allow the user to run tests on different data structures
 * and algorithm and see their runtime in comparison.
 */
public class RunTimeComparisonFragment extends Fragment {
    public final String TAG = "RunTimeComparison";

    private Spinner mSizeSpinner;
    private Spinner mDSTypeSpinner;
    private Spinner mArraySettingSpinner;
    private RadioGroup mRadioGroup;
    private int mCurrentRadioButtonId;
    private BarChart mChart;
    private MyChart mChartUtil;
    private RetrieveDataTask mCurrentTask;
    private ProgressBar mProgressBar;


    /**
     * onCreate method.
     * @param savedInstanceState bundle of saved state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Set up the initial run time testing view for the users.
     * @param inflater layout inflater
     * @param container the fragment's view group container
     * @param savedInstanceState the previous saved state bundle.
     * @return the view to be created.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_run_time_comparison, container, false);

        mChart = (BarChart) view.findViewById(R.id.chart);
        mProgressBar = (ProgressBar) view.findViewById(R.id.displayProgress);
        mProgressBar.setVisibility(View.INVISIBLE);

        mChartUtil = new MyChart();

        setUpSpinners(view);
        setRadioGroupListener(view);
        setRunButton(view);

        return view;
    }

    /**
     * Set up different spinners for user selection before running the run time tests.
     * @param view the associated view with the attached the spinners.
     */
    private void setUpSpinners(View view) {
        // Set up input size spinner
        mSizeSpinner = (Spinner) view.findViewById(R.id.inputSizeSpinner);
        ArrayAdapter<CharSequence> sizeAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.input_size, R.layout.spinner_item);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSizeSpinner.setAdapter(sizeAdapter);

        // set up data structure operation spinner
        mDSTypeSpinner = (Spinner) view.findViewById(R.id.dsTypeSpinner);
        ArrayAdapter<CharSequence> operationAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.ds_type, R.layout.spinner_item);
        operationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDSTypeSpinner.setAdapter(operationAdapter);
        mDSTypeSpinner.setVisibility(View.VISIBLE);

        // set up array setting spinner
        mArraySettingSpinner = (Spinner) view.findViewById(R.id.arraySettingSpinner);
        ArrayAdapter<CharSequence> arraySettingAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.array_setting, R.layout.spinner_item);
        arraySettingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mArraySettingSpinner.setAdapter(arraySettingAdapter);
        mArraySettingSpinner.setVisibility(View.INVISIBLE);
    }

    /**
     * Set radio group listener for the type of test the user want to run
     * (data structure or sort algorithms) to show the spinners accordingly to
     * the selected radio button.
     * @param view the associated view with the attached radio group.
     */
    private void setRadioGroupListener(View view) {
        mRadioGroup = (RadioGroup) view.findViewById(R.id.runType);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.dataStructuresRB) {
                    mDSTypeSpinner.setVisibility(View.VISIBLE);
                    mArraySettingSpinner.setVisibility(View.INVISIBLE);
                } else if (checkedId == R.id.arraySortingAlgorithmsRB) {
                    mArraySettingSpinner.setVisibility(View.VISIBLE);
                    mDSTypeSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    /**
     * Set up the run button to start the runtime comparison tests.
     * @param view the associated view with the run button.
     */
    public void setRunButton(View view) {
        Button runButton = (Button) view.findViewById(R.id.runButton);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTestProcess();
            }
        });
    }

    /**
     * Helper method to start the test process with a new task, or notify
     * the user if a task is already started.
     */
    private void startTestProcess() {
        int sizeInput = Integer.parseInt(mSizeSpinner.getSelectedItem().toString());
        int currentRadioId = mRadioGroup.getCheckedRadioButtonId();

        if (mCurrentTask != null && mCurrentTask.getStatus() != AsyncTask.Status.FINISHED) {
            Toast.makeText(getContext(), "Please wait, a test is currently running.", Toast.LENGTH_LONG).show();
        } else {
            mCurrentTask = new RetrieveDataTask();
            mCurrentTask.execute(sizeInput, currentRadioId);
        }
    }

    /**
     * An async task class to retrieve all the run time data and display the information
     * as a bar chart.
     */
    public class RetrieveDataTask extends AsyncTask<Integer, Void, List<IBarDataSet>> {

        /**
         * Set the progress bar to be visible before executing the task.
         */
        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        /**
         * Retrieve the data based on the selected test type (data structures or sort algorithms)
         * using the chart util class (MyChart).
         * @param params
         * @return
         */
        @Override
        protected List<IBarDataSet> doInBackground(Integer... params) {
            int sizeInput = params[0];
            mCurrentRadioButtonId = params[1];
            if (mCurrentRadioButtonId == R.id.dataStructuresRB) {
                return mChartUtil.getDataStructuresTime(sizeInput, mDSTypeSpinner);
            } else if (mCurrentRadioButtonId == R.id.arraySortingAlgorithmsRB) {
                return mChartUtil.getSortAlgorithmsTime(sizeInput, mArraySettingSpinner);
            } else {
                return null;
            }
        }

        /**
         * Set progressbar to be invisible and display the bar chart if its list of data sets is
         * not null.
         * @param dataSets a list of bar data sets retrieved from chart util (MyChart)
         *                 compute runtime methods.
         */
        @Override
        protected void onPostExecute(List<IBarDataSet> dataSets) {
            mProgressBar.setVisibility(View.INVISIBLE);
            if (dataSets != null) {
                mChartUtil.display(mChart, dataSets, chooseLabels());
            }
        }
    }

    /**
     * Helper method to get the x-axis labels based on the current selected test setting.
     * @return a string array of x-axis labels.
     */
    private String[] chooseLabels() {
        if (mCurrentRadioButtonId == R.id.dataStructuresRB) {
            String dataStructureType = mDSTypeSpinner.getSelectedItem().toString();
            if (dataStructureType.equalsIgnoreCase("Sets")) {
                return new String[] {"Search", "Insertion", "Deletion"};
            } else if (dataStructureType.equalsIgnoreCase("Lists")) {
                return new String[] {"Access", "Search", "Random Insertion",
                        "Sequential Insertion", "Random Deletion", "Sequential Deletion"};
            } else {
                return new String[] {"Access", "Search", "Insertion", "Deletion"};
            }
        } else if (mCurrentRadioButtonId == R.id.arraySortingAlgorithmsRB) {
            return new String[] {"Bubble sort", "Merge sort", "Insertion sort",
                    "Selection sort", "Quicksort"};
        } else {
            return null;
        }
    }
}
