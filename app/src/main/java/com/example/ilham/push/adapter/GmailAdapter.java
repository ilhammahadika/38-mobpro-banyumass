package com.example.ilham.push.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.ilham.push.R;


import java.util.List;

/**
 * Created by xxx on 30/10/2016.
 */

public class GmailAdapter extends RecyclerView.Adapter<GmailAdapter.GmailVH> {

    List<String> dataList;
    String letter;
    Context context;
    ColorGenerator colorGenerator = ColorGenerator.MATERIAL;

    public GmailAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public GmailVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inbox, parent, false);
        return new GmailVH(view);
    }

    @Override
    public void onBindViewHolder(GmailVH holder, int position) {
        holder.header.setText(dataList.get(position));
        holder.title.setText("Greeting From "+ holder.header.getText().toString());
        holder.email.setText("Hello Lord I am "+ holder.header.getText().toString());
        letter = String.valueOf(dataList.get(position).charAt(0));
        TextDrawable textDrawable = TextDrawable.builder()
                .buildRound(letter, colorGenerator.getRandomColor());
        holder.letter.setImageDrawable(textDrawable);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class GmailVH extends RecyclerView.ViewHolder{
        TextView header;
        TextView title;
        TextView email;
        ImageView letter;

        public GmailVH(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.gmailitem_header);
            title = (TextView) itemView.findViewById(R.id.gmailitem_title);
            email = (TextView) itemView.findViewById(R.id.gmailitem_email);
            letter = (ImageView) itemView.findViewById(R.id.gmailitem_letter);
        }
    }
}
