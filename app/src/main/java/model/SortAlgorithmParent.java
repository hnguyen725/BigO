package model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by hieunguyen725 on 12/23/2015.
 */
public class SortAlgorithmParent implements ParentListItem {
    private String mName;
    private List<Object> mChildrenList;

    public SortAlgorithmParent(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }


    @Override
    public List<?> getChildItemList() {
        return mChildrenList;
    }

    public void setChildrenList(List<Object> mChildrenList) {
        this.mChildrenList = mChildrenList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
