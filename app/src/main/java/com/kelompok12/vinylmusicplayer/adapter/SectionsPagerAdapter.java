package com.kelompok12.vinylmusicplayer.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kelompok12.vinylmusicplayer.R;
import com.kelompok12.vinylmusicplayer.fragment.AlbumsListFragment;
import com.kelompok12.vinylmusicplayer.fragment.ArtistsListFragment;
import com.kelompok12.vinylmusicplayer.fragment.FoldersListFragment;
import com.kelompok12.vinylmusicplayer.fragment.TracksListFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tracks, R.string.albums, R.string.artists, R.string.folders};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0:
                frag = new TracksListFragment();
                break;
            case 1:
                frag = new AlbumsListFragment();
                break;
            case 2:
                frag = new ArtistsListFragment();
                break;
            case 3:
                frag = new FoldersListFragment();
                break;
        }
        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}