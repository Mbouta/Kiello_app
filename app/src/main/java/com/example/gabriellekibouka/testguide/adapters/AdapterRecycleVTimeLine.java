package com.example.gabriellekibouka.testguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.antapp.flash_ws.utils.AntappUtilsMethods;
import com.example.gabriellekibouka.testguide.R;
import com.example.gabriellekibouka.testguide.activity.DetailTimelineActivity;
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
        ImageView imageFrom;
        ImageView imageBanner;
        TextView titre;
        TextView auteur;
        TextView date;
        CardView cardView;
        LinearLayout linearLayout;
        public MyViewholder(View itemView) {
            super(itemView);

            imageBanner =(ImageView) itemView.findViewById(R.id.image_banner);
            imageFrom =(ImageView) itemView.findViewById(R.id.logo_from);
            titre =(TextView) itemView.findViewById(R.id.titres);
            auteur =(TextView) itemView.findViewById(R.id.name_from);
            date =(TextView) itemView.findViewById(R.id.dates);
            cardView =(CardView) itemView.findViewById(R.id.cardViewItem);
            linearLayout =(LinearLayout) itemView.findViewById(R.id.l1);
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
    public void onBindViewHolder(@NonNull final MyViewholder holder, final int position) {

        holder.titre.setText(timeLinesList.get(position).getTitre());
        holder.auteur.setText(timeLinesList.get(position).getAuteur());
        holder.date.setText(timeLinesList.get(position).getDate());

        AntappUtilsMethods.quickImageUrlIntoGlide(context,timeLinesList.get(position).getImage(),holder.imageBanner);
        AntappUtilsMethods.quickImageUrlIntoGlide(context,timeLinesList.get(position).getLogoFrom(),holder.imageFrom);


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTimelineActivity.class);
                intent.putExtra("image",timeLinesList.get(position).getImage());
                intent.putExtra("endPoint",timeLinesList.get(position).getEndPoint());
                intent.putExtra("contenu",timeLinesList.get(position).getContenu());
                intent.putExtra("titre",timeLinesList.get(position).getTitre());
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return timeLinesList.size();
    }


}
