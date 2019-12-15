package com.example.ud6_ejemplo3;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterFragments extends FragmentPagerAdapter {
    private Context contexto;

    public AdapterFragments(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        contexto = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Fragment1();
        } else if (position == 1) {
            return new Fragment2();
        } else {
            return new Fragment3();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return contexto.getString(R.string.fragment1);
        } else if (position == 1) {
            return contexto.getString(R.string.fragment2);
        } else {
            return contexto.getString(R.string.fragment3);
        }
    }
}
