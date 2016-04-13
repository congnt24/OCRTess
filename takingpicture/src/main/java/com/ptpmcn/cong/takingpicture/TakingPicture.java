package com.ptpmcn.cong.takingpicture;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TakingPicture extends TextView implements SurfaceHolder.Callback {

    private static TakingPicture instance;
    Context context;
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;

    public TakingPicture(Context context) {
        super(context);
    }

    public static TakingPicture getInstance(){
        //if (instance == null)
            //instance = new TakingPicture();
        return instance;
    }
    public TakingPicture initialize(Context context){
        this.context = context;
        return this;
    }

    public TakingPicture openCamera(){

        return this;
    }

    public TakingPicture initSurface(ViewGroup container, LayoutInflater inflater){
        if (container==null){
            throw new NullPointerException("Container or inflater cannot be null");
        }
        if (inflater==null){
            throw new IllegalArgumentException("Inflater cannot be null");
        }
        View rootView = inflater.inflate(R.layout.camera_surface, container, false);
        mSurfaceView = (SurfaceView) rootView.findViewById(R.id.surface_camera);

        mSurfaceHolder = mSurfaceView.getHolder();

        mSurfaceHolder.addCallback(this);

        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        return this;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
