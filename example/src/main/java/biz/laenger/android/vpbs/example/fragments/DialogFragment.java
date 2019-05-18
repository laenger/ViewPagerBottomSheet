package biz.laenger.android.vpbs.example.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import biz.laenger.android.vpbs.BottomSheetUtils;
import biz.laenger.android.vpbs.ViewPagerBottomSheetDialogFragment;
import biz.laenger.android.vpbs.example.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogFragment extends ViewPagerBottomSheetDialogFragment {

    @BindView(R.id.bottom_sheet_toolbar) Toolbar bottomSheetToolbar;
    @BindView(R.id.bottom_sheet_tabs) TabLayout bottomSheetTabLayout;
    @BindView(R.id.bottom_sheet_viewpager) ViewPager bottomSheetViewPager;

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        final View contentView = View.inflate(getContext(), R.layout.dialog_bottom_sheet, null);
        ButterKnife.bind(this, contentView);
        dialog.setContentView(contentView);

        setupViewPager();
    }

    private void setupViewPager() {
        bottomSheetToolbar.setTitle(R.string.action_bottom_sheet_dialog);
        bottomSheetViewPager.setOffscreenPageLimit(1);
        bottomSheetViewPager.setAdapter(new SimplePagerAdapter(getContext()));
        bottomSheetTabLayout.setupWithViewPager(bottomSheetViewPager);
        BottomSheetUtils.setupViewPager(bottomSheetViewPager);
    }

    static class SimplePagerAdapter extends PagerAdapter {

        private final Context context;

        SimplePagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return context.getString(R.string.tab_nested_scroll) + " " + String.valueOf(position + 1);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return object == view;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            final View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_nested_scroll, container, false);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

    }

}
