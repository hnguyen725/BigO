package model;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import hieunguyen725.bigo.R;

/**
 * Created by hieunguyen725 on 12/25/2015.
 */
public class SortAlgorithmChildViewHolder extends ChildViewHolder {
    public TextView mBestTime;
    public TextView mAverageTime;
    public TextView mWorstTime;
    public TextView mWorstSpace;

    public SortAlgorithmChildViewHolder(View itemView) {
        super(itemView);
        mBestTime = (TextView) itemView.findViewById(R.id.sa_best_time);
        mAverageTime = (TextView) itemView.findViewById(R.id.sa_average_time);
        mWorstTime = (TextView) itemView.findViewById(R.id.sa_worst_time);
        mWorstSpace = (TextView) itemView.findViewById(R.id.sa_worst_space);
    }
}
