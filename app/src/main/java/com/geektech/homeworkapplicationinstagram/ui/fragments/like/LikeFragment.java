package com.geektech.homeworkapplicationinstagram.ui.fragments.like;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.data.LikeClient;
import com.geektech.homeworkapplicationinstagram.databinding.FragmentHomeBinding;
import com.geektech.homeworkapplicationinstagram.databinding.FragmentLikeBinding;
import com.geektech.homeworkapplicationinstagram.databinding.ItemMainLikeBinding;

import java.util.ArrayList;

public class LikeFragment extends Fragment {

    private FragmentLikeBinding binding;
    private LikeClient likeClient = new LikeClient();
    private LikeAdapter adapter = new LikeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLikeBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler();
    }

    private void initRecycler() {
        adapter.setList(likeClient.getList());
        binding.rvMainLike.setAdapter(adapter);
        binding.rvMainLike.addItemDecoration(new DividerItemDecoration(binding.rvMainLike.getContext(), DividerItemDecoration.VERTICAL));
    }
}