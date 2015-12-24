package model;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

/**
 * Created by hieunguyen725 on 12/23/2015.
 */
public class DataStructureParent implements ParentObject {
    private String mName;
    private List<Object> mChildrenList;

    public DataStructureParent(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mChildrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mChildrenList = list;
    }

    @Override
    public String toString() {
        return "DataStructureParent{" +
                "mName='" + mName + '\'' +
                ", mChildrenList=" + mChildrenList +
                '}';
    }
}
