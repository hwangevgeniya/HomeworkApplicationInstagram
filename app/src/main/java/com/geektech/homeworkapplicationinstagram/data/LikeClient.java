package com.geektech.homeworkapplicationinstagram.data;

import com.geektech.homeworkapplicationinstagram.R;
import com.geektech.homeworkapplicationinstagram.models.Like;

import java.util.ArrayList;

public class LikeClient {

    private ArrayList<Like> list = new ArrayList<>();

    public ArrayList<Like> getList(){

        list.add(new Like(R.drawable.ic_oval, R.drawable.ic_photopost4,"karennne liked your photo", "1h"));
        list.add(new Like(R.drawable.ic_oval, R.drawable.ic_photopost4,"karennne liked your photo", "1h"));
        list.add(new Like(R.drawable.ic_oval, R.drawable.ic_photopost4,"karennne liked your photo", "1h"));
        list.add(new Like(R.drawable.ic_oval, R.drawable.ic_photopost4,"karennne liked your photo", "1h"));

        return list;
    }
}
