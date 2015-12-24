package com.example.hieunguyen725.bigo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import model.DataStructureChild;
import model.DataStructureParent;

/**
 * Created by hieunguyen725 on 12/24/2015.
 */
public class DataStructureExpandableAdapter extends
        ExpandableRecyclerAdapter<DataStructureParentViewHolder, DataStructureChildViewHolder> {

    private LayoutInflater mInflater;

    public DataStructureExpandableAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public DataStructureParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.list_item_data_structure_parent, viewGroup, false);
        return new DataStructureParentViewHolder(view);
    }

    @Override
    public DataStructureChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.list_item_data_structure_child, viewGroup, false);
        return new DataStructureChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(DataStructureParentViewHolder dataStructureParentViewHolder, int i, Object parentObject) {
        DataStructureParent dataStructureParent = (DataStructureParent) parentObject;
        dataStructureParentViewHolder.mDataStructureName.setText(dataStructureParent.getName());
    }

    @Override
    public void onBindChildViewHolder(DataStructureChildViewHolder dataStructureChildViewHolder, int i, Object parentObject) {
        DataStructureChild dataStructureChild = (DataStructureChild) parentObject;
        dataStructureChildViewHolder.mOperationName.setText(dataStructureChild.getAverageAccess());
    }
}
