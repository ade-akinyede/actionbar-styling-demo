package com.androidplaybook.actionBarStylingDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.androidplaybook.showcasedemo.R;

/**
 * Created by Ade on 3/27/2016.
 */
public class ChildActivity extends BaseActivity {
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_child;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        setActionBarTitle("Main");
//        setToolbarBackgroundColor(R.color.colorPrimaryDark);
        setActionBarBackButton(true);
    }
}
