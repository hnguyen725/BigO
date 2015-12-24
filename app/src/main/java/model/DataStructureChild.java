package model;

/**
 * Created by hieunguyen725 on 12/24/2015.
 */
public class DataStructureChild {
    private String mAverageAccess;
    private String mAverageSearch;
    private String mAverageInsertion;
    private String mAverageDeletion;
    private String mWorstAccess;
    private String mWorstSearch;
    private String mWorstInsertion;
    private String mWorstDeletion;
    private String mWorstSpace;

    public DataStructureChild(String mAverageAccess, String mWorstSpace, String mAverageSearch,
                              String mAverageInsertion, String mAverageDeletion, String mWorstAccess,
                              String mWorstSearch, String mWorstInsertion, String mWorstDeletion) {
        this.mAverageAccess = mAverageAccess;
        this.mWorstSpace = mWorstSpace;
        this.mAverageSearch = mAverageSearch;
        this.mAverageInsertion = mAverageInsertion;
        this.mAverageDeletion = mAverageDeletion;
        this.mWorstAccess = mWorstAccess;
        this.mWorstSearch = mWorstSearch;
        this.mWorstInsertion = mWorstInsertion;
        this.mWorstDeletion = mWorstDeletion;
    }

    public String getAverageAccess() {
        return mAverageAccess;
    }

    public String getAverageSearch() {
        return mAverageSearch;
    }

    public String getAverageInsertion() {
        return mAverageInsertion;
    }

    public String getAverageDeletion() {
        return mAverageDeletion;
    }

    public String getWorstAccess() {
        return mWorstAccess;
    }

    public String getWorstSearch() {
        return mWorstSearch;
    }

    public String getWorstInsertion() {
        return mWorstInsertion;
    }

    public String getWorstDeletion() {
        return mWorstDeletion;
    }

    public String getWorstSpace() {
        return mWorstSpace;
    }

    @Override
    public String toString() {
        return "DataStructureChild{" +
                "mAverageAccess='" + mAverageAccess + '\'' +
                ", mAverageSearch='" + mAverageSearch + '\'' +
                ", mAverageInsertion='" + mAverageInsertion + '\'' +
                ", mAverageDeletion='" + mAverageDeletion + '\'' +
                ", mWorstAccess='" + mWorstAccess + '\'' +
                ", mWorstSearch='" + mWorstSearch + '\'' +
                ", mWorstInsertion='" + mWorstInsertion + '\'' +
                ", mWorstDeletion='" + mWorstDeletion + '\'' +
                ", mWorstSpace='" + mWorstSpace + '\'' +
                '}';
    }
}
