package com.hxb.shadowdrawable.dome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * @作者 ：hexingbo
 * @时间 ：2019/4/11
 * @描述 ：ExampleContainerActivity
 */
public class ExampleContainerActivity extends AppCompatActivity {

    public final static int CONTAINER_TYPE_LIST = 1;
    public final static int CONTAINER_TYPE_GRID = 2;
    public final static int CONTAINER_TYPE_RECYCLE = 3;
    public final static int CONTAINER_TYPE_PAGER = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_container_layout);
        int containerType = getIntent().getIntExtra("containerType", CONTAINER_TYPE_LIST);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        if (containerType == CONTAINER_TYPE_LIST) {
            fragment = new ListExampleFragment();
        } else if (containerType == CONTAINER_TYPE_GRID) {
            fragment = new GridExampleFragment();
        } else if (containerType == CONTAINER_TYPE_RECYCLE) {
            fragment = new RecycleExampleFragment();
        } else if (containerType == CONTAINER_TYPE_PAGER) {
            fragment = new PagerExampleFragment();
        } else {
            /**
             * Nothing
             */
        }

        if (fragment != null) {
            ft.add(R.id.container_layout, fragment);
            ft.commitAllowingStateLoss();
        }
    }

    public static void enter(Context context, int containerType) {
        Intent intent = new Intent(context, ExampleContainerActivity.class);
        intent.putExtra("containerType", containerType);
        context.startActivity(intent);
    }
}
