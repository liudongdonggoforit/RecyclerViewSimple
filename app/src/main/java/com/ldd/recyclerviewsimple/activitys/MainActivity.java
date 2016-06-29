package com.ldd.recyclerviewsimple.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ldd.recyclerviewsimple.R;
import com.ldd.recyclerviewsimple.adapter.RecycleAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    private LinearLayoutManager mLayoutManager;
    private RecycleAdapter mAdapter;
    private GridLayoutManager gridLayoutManager;
    //添加数据
    private String [] subjects = {"语文","数学","英语","物理","化学","生物","政治","历史","地理","美术","音乐","体育"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this,3);
        mLayoutManager.setOrientation(LinearLayout.VERTICAL);
//        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setLayoutManager(gridLayoutManager);
        mAdapter = new RecycleAdapter(this,subjects);
        mRecyclerview.setAdapter(mAdapter);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (mAdapter.isHeaderView(position) || mAdapter.isFootView(position)) ? gridLayoutManager.getSpanCount() : 1;
            }
        });
    }

    private void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.simpleRecyclerView);
    }
}
