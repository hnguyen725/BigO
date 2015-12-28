package model;

/**
 * Created by hieunguyen725 on 12/25/2015.
 */
public class SortAlgorithmChild {
    private String mBestTime;
    private String mAverageTime;
    private String mWorstTime;
    private String mWorstSpace;

    public SortAlgorithmChild(String mBestTime, String mAverageTime, String mWorstTime, String mWorstSpace) {
        this.mBestTime = mBestTime;
        this.mAverageTime = mAverageTime;
        this.mWorstTime = mWorstTime;
        this.mWorstSpace = mWorstSpace;
    }

    public String getBestTime() {
        return mBestTime;
    }

    public String getAverageTime() {
        return mAverageTime;
    }

    public String getWorstTime() {
        return mWorstTime;
    }

    public String getWorstSpace() {
        return mWorstSpace;
    }
}
