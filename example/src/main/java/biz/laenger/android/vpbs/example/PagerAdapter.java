package biz.laenger.android.vpbs.example;

import android.content.Context;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import biz.laenger.android.vpbs.example.fragments.NestedScrollFragment;
import biz.laenger.android.vpbs.example.fragments.RecyclerFragment;
import biz.laenger.android.vpbs.example.fragments.ViewPagerFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public enum TabItem {
        RECYCLER(RecyclerFragment.class, R.string.tab_recycler),
        NESTED_SCROLL(NestedScrollFragment.class, R.string.tab_nested_scroll),
        VIEW_PAGER(ViewPagerFragment.class, R.string.tab_view_pager);

        private final Class<? extends Fragment> fragmentClass;
        private final int titleResId;

        TabItem(Class<? extends Fragment> fragmentClass, @StringRes int titleResId) {
            this.fragmentClass = fragmentClass;
            this.titleResId = titleResId;
        }
    }

    private final TabItem[] tabItems;
    private final Context context;

    public PagerAdapter(FragmentManager fragmentManager, Context context, TabItem... tabItems) {
        super(fragmentManager);
        this.context = context;
        this.tabItems = tabItems;
    }

    @Override
    public Fragment getItem(int position) {
        return newInstance(tabItems[position].fragmentClass);
    }

    private Fragment newInstance(Class<? extends Fragment> fragmentClass) {
        try {
            return fragmentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("fragment must have public no-arg constructor: " + fragmentClass.getName(), e);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(tabItems[position].titleResId);
    }

    @Override
    public int getCount() {
        return tabItems.length;
    }

}
