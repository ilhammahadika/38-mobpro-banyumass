package com.example.ilham.push.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilham.push.MainActivity;
import com.example.ilham.push.R;
import com.example.ilham.push.adapter.GmailAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllInboxFragment extends Fragment {

    RecyclerView recyclerView;
    GmailAdapter gmailAdapter;
    public static final String[] data = {"Cupcake", "Donut", "Eclair",
            "Froyo", "Gingerbread", "Honeycomb",
            "Icecream Sandwich", "Jelly Bean", "Kitkat", "Lollipop"};


    public AllInboxFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_inbox, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("All Inboxes");

        recyclerView = (RecyclerView) view.findViewById(R.id.all_inbox_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation()));

        List<String> listData = new ArrayList<String>();
        for (int i = 0; i < data.length; i++) {
            listData.add(data[i]);
        }
        gmailAdapter = new GmailAdapter(getActivity(), listData);
        recyclerView.setAdapter(gmailAdapter);
        return view;
    }

}
