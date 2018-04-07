package com.example.gabriellekibouka.testguide.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabriellekibouka.testguide.R;
import com.example.gabriellekibouka.testguide.objets.Entreprise;
import com.example.gabriellekibouka.testguide.objets.TimeLine;

import java.util.List;

/**
 * Created by lebeau BAFOUIDIZO on 07/04/2018.
 */

public class AdapterRecycleVTimeLine extends RecyclerView.Adapter<AdapterRecycleVTimeLine.MyViewholder> {

    List<TimeLine> timeLinesList;
    Context context;

    public AdapterRecycleVTimeLine(List<TimeLine> timeLinesList, Context context) {
        this.timeLinesList = timeLinesList;
        this.context = context;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        public MyViewholder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_timeline
                ,parent,false);
        AdapterRecycleVTimeLine.MyViewholder myViewholder=new AdapterRecycleVTimeLine.MyViewholder(view);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }


}
