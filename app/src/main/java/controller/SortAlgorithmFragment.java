package controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.example.hieunguyen725.bigo.R;

import java.util.List;

import model.ApplicationData;
import expandablerecyclerview.SortAlgorithmExpandableAdapter;


public class SortAlgorithmFragment extends Fragment {

    public static final String TAG = "SortAlgorithmFragment";

    private RecyclerView mRecyclerView;
    private SortAlgorithmExpandableAdapter mExpandableAdapter;

    public SortAlgorithmFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sort_algorithm, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.sort_algorithm_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<ParentListItem> sortAlgorithmParents = ((ApplicationData)
                getActivity().getApplication()).getAllSortAlgorithm();
        mExpandableAdapter  =
                new SortAlgorithmExpandableAdapter(getActivity(), sortAlgorithmParents);
        mExpandableAdapter.onRestoreInstanceState(savedInstanceState);

        mRecyclerView.setAdapter(mExpandableAdapter);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((SortAlgorithmExpandableAdapter) mRecyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    public SortAlgorithmExpandableAdapter getExpandableAdapter() {
        return mExpandableAdapter;
    }

    public void collapseAll() {
        mExpandableAdapter.collapseAllParents();
    }
}
