package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.TopicData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

private ImageView topic_image;
private ImageView topic_arrow;
private ArrayList<TopicData> data;
public String url="https://s3-ap-south-1.amazonaws.com/dev.baashaa/data/content/bs_image/";
    private Context context;
    public TopicAdapter(ArrayList<TopicData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);

        return new TopicViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.content.setText(data.get(position).getContent());
        Picasso.with(context).load(url+data.get(position).getImg()+".png").into(holder.topic_image);
        holder.llmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


       // holder.phonetics.setText(data.get(position).getPhonetics());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llmain;
        ImageView topic_image;
        TextView content;
        ImageView topic_arrow;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            content=itemView.findViewById(R.id.textView1);
            topic_image=itemView.findViewById(R.id.topic_imagee);
            topic_arrow=itemView.findViewById(R.id.topic_arrow);
            llmain = itemView.findViewById(R.id.llmain);

        }
    }
}
