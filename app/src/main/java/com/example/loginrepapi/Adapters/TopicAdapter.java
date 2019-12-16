package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.TopicData;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    private ArrayList<TopicData> data;
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
        holder.description.setText(data.get(position).getDescription());
       // holder.phonetics.setText(data.get(position).getPhonetics());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        TextView content, description, phonetics;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            content=itemView.findViewById(R.id.textView1);
            description=itemView.findViewById(R.id.textView2);
            phonetics=itemView.findViewById(R.id.textView3);


        }
    }
}
