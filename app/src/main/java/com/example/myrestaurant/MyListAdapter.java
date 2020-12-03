package com.example.myrestaurant;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private ArrayList<model> listdata;

    public MyListAdapter(ArrayList<model> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.cart_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.t1.setText(listdata.get(position).name);
        holder.t2.setText(listdata.get(position).quantity);
        holder.t3.setText(listdata.get(position).price);
        holder.t4.setText(listdata.get(position).total);
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView t1,t2,t3,t4;
        public ViewHolder(View itemView) {
            super(itemView);
            this.t1 = itemView.findViewById(R.id.item);
            this.t2 = itemView.findViewById(R.id.quantity);
            this.t3 = itemView.findViewById(R.id.price);
            this.t4 = itemView.findViewById(R.id.total);
        }
    }
}
