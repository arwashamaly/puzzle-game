package com.example.puzzle_game_arwa_shamaly.Adapteres;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentVPAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments;

    public FragmentVPAdapter(@NonNull FragmentActivity fragmentActivity,
                             ArrayList<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
