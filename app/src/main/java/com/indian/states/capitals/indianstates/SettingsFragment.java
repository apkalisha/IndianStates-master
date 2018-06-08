package com.indian.states.capitals.indianstates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingsFragment extends Fragment {

    View settingsFragment;

    public static SettingsFragment newInstance() {
        SettingsFragment settingsFragment = new SettingsFragment();

        return settingsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        settingsFragment = inflater.inflate(R.layout.fragment_setting,container,false);
        return settingsFragment;
    }
}
