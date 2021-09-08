package com.geektech.homeworkapplicationinstagram.ui.fragments.users;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.data.UserImageClient;
import com.geektech.homeworkapplicationinstagram.databinding.FragmentUserImageBinding;


public class UserImageFragment extends Fragment {

    private FragmentUserImageBinding binding;
    private UserImageClient userImageClient = new UserImageClient();
    private UserAdapter adapter = new UserAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserImageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler();
    }

    private void initRecycler() {
        adapter.setList(userImageClient.getList());
        binding.rvUserImage.setLayoutManager(new GridLayoutManager(super.getActivity(),3));
        binding.rvUserImage.setAdapter(adapter);

    }
}