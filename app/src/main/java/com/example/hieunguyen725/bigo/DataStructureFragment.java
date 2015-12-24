package com.example.hieunguyen725.bigo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import application.MyApplication;


public class DataStructureFragment extends Fragment {
    private  static final String TAG = "DataStructureFragment";

    private RecyclerView mRecyclerView;

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

        List<ParentObject> dataStructureParents = ((MyApplication)
                getActivity().getApplication()).getAllDataStructure();
        DataStructureExpandableAdapter expandableAdapter  =
                new DataStructureExpandableAdapter(getActivity(), dataStructureParents);
        expandableAdapter.setParentClickableViewAnimationDefaultDuration();
        expandableAdapter.setParentAndIconExpandOnClick(true);
        expandableAdapter.onRestoreInstanceState(savedInstanceState);

        mRecyclerView.setAdapter(expandableAdapter);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((DataStructureExpandableAdapter) mRecyclerView.getAdapter()).onSaveInstanceState(outState);
    }
}
