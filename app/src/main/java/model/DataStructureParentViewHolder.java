package model;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.hieunguyen725.bigo.R;

/**
 * Created by hieunguyen725 on 12/24/2015.
 */
public class DataStructureParentViewHolder extends ParentViewHolder {
    public TextView mDataStructureName;

    public DataStructureParentViewHolder(View itemView) {
        super(itemView);

        mDataStructureName = (TextView)
                itemView.findViewById(R.id.list_item_data_structure_parent_name_tv);
    }
}
