package com.example.ilham.push.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.example.ilham.push.R;
import com.example.ilham.push.database.DataContract;

/**
 * Created by ilham on 04/12/2016.
 */

public class adapterList extends ResourceCursorAdapter {
    public adapterList(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, layout, c, autoRequery);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        GmailVH gmailVH = new GmailVH(view);
        gmailVH.title.setText(cursor.getString(cursor.getColumnIndex(DataContract.COLUMN_NAME_TITLE)));
    }

    class GmailVH{
        TextView header;
        TextView title;
        TextView email;
        ImageView letter;
        RelativeLayout relativeLayout;

        public GmailVH(View itemView) {
            header = (TextView) itemView.findViewById(R.id.gmailitem_header);
            title = (TextView) itemView.findViewById(R.id.gmailitem_title);
            email = (TextView) itemView.findViewById(R.id.gmailitem_email);
            letter = (ImageView) itemView.findViewById(R.id.gmailitem_letter);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rootView);
        }
    }
}
