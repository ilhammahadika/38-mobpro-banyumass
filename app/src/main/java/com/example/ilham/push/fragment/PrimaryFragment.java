package com.example.ilham.push.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilham.push.MainActivity;
import com.example.ilham.push.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimaryFragment extends Fragment {


    public PrimaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primary, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Primary");
        return view;
    }

}
