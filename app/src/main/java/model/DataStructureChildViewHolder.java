package model;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import hieunguyen725.bigo.R;

/**
 * Created by hieunguyen725 on 12/24/2015.
 */
public class DataStructureChildViewHolder extends ChildViewHolder {
    public TextView mAverageAccess;
    public TextView mAverageSearch;
    public TextView mAverageInsertion;
    public TextView mAverageDeletion;
    public TextView mWorstAccess;
    public TextView mWorstSearch;
    public TextView mWorstInsertion;
    public TextView mWorstDeletion;
    public TextView mWorstSpace;

    public DataStructureChildViewHolder(View itemView) {
        super(itemView);
        mAverageAccess = (TextView) itemView.findViewById(R.id.average_access);
        mAverageSearch = (TextView) itemView.findViewById(R.id.average_search);
        mAverageInsertion = (TextView) itemView.findViewById(R.id.average_insertion);
        mAverageDeletion = (TextView) itemView.findViewById(R.id.average_deletion);
        mWorstAccess = (TextView) itemView.findViewById(R.id.worst_access);
        mWorstSearch = (TextView) itemView.findViewById(R.id.worst_search);
        mWorstInsertion = (TextView) itemView.findViewById(R.id.worst_insertion);
        mWorstDeletion = (TextView) itemView.findViewById(R.id.worst_deletion);
        mWorstSpace = (TextView) itemView.findViewById(R.id.worst_space);
    }
}
