package controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

import data.ApplicationData;
import expandablerecyclerview.SortAlgorithmExpandableAdapter;
import hieunguyen725.bigo.R;

/**
 * The fragment that contains all the runtime complexity for different
 * sort algorithms.
 */
public class SortAlgorithmFragment extends Fragment {
    public static final String TAG = "SortAlgorithmFragment";

    private RecyclerView mRecyclerView;
    private SortAlgorithmExpandableAdapter mExpandableAdapter;

    public SortAlgorithmFragment() {
        // Required empty public constructor
    }

    /**
     * onCreate method.
     * @param savedInstanceState the previous saved state bundle.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Create a view with a list of sort algorithms as parent items and their runtime
     * as the children using recycler view.
     * @param inflater layout inflater
     * @param container the fragment's view group container
     * @param savedInstanceState the previous saved instance bundle.
     * @return the view to be created.
     */
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

    /**
     * Save the state information of the view hierarchy.
     * @param outState the state to be saved.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((SortAlgorithmExpandableAdapter) mRecyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    /**
     * Return the current recycler view expandable adapter.
     * @return the recycler view expandable adapter.
     */
    public SortAlgorithmExpandableAdapter getExpandableAdapter() {
        return mExpandableAdapter;
    }

    /**
     * Collapse all the parents and hide their children in the recycler view.
     */
    public void collapseAll() {
        mExpandableAdapter.collapseAllParents();
    }
}
