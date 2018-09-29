package org.coin.coin.information;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class I_PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs; //tab의 갯수

    public I_PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                I_Fragment1 i_tab1 = new I_Fragment1();
                return i_tab1;
            case 1:
                I_Fragment2 i_tab2 = new I_Fragment2();
                return i_tab2;
            case 2:
                I_Fragment3 i_tab3 = new I_Fragment3();
                return i_tab3;
            case 3:
                I_Fragment4 i_tab4 = new I_Fragment4();
                return i_tab4;
            case 4:
                I_Fragment5 i_tab5 = new I_Fragment5();
                return i_tab5;


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
