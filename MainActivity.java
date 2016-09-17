package com.example.ice.taobao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    private View tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //假数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(i + "");
        }
        ListView listView = (ListView) findViewById(R.id.iv);
        listView.setAdapter(new MyAdapter(list));

        LayoutInflater inflater = LayoutInflater.from(this);
        View view1 = inflater.inflate(R.layout.head1, null);
        View view2 = inflater.inflate(R.layout.head2, null);
        tab = findViewById(R.id.tab);
        listView.addHeaderView(view1);
        listView.addHeaderView(view2);
        listView.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem == 1) {
            tab.setVisibility(View.VISIBLE);
        }
        if (firstVisibleItem == 0) {
            tab.setVisibility(View.GONE);
        }
    }
}
