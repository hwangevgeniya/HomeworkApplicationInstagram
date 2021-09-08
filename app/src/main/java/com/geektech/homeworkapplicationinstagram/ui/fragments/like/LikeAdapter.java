package com.geektech.homeworkapplicationinstagram.ui.fragments.like;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.homeworkapplicationinstagram.databinding.ItemMainLikeBinding;
import com.geektech.homeworkapplicationinstagram.models.Like;
import com.geektech.homeworkapplicationinstagram.ui.fragments.home.HomeAdapter;

import java.util.ArrayList;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.ViewHolder>{

    private ArrayList<Like> list = new ArrayList<>();

    public void setList(ArrayList<Like> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMainLikeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LikeAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemMainLikeBinding binding;

        public ViewHolder(@NonNull ItemMainLikeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Like like) {
            binding.ivLikeAvatar.setImageResource(like.getImage1());
            binding.ivLikeImage.setImageResource(like.getImage2());
            binding.tvLikeText.setText(like.getText1());
            binding.tvLikeText2.setText(like.getText2());
        }
    }
}
