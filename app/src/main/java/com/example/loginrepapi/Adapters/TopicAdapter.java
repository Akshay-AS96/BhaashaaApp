package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrepapi.Interfaces.ClickInterface;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.TopicData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    ClickInterface clickInterface;
    private ImageView topic_image;
    private ImageView topic_arrow;
    private ArrayList<TopicData> data;
    public String url = "https://s3-ap-south-1.amazonaws.com/dev.baashaa/data/content/bs_image/";
    private Context context;
    public boolean completed=false;
    public TopicAdapter(ArrayList<TopicData> data, Context context,ClickInterface clickInterface) {
        this.data = data;
        this.context = context;
        this.clickInterface=clickInterface;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);

        return new TopicViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, final int position) {
       /* int status1 = (data.get(position).getCompleted());
        int status2=holder.getAdapterPosition();*/
       /* if (status1==0&&status2==0)*/ {
            holder.content.setText(data.get(position).getContent());
            Picasso.with(context).load(url + data.get(position).getImg() + ".png").into(holder.topic_image);

            holder.llmain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickInterface.click(data.get(position).getBase_content_id());
                }
            });
        }
        /*else {
            holder.llmain.setClickable(false);
      holder.content.setText(data.get(position).getContent());
            Picasso.with(context).load(url + data.get(position).getImg() + ".png").into(holder.topic_image);
            holder.llmain.setEnabled(false);



        }*/
    }

    @Override
    public
int getItemCount() {
        return data.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llmain;
        ImageView topic_image;
        TextView content;
        ImageView topic_arrow;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.textView1);
            topic_image = itemView.findViewById(R.id.topic_imagee);
            topic_arrow = itemView.findViewById(R.id.topic_arrow);
            llmain = itemView.findViewById(R.id.llmain);

        }
    }



}
