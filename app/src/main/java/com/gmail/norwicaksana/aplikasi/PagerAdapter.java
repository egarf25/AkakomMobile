package com.gmail.norwicaksana.aplikasi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;
    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                ProfileFragment pf = new ProfileFragment();
                return pf;
            case 1:
                VismisFragment vismis = new VismisFragment();
                return  vismis;
            case 2:
                PejabatFragment jabat = new PejabatFragment();
                return  jabat;
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
