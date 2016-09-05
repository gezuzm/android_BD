package com.example.gezuzm.imagencorporativa.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mauricio on 28/08/16.
 */
// clase CREADA
public class PageAdapter extends FragmentPagerAdapter {

    // variable para los n fragments
    private ArrayList<Fragment> fragments;

    // creados automaticos
    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;         // añadida
    }

    // creados automaticos
    @Override
    public Fragment getItem(int position) {
        return  fragments.get(position);
    }

    // creados automaticos
    @Override
    public int getCount() {
        return fragments.size();
    }
}
