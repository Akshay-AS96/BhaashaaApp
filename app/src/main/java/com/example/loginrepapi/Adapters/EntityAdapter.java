package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.media.MediaPlayer;
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
import com.example.loginrepapi.SampleMediaPlayer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.EntityViewHolder> {
    private ArrayList<EntityData> data;
    public String url = "https://s3-ap-south-1.amazonaws.com/dev.baashaa/data/content/bs_image/";
    SampleMediaPlayer sampleMediaPlayer;
    ClickInterface clickInterface;
    private Context context;

    public EntityAdapter(ArrayList<EntityData> data, ClickInterface clickInterface, Context context) {
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
        sampleMediaPlayer=new SampleMediaPlayer();
        final String id = data.get(position).getSource().getVoice();
        final String did=data.get(position).getDestination().getVoice();
        final String sourceLangCode = data.get(position).getSourcelangcode();
        final String destinationLangCode = data.get(position).getDestination_langcode();
        final String voice = "https://s3.ap-south-1.amazonaws.com/dev.baashaa/data/content/" + sourceLangCode + "_voice/" + id.trim() + ".mp3";
        final String dvoice = "https://s3.ap-south-1.amazonaws.com/dev.baashaa/data/content/" + destinationLangCode + "_voice/" + did.trim() + ".mp3";

        holder.entityContent.setText(data.get(position).getContent());
        Picasso.with(context).load(url + data.get(position).getImg() + ".png").into(holder.entity_img);
        holder.voiceEntity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sampleMediaPlayer.killMediaPlayer();
                sampleMediaPlayer.playAudio(voice, dvoice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class EntityViewHolder extends RecyclerView.ViewHolder {
        ImageView entity_img;
        TextView entityContent;
        LinearLayout ll2;
        ImageButton voiceEntity;


        public EntityViewHolder(@NonNull View itemView) {
            super(itemView);
            entityContent = itemView.findViewById(R.id.entity_content);
            entity_img = itemView.findViewById(R.id.entity_img);
            ll2 = itemView.findViewById(R.id.llmain2);
            voiceEntity = itemView.findViewById(R.id.imgbtn_voice);


        }
    }
}
