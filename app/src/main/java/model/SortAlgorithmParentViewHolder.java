package model;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import hieunguyen725.bigo.R;

/**
 * Created by hieunguyen725 on 12/25/2015.
 */
public class SortAlgorithmParentViewHolder extends ParentViewHolder {
    public TextView mSortAlgorithmName;

    public SortAlgorithmParentViewHolder(View itemView) {
        super(itemView);

        mSortAlgorithmName = (TextView)
                itemView.findViewById(R.id.list_item_sort_algorithm_parent_name_tv);
    }
}
