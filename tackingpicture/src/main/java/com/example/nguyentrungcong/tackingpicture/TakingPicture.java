package com.example.nguyentrungcong.tackingpicture;

import android.content.Context;

/**
 * Created by Nguyen Trung Cong on 9/11/2015.
 */
public class TakingPicture {
    private static TakingPicture instance;
    Context context;
    public static TakingPicture getInstance(){
        if (instance == null)
            instance = new TakingPicture();
        return instance;
    }
    public TakingPicture initialize(Context context){
        this.context = context;
        return this;
    }

    public TakingPicture openCamera(){

        return this;
    }
}
