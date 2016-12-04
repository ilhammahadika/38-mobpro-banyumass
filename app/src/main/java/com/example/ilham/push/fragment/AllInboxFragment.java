package com.example.ilham.push.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.ilham.push.database.DataContract;
import com.example.ilham.push.database.DataHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllInboxFragment extends Fragment {

    RecyclerView recyclerView;
    GmailAdapter gmailAdapter;
    ArrayList<String> strings = new ArrayList<>();

    DataHelper helper;
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
        helper = new DataHelper(getActivity());
        getData();
        gmailAdapter = new GmailAdapter(getActivity(), strings);
        recyclerView.setAdapter(gmailAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void getData(){
        SQLiteDatabase db = helper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                DataContract._ID,
                DataContract.COLUMN_NAME_TITLE,
                DataContract.COLUMN_NAME_ALAMAT,
                DataContract.COLUMN_NAME_HARGA,
                DataContract.COLUMN_NAME_TELP
        };

/*// Filter results WHERE "title" = 'My Title'
        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";*/

        Cursor c = db.query(
                DataContract.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        c.moveToFirst();

        for (int i = 0; i < c.getCount(); i++) {
            strings.add(c.getString(c.getColumnIndex(DataContract.COLUMN_NAME_TITLE)));
            c.moveToNext();
        }
    }


}
