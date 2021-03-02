package com.example.recycleview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerImageTextAdapter extends RecyclerView.Adapter<RecyclerImageTextAdapter.ViewHolder> {

    Context context;
    private ArrayList<RecyclerItem> mData = new ArrayList<RecyclerItem>();

    OnItemClickListener listener;

    public static interface OnItemClickListener {
        public void onItemClick(ViewHolder holder, View view, int position);

    }

    public RecyclerImageTextAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        RecyclerItem item = mData.get(position);
        holder.setItem(item);

        holder.setOnItemClickListener(listener);
    }

    public void addItem(RecyclerItem item) {
        mData.add(item);
    }

    public RecyclerItem getItem(int position) {
        return mData.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;
        TextView desc;

        OnItemClickListener listener;

        ViewHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }

                }
            });

        }
        public void setItem(RecyclerItem item) {
            icon.setImageDrawable(item.getIcon());
            title.setText(item.getTitle());
            desc.setText(item.getDesc());
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }


    }

}
