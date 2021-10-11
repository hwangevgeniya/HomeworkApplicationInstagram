package com.geektech.homeworkapplicationinstagram.ui.fragments.users;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.data.UserImageClient;
import com.geektech.homeworkapplicationinstagram.databinding.FragmentUserBinding;
import com.geektech.homeworkapplicationinstagram.models.UserImage;
import com.geektech.homeworkapplicationinstagram.ui.activity.MainActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class UserFragment extends Fragment {

    //private ViewPager2 viewPager2;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private FragmentUserBinding binding;
    private TabLayout tabLayout;
    private Uri uri;
    private int[] listTL = {R.drawable.grid_icon, R.drawable.tags_icon1};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initViewPager();

        binding.btnUserEdit.setOnClickListener(v -> {
            Intent intent = new Intent().setAction(Intent.ACTION_PICK).setType("image/*");
            startActivityForResult(intent, 1);
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            uri = data.getData();
            binding.ivUserAvatar.setImageURI(uri);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (uri != null)
            Glide.with(requireContext()).load(uri).circleCrop().into(binding.ivUserAvatar);
        else binding.ivUserAvatar.setImageResource(R.drawable.ic_photo);
    }

    private void createList() {
        list.add(new UserImageFragment());
        list.add(new UserImageFragment2());
    }

    private void initViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(super.getActivity());
        adapter.setList(list);
        binding.vpUserContainer.setAdapter(adapter);

        new TabLayoutMediator(binding.tlUser, binding.vpUserContainer, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                tab.setIcon(listTL[position]);

                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.drawable.grid_icon);

                        tabLayout.getTabAt(1).setIcon(R.drawable.tags_icon);
                        break;

                    case 1:
                        tab.setIcon(R.drawable.tags_icon1);
                        tabLayout.getTabAt(2).setIcon(R.drawable.grid_icon1);

                }
            }


        }).attach();

    }




}