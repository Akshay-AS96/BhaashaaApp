package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.TopicData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ActivityTopicAdapter extends RecyclerView.Adapter<ActivityTopicAdapter.ActivityTopicViewHolder> {

    private ImageView topic_image;
    private ImageView topic_arrow;
    public String url="https://s3-ap-south-1.amazonaws.com/dev.baashaa/data/content/bs_image/";
    private ArrayList<TopicData> data;
    private Context context;


    public ActivityTopicAdapter(ArrayList<TopicData> data,Context context) {
        this.data = data;
        this.context = context;
    }



    @NonNull
    @Override
    public ActivityTopicAdapter.ActivityTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.activity_rv_items, parent, false);

        return new ActivityTopicAdapter.ActivityTopicViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ActivityTopicViewHolder holder, int position) {
        holder.content.setText(data.get(position).getContent());
         Picasso.with(context).load(url+data.get(position).getImg()+".png").into(holder.topic_image);

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ActivityTopicViewHolder extends RecyclerView.ViewHolder {
        ImageView topic_image;
        TextView content;

        public ActivityTopicViewHolder(@NonNull View itemView) {
            super(itemView);
            content=itemView.findViewById(R.id.tv_item);
            topic_image=itemView.findViewById(R.id.iv_item);



        }
    }
}
