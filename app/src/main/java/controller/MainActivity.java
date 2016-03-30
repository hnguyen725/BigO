package controller;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import hieunguyen725.bigo.R;

import slidingtab.SlidingTabLayout;

/**
 * The main activity of the application which holds all three main fragments
 * of data structures, sort algorithms, and run time fragment.
 */
public class MainActivity extends AppCompatActivity {
    private static final CharSequence TAB_TITLES[]
            = {"Data Structures", "Sort Algorithms", "Run Time Comparisons"};
    private static final int NUMBER_OF_TABS = 3;

    private ViewPager mViewPager;
    private FragmentStatePagerAdapter mFragmentStatePagerAdapter;

    /**
     * onCreate method, setting the custom toolbar, viewpager and the
     * fragment state pager adapter to hold the main fragments as a tab layout.
     * @param savedInstanceState the saved state bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager(), TAB_TITLES, NUMBER_OF_TABS);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(viewPagerAdapter);

        mFragmentStatePagerAdapter = (FragmentStatePagerAdapter) mViewPager.getAdapter();

        SlidingTabLayout tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return ContextCompat.getColor(getApplicationContext(), R.color.tabsScrollColor);
            }
        });

        tabs.setViewPager(mViewPager);
    }

    /**
     * Inflate the applications's menu.
     * @param menu the menu to be inflated with.
     * @return true once inflated the menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Select an option from the application menu given a menu item.
     * @param item the selected menu item.
     * @return true when the selected menu item existed
     *         and its action is executed.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.application_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String aboutMessage = "Big-O reference - www.bigocheatsheet.com \n"
                    + "Apache License 2.0 - PagerSlidingTabStrip\n"
                    + "Apache License 2.0 - MPAndroidChart";
            builder.setMessage(aboutMessage);

            AlertDialog alert = builder.create();
            alert.setTitle("About");
            alert.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Refresh button on click, close all the children views from the recycler view.
     * @param v the associated view widget with the on click action.
     */
    public void refreshOnClick(View v) {
        DataStructureFragment dataStructureFragment =
                (DataStructureFragment) mFragmentStatePagerAdapter.instantiateItem(mViewPager, 0);
        SortAlgorithmFragment sortAlgorithmFragment =
                (SortAlgorithmFragment) mFragmentStatePagerAdapter.instantiateItem(mViewPager, 1);
        if (dataStructureFragment != null && dataStructureFragment.isVisible()
                && mViewPager.getCurrentItem() == 0) {
            dataStructureFragment.collapseAll();
        } else if (sortAlgorithmFragment != null && sortAlgorithmFragment.isVisible()
                && mViewPager.getCurrentItem() == 1) {
            sortAlgorithmFragment.collapseAll();
        }

    }
}
