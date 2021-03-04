package com.example.recycleview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        mAdapter = new RecyclerImageTextAdapter(getApplicationContext());
        mRecyclerVIew.setAdapter(mAdapter);

        mRecyclerVIew.setLayoutManager(new LinearLayoutManager(this));

        mAdapter.addItem(new RecyclerItem(getDrawable(R.drawable.account_box_black_36), "Box", "Account Box Black 36"));
        mAdapter.addItem(new RecyclerItem(getDrawable(R.drawable.account_circle_black_36), "circle", "Account Circle Black 36"));
        mAdapter.addItem(new RecyclerItem(getDrawable(R.drawable.assignment_ind_black_36), "Ind", "Assignment Ind Black 36"));

        mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemClickListener(new RecyclerImageTextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerImageTextAdapter.ViewHolder holder, View view, int position) {
                RecyclerItem item = mAdapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨 : "+ item.getTitle(), Toast.LENGTH_LONG);
            }
        });

        Button deletebutton = (Button) findViewById(R.id.doneButton);

        /*
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hihihihihihi", Toast.LENGTH_LONG);
            }
        });*/


        mAdapter.setDeleteButtonListener(new RecyclerImageTextAdapter.OnDeleteButtonItemClickListener() {
            @Override
            public void onDeleteIsClick(View button, int position) {
                RecyclerItem item = mList.get(position);
                Toast.makeText(getApplicationContext(), "hihihihihihi", Toast.LENGTH_LONG);
            }
        });
    }

}
