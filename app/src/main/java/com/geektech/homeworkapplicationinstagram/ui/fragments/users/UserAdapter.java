package com.geektech.homeworkapplicationinstagram.ui.fragments.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.homeworkapplicationinstagram.databinding.ItemUserImageBinding;
import com.geektech.homeworkapplicationinstagram.models.UserImage;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<UserImage> list = new ArrayList<>();

    public void setList(ArrayList<UserImage> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemUserImageBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemUserImageBinding binding;

        public ViewHolder(@NonNull ItemUserImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(UserImage userImage) {
            binding.ivUserImage1.setImageResource(userImage.getImage());
        }
    }
}
