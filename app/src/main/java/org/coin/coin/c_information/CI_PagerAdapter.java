package org.coin.coin.c_information;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.coin.coin.information.I_Fragment1;
import org.coin.coin.information.I_Fragment2;
import org.coin.coin.information.I_Fragment3;
import org.coin.coin.information.I_Fragment4;
import org.coin.coin.information.I_Fragment5;

public class CI_PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs; //tab의 갯수

    public CI_PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CI_Fragment1 ci_tab1 = new CI_Fragment1();
                return ci_tab1;
            case 1:
                CI_Fragment2 ci_tab2 = new CI_Fragment2();
                return ci_tab2;
            case 2:
                CI_Fragment3 ci_tab3 = new CI_Fragment3();
                return ci_tab3;
            case 3:
                CI_Fragment4 ci_tab4 = new CI_Fragment4();
                return ci_tab4;
            case 4:
                CI_Fragment5 ci_tab5 = new CI_Fragment5();
                return ci_tab5;


            default:
                return null;
        }
        //return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
