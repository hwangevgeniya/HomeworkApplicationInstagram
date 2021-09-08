package com.geektech.homeworkapplicationinstagram.data;

import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.models.Home;

import java.util.ArrayList;

public class HomeClient {

    private ArrayList<Home> list = new ArrayList<>();

    public ArrayList<Home> getList() {

        list.add(new Home("joshua_l The game in Japan was amazing and I want to share some photos",
                "September 19", R.drawable.ic_rectangle));
        list.add(new Home("joshua_l The game in Japan was amazing and I want to share some photos",
                "September 19", R.drawable.ic_rectangle));
        list.add(new Home("joshua_l The game in Japan was amazing and I want to share some photos",
                "September 19", R.drawable.ic_rectangle));

        return list;
    }
}
