package com.example.recycleview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerImageTextAdapter extends RecyclerView.Adapter<RecyclerImageTextAdapter.ViewHolder> {

    Context context;
    private ArrayList<RecyclerItem> mData = new ArrayList<RecyclerItem>();

    OnItemClickListener listener;

    View.OnClickListener clickListener;

    OnDeleteButtonItemClickListener deleteButtonListener;

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


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(holder, v, position);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(v.getContext(), "Clicked button at position: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                mData.remove(position);
                notifyDataSetChanged();

            }
        });

        /*
        if(deleteButtonListener != null) {

            ViewHolder myHolder = (ViewHolder) holder;
            myHolder.getDeleteButton().setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    deleteButtonListener.onDeleteIsClick(v, position);
                }
            });

        }*/
    }

    //Handling button click in RecyclerView adapter?

    public static class MyHolder extends RecyclerView.ViewHolder {
        private final Button deleteButton;

        public MyHolder(View itemView) {
            super(itemView);

            deleteButton = (Button) itemView.findViewById(R.id.doneButton);
        }

        public Button getDeleteButton() {
            return deleteButton;
        }
    }

    public interface OnDeleteButtonItemClickListener {
        void onDeleteIsClick(View button, int position);
    }

    public void setDeleteButtonListener(OnDeleteButtonItemClickListener deleteButtonListener){
        this.deleteButtonListener = deleteButtonListener;
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
        OnDeleteButtonItemClickListener deleteButtonListener;

        private final Button deleteButton;

        ViewHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);

            deleteButton = (Button) itemView.findViewById(R.id.doneButton);

            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);

                    }

                }
            });
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    //Toast.makeText(v.getContext(), "Clicked button at position: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    mData.remove(pos);
                    notifyDataSetChanged();
                    listener.onItemClick(ViewHolder.this, v, pos);
                }
            });*/

        }

        public Button getDeleteButton() {
            return deleteButton;
        }

        public void setItem(RecyclerItem item) {
            icon.setImageDrawable(item.getIcon());
            title.setText(item.getTitle());
            desc.setText(item.getDesc());
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        public void setDeleteButtonListener(OnDeleteButtonItemClickListener deleteButtonListener){
            this.deleteButtonListener = deleteButtonListener;
        }


    }

}
