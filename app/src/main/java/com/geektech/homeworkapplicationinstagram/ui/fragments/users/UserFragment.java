package com.geektech.homeworkapplicationinstagram.ui.fragments.users;

import android.content.Intent;
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
    //private TabLayout tabLayout;
    private int[] listTL = {R.drawable.grid_icon,R.drawable.tags_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initViewPager();

        binding.btnUserEdit.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            final int ACTIVITY_SELECT_IMAGE = 1234;
            startActivityForResult(intent,ACTIVITY_SELECT_IMAGE);
            binding.ivUserAvatar.setImageResource(ACTIVITY_SELECT_IMAGE);

        });
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
            }
        }).attach();
    }
}