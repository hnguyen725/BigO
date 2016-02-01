package controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hieunguyen725 on 12/23/2015.
 */
public class ViewPagerAdapter  extends FragmentStatePagerAdapter {
    CharSequence titles[];
    int numOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence titles[], int numOfTabs) {
        super(fm);
        this.titles = titles;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DataStructureFragment();
        } else if (position == 1) {
            return new SortAlgorithmFragment();
        } else {
            return new RunTimeComparisonFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
