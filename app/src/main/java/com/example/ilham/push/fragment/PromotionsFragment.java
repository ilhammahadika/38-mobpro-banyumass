package com.example.ilham.push.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilham.push.MainActivity;
import com.example.ilham.push.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromotionsFragment extends Fragment {


    public PromotionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promotions, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Promotions");
        return view;
    }

}
