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

import application.MyApplication;
import controller.expandablerecyclerview.DataStructureExpandableAdapter;


public class DataStructureFragment extends Fragment {
    public static final String TAG = "DataStructureFragment";

    private RecyclerView mRecyclerView;
    public DataStructureExpandableAdapter mExpandableAdapter;

    public DataStructureFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_data_structure, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.data_structure_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<ParentListItem> dataStructureParents = ((MyApplication)
                getActivity().getApplication()).getAllDataStructure();
        mExpandableAdapter  =
                new DataStructureExpandableAdapter(getActivity(), dataStructureParents);
        mExpandableAdapter.onRestoreInstanceState(savedInstanceState);

        mRecyclerView.setAdapter(mExpandableAdapter);
        
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((DataStructureExpandableAdapter) mRecyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    public DataStructureExpandableAdapter getExpandableAdapter() {
        return mExpandableAdapter;
    }

    public void collapseAll() {
        mExpandableAdapter.collapseAllParents();
    }
}
