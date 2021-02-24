package com.example.recycleview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView mRecyclerVIew = null;
    RecyclerImageTextAdapter mAdapter = null;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);

        mRecyclerVIew = findViewById(R.id.recyclerIn2nd);

        mAdapter = new RecyclerImageTextAdapter(mList);
        mRecyclerVIew.setAdapter(mAdapter);

        mRecyclerVIew.setLayoutManager(new LinearLayoutManager(this));

        addItem(getDrawable(R.drawable.account_box_black_36), "Box", "Account Box Black 36");
        addItem(getDrawable(R.drawable.account_circle_black_36), "circle", "Account Circle Black 36");
        addItem(getDrawable(R.drawable.assignment_ind_black_36), "Ind", "Assignment Ind Black 36");

        mAdapter.notifyDataSetChanged();

    }

    public void addItem(Drawable icon, String title, String desc) {
        RecyclerItem item = new RecyclerItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        mList.add(item);
    }

}
