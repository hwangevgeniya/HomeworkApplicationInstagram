package com.geektech.homeworkapplicationinstagram.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.databinding.ActivityMainBinding;
import com.geektech.homeworkapplicationinstagram.databinding.FragmentUserBinding;
import com.geektech.homeworkapplicationinstagram.ui.fragments.home.HomeFragment;
import com.geektech.homeworkapplicationinstagram.ui.fragments.like.LikeFragment;
import com.geektech.homeworkapplicationinstagram.ui.fragments.users.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    FragmentUserBinding fragmentUserBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initBottomNav();




    }

    private void initBottomNav() {
        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContainer,new HomeFragment()).commit();
        binding.bnMainBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContainer, new HomeFragment()).commit();
                        
                        break;
                    case R.id.like:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContainer, new LikeFragment()).commit();
                        break;
                    case R.id.users:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContainer, new UserFragment()).commit();

                        break;
                }

                return true;
            }


        });



    }
}