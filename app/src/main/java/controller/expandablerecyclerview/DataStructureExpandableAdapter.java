package controller.expandablerecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.example.hieunguyen725.bigo.R;

import java.util.List;

import model.DataStructureChild;
import model.DataStructureChildViewHolder;
import model.DataStructureParent;
import model.DataStructureParentViewHolder;

/**
 * Created by hieunguyen725 on 12/24/2015.
 */
public class DataStructureExpandableAdapter extends
        ExpandableRecyclerAdapter<DataStructureParentViewHolder, DataStructureChildViewHolder> {

    private LayoutInflater mInflater;

    public DataStructureExpandableAdapter(Context context, List<ParentListItem> parentItemList) {
        super(parentItemList);
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
    public void onBindParentViewHolder(DataStructureParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        DataStructureParent dataStructureParent = (DataStructureParent) parentListItem;
        parentViewHolder.mDataStructureName.setText(dataStructureParent.getName());
    }

    @Override
    public void onBindChildViewHolder(DataStructureChildViewHolder dataStructureChildViewHolder, int i, Object childObject) {
        DataStructureChild dataStructureChild = (DataStructureChild) childObject;
        dataStructureChildViewHolder.mAverageAccess.setText(Html.fromHtml("O(" + dataStructureChild.getAverageAccess() + ")"));
        dataStructureChildViewHolder.mAverageSearch.setText(Html.fromHtml("O(" + dataStructureChild.getAverageSearch() + ")"));
        dataStructureChildViewHolder.mAverageInsertion.setText(Html.fromHtml("O(" + dataStructureChild.getAverageInsertion() + ")"));
        dataStructureChildViewHolder.mAverageDeletion.setText(Html.fromHtml("O(" + dataStructureChild.getAverageDeletion() + ")"));
        dataStructureChildViewHolder.mWorstAccess.setText(Html.fromHtml("O(" + dataStructureChild.getWorstAccess() + ")"));
        dataStructureChildViewHolder.mWorstSearch.setText(Html.fromHtml("O(" + dataStructureChild.getWorstSearch() + ")"));
        dataStructureChildViewHolder.mWorstInsertion.setText(Html.fromHtml("O(" + dataStructureChild.getWorstInsertion() + ")"));
        dataStructureChildViewHolder.mWorstDeletion.setText(Html.fromHtml("O(" + dataStructureChild.getWorstDeletion() + ")"));
        dataStructureChildViewHolder.mWorstSpace.setText(Html.fromHtml("O(" + dataStructureChild.getWorstSpace() + ")"));
        setComplexityColors(dataStructureChild, dataStructureChildViewHolder);
    }

    private void setComplexityColors(DataStructureChild dataStructureChild, DataStructureChildViewHolder dataStructureChildViewHolder) {
        dataStructureChildViewHolder.mAverageAccess.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getAverageAccess())));
        dataStructureChildViewHolder.mAverageSearch.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getAverageSearch())));
        dataStructureChildViewHolder.mAverageInsertion.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getAverageInsertion())));
        dataStructureChildViewHolder.mAverageDeletion.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getAverageDeletion())));
        dataStructureChildViewHolder.mWorstAccess.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getWorstAccess())));
        dataStructureChildViewHolder.mWorstSearch.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getWorstSearch())));
        dataStructureChildViewHolder.mWorstInsertion.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getWorstInsertion())));
        dataStructureChildViewHolder.mWorstDeletion.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getWorstDeletion())));
        dataStructureChildViewHolder.mWorstSpace.setBackgroundColor(Color.parseColor(getColor(dataStructureChild.getWorstSpace())));
    }

    private String getColor(String complexityValue) {
        if (complexityValue.equalsIgnoreCase("1")) {
            return "#4CAF50";
        } else if (complexityValue.equalsIgnoreCase("log(n)")) {
            return "#CDDC39";
        } else if (complexityValue.equalsIgnoreCase("n")) {
            return "#FFEB3B";
        } else if (complexityValue.equalsIgnoreCase("n log(n)")) {
            return "#FFC107";
        } else if (complexityValue.equalsIgnoreCase("-")) {
            return "#BDBDBD";
        } else {
            return "#E57373";
        }
    }
}
