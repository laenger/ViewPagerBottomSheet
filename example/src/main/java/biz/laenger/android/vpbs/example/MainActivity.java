package biz.laenger.android.vpbs.example;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import biz.laenger.android.vpbs.BottomSheetUtils;
import biz.laenger.android.vpbs.example.PagerAdapter.TabItem;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.viewpager) ViewPager viewPager;

    @BindView(R.id.bottom_sheet_toolbar) Toolbar bottomSheetToolbar;
    @BindView(R.id.bottom_sheet_tabs) TabLayout bottomSheetTabLayout;
    @BindView(R.id.bottom_sheet_viewpager) ViewPager bottomSheetViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        setupMainViewPager();
        setupBottomSheet();
    }

    private void setupMainViewPager() {
        final PagerAdapter sectionsPagerAdapter = new PagerAdapter(getSupportFragmentManager(), this, TabItem.RECYCLER, TabItem.VIEW_PAGER, TabItem.NESTED_SCROLL);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupBottomSheet() {
        bottomSheetToolbar.setTitle(R.string.bottom_sheet_title);
        final PagerAdapter sectionsPagerAdapter = new PagerAdapter(getSupportFragmentManager(), this, TabItem.NESTED_SCROLL, TabItem.VIEW_PAGER, TabItem.RECYCLER, TabItem.RECYCLER);
        bottomSheetViewPager.setOffscreenPageLimit(1);
        bottomSheetViewPager.setAdapter(sectionsPagerAdapter);
        bottomSheetTabLayout.setupWithViewPager(bottomSheetViewPager);
        BottomSheetUtils.setupViewPager(bottomSheetViewPager);
    }

}
