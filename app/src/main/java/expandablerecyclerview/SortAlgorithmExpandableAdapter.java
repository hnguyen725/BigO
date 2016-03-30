package expandablerecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

import hieunguyen725.bigo.R;
import model.SortAlgorithmChild;
import model.SortAlgorithmChildViewHolder;
import model.SortAlgorithmParent;
import model.SortAlgorithmParentViewHolder;

/**
 * Created by hieunguyen725 on 12/25/2015.
 */
public class SortAlgorithmExpandableAdapter extends
        ExpandableRecyclerAdapter<SortAlgorithmParentViewHolder, SortAlgorithmChildViewHolder> {

    private LayoutInflater mInflater;

    public SortAlgorithmExpandableAdapter(Context context, List<ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public SortAlgorithmParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = mInflater.inflate(R.layout.list_item_sort_algorithm_parent, parentViewGroup, false);
        return new SortAlgorithmParentViewHolder(view);
    }

    @Override
    public SortAlgorithmChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = mInflater.inflate(R.layout.list_item_sort_algorithm_child, childViewGroup, false);
        return new SortAlgorithmChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(SortAlgorithmParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        SortAlgorithmParent sortAlgorithmParent = (SortAlgorithmParent) parentListItem;
        parentViewHolder.mSortAlgorithmName.setText(sortAlgorithmParent.getName());
    }

    @Override
    public void onBindChildViewHolder(SortAlgorithmChildViewHolder childViewHolder, int position, Object childListItem) {
        SortAlgorithmChild sortAlgorithmChild = (SortAlgorithmChild) childListItem;
        childViewHolder.mBestTime.setText(Html.fromHtml(("O(" + sortAlgorithmChild.getBestTime() + ")")));
        childViewHolder.mAverageTime.setText(Html.fromHtml(("O(" + sortAlgorithmChild.getAverageTime() + ")")));
        childViewHolder.mWorstTime.setText(Html.fromHtml(("O(" + sortAlgorithmChild.getWorstTime() + ")")));
        childViewHolder.mWorstSpace.setText(Html.fromHtml(("O(" + sortAlgorithmChild.getWorstSpace() + ")")));
        setComplexityColors(sortAlgorithmChild, childViewHolder);
    }

    public void setComplexityColors(SortAlgorithmChild sortAlgorithmChild, SortAlgorithmChildViewHolder childViewHolder) {
        childViewHolder.mBestTime.setBackgroundColor(Color.parseColor(getColor(sortAlgorithmChild.getBestTime())));
        childViewHolder.mAverageTime.setBackgroundColor(Color.parseColor(getColor(sortAlgorithmChild.getAverageTime())));
        childViewHolder.mWorstTime.setBackgroundColor(Color.parseColor(getColor(sortAlgorithmChild.getWorstTime())));
        childViewHolder.mWorstSpace.setBackgroundColor(Color.parseColor(getColor(sortAlgorithmChild.getWorstSpace())));
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
