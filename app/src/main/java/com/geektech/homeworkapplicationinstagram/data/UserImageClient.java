package com.geektech.homeworkapplicationinstagram.data;

import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.models.UserImage;

import java.util.ArrayList;
import java.util.Collections;

public class UserImageClient {

    private ArrayList<UserImage> list = new ArrayList<>();

    public ArrayList<UserImage> getList() {

        list.add(new UserImage(R.drawable.ic_photopost));
        list.add(new UserImage(R.drawable.ic_photopost2));
        list.add(new UserImage(R.drawable.ic_photopost3));
        list.add(new UserImage(R.drawable.ic_photopost4));
        list.add(new UserImage(R.drawable.ic_photopost5));
        list.add(new UserImage(R.drawable.ic_photopost6));
        list.add(new UserImage(R.drawable.ic_photopost7));
        list.add(new UserImage(R.drawable.ic_photopost8));
        list.add(new UserImage(R.drawable.ic_videopost));
        Collections.shuffle(list);
        return list;
    }
}
