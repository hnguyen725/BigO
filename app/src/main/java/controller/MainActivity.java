package controller;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.hieunguyen725.bigo.R;

import slidingtab.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {
    private static final CharSequence TAB_TITLES[] = {"Data Structures", "Sort Algorithms"};
    private static final int NUMBER_OF_TABS = 2;

    private ViewPager mViewPager;
    private FragmentStatePagerAdapter mFragmentStatePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager(), TAB_TITLES, NUMBER_OF_TABS);
        mViewPager = (ViewPager) findViewById(R.id.pager);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void refreshOnClick(View v) {
        DataStructureFragment dataStructureFragment =
                (DataStructureFragment) mFragmentStatePagerAdapter.instantiateItem(mViewPager, 0);
        SortAlgorithmFragment sortAlgorithmFragment =
                (SortAlgorithmFragment) mFragmentStatePagerAdapter.instantiateItem(mViewPager, 1);
        if (dataStructureFragment != null && dataStructureFragment.isVisible() && mViewPager.getCurrentItem() == 0) {
            dataStructureFragment.collapseAll();
        } else if (sortAlgorithmFragment != null && sortAlgorithmFragment.isVisible() && mViewPager.getCurrentItem() == 1) {
            sortAlgorithmFragment.collapseAll();
        }

    }
}
