package controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.hieunguyen725.bigo.R;

/**
 * Created by hieunguyen725 on 1/15/2016.
 */
public class RunTimeComparisonFragment extends Fragment {
    public final String TAG = "RunTimeComparisonFragment";

    private Spinner sizeSpinner;
    private Spinner dsTypeSpinner;
    private Spinner arraySettingSpinner;

    private RadioGroup radioGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_run_time_comparison, container, false);

        setUpSpinners(view);
        setRadioGroupListener(view);

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
}
