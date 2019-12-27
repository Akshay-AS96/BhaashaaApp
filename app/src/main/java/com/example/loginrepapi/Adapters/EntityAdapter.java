package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrepapi.Interfaces.ClickInterface;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.EntityData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.EntityViewHolder> {
    public String url="https://s3-ap-south-1.amazonaws.com/dev.baashaa/data/content/bs_image/";
    private ArrayList<EntityData> data;
    ClickInterface clickInterface;
    private Context context;

    public EntityAdapter(String url, ArrayList<EntityData> data, ClickInterface clickInterface, Context context) {
        this.url = url;
        this.data = data;
        this.clickInterface = clickInterface;
        this.context = context;
    }

    @NonNull
    @Override
    public EntityAdapter.EntityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_item_1, parent, false);

        return new EntityAdapter.EntityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntityViewHolder holder, final int position) {
   holder.entity_content.setText(data.get(position).getContent());
        Picasso.with(context).load(url + data.get(position).getImg() + ".png").into(holder.entity_img);
    holder.ll2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class EntityViewHolder extends RecyclerView.ViewHolder {
        ImageView entity_img;
        TextView entity_content;
        LinearLayout ll2;
        ImageButton voice_entity;

        public EntityViewHolder(@NonNull View itemView) {
            super(itemView);
           entity_content =itemView.findViewById(R.id.entity_content);
            entity_img=itemView.findViewById(R.id.entity_img);
            ll2 = itemView.findViewById(R.id.llmain2);
            voice_entity = itemView.findViewById(R.id.imgbtn_voice);


        }
    }
}
