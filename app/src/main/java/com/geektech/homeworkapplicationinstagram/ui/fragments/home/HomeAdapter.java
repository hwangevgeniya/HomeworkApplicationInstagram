package com.geektech.homeworkapplicationinstagram.ui.fragments.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.homeworkapplicationinstagram.databinding.ItemMainHomeBinding;
import com.geektech.homeworkapplicationinstagram.models.Home;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private ArrayList<Home> list = new ArrayList<>();

    public void setList(ArrayList<Home> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMainHomeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {

        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemMainHomeBinding binding;
        public ViewHolder(@NonNull ItemMainHomeBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Home home) {

            binding.ivItemLarge.setImageResource(home.getImage());
            binding.tvItemLarge.setText(home.getText1());
            binding.tvItemLarge2.setText(home.getText2());

        }
    }
}
