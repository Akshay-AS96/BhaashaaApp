package com.example.loginrepapi.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubTopicAdapter extends RecyclerView.Adapter<SubTopicAdapter.SubTopicViewHolder> {
    @NonNull
    @Override
    public SubTopicAdapter.SubTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SubTopicAdapter.SubTopicViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SubTopicViewHolder extends RecyclerView.ViewHolder {
        public SubTopicViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
