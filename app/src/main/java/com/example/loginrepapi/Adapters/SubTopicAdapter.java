package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrepapi.Interfaces.ClickInterface;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.SubTopicData;
import com.example.loginrepapi.Responses.TopicData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SubTopicAdapter extends RecyclerView.Adapter<SubTopicAdapter.SubTopicViewHolder> {
    public String url="https://s3-ap-south-1.amazonaws.com/dev.baashaa/data/content/bs_image/";
    ClickInterface clickInterface;
    private ArrayList<SubTopicData> data;
    private Context context;

    public SubTopicAdapter(ArrayList<SubTopicData> data, Context context,ClickInterface clickInterface) {
        this.data = data;
        this.context = context;
        this.clickInterface=clickInterface;
    }


    @NonNull
    @Override
    public SubTopicAdapter.SubTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.subtopic_rv_items, parent, false);

        return new SubTopicAdapter.SubTopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubTopicAdapter.SubTopicViewHolder holder, final int position) {
        holder.content.setText(data.get(position).getContent());
        Picasso.with(context).load(url + data.get(position).getImg() + ".png").into(holder.subtopic_image);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInterface.click(data.get(position).getBase_content_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SubTopicViewHolder extends RecyclerView.ViewHolder {
        ImageView subtopic_image;
        TextView content;
        CardView card;
        public SubTopicViewHolder(@NonNull View itemView) {
            super(itemView);
            content=itemView.findViewById(R.id.subtview);
            subtopic_image=itemView.findViewById(R.id.topic_image1);
            card = itemView.findViewById(R.id.subtopicview);

        }
    }
}
