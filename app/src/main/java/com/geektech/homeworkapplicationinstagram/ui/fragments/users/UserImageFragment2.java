package com.geektech.homeworkapplicationinstagram.ui.fragments.users;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.data.UserImageClient;
import com.geektech.homeworkapplicationinstagram.databinding.FragmentUserImage2Binding;
import com.geektech.homeworkapplicationinstagram.databinding.FragmentUserImageBinding;

public class UserImageFragment2 extends Fragment {

    private FragmentUserImage2Binding binding;
    private UserImageClient userImageClient = new UserImageClient();
    private UserAdapter adapter = new UserAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserImage2Binding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler();
    }

    private void initRecycler() {
        adapter.setList(userImageClient.getList());
        binding.rvUserImage2.setLayoutManager(new GridLayoutManager(super.getActivity(),3));
        binding.rvUserImage2.setAdapter(adapter);
    }
}