package com.gmail.norwicaksana.aplikasi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Student on 17/12/2017.
 */

public class PagerAdapter2 extends FragmentStatePagerAdapter{

    int mNoOfTabs;
    public PagerAdapter2(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                TiFragment ti = new TiFragment();
                return ti;
            case 1:
                SiFragment si = new SiFragment();
                return  si;
            case 2:
                MiFragment mi = new MiFragment();
                return  mi;
            case 3:
                TkFragment tk = new TkFragment();
                return  tk;
            case 4:
                KaFragment ka = new KaFragment();
                return  ka;

            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
