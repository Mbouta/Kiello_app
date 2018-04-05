package com.example.gabriellekibouka.testguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriellekibouka.testguide.R;
import com.example.gabriellekibouka.testguide.objets.ALaUne;
import com.example.gabriellekibouka.testguide.objets.Evenement;

import java.util.List;

/**
 * Created by gabrielle kibouka on 18/03/2018.
 */

public class AdapterRecycleViewItemEvent extends RecyclerView.Adapter<AdapterRecycleViewItemEvent.ViewHolder> {
    Context context;
    List<Evenement> evenementList;

    public AdapterRecycleViewItemEvent(Context context,List<Evenement> evenementList) {
        this.context = context;
        this.evenementList = evenementList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageEntreprise;
        TextView textDescription;
        TextView titre;

        public ViewHolder(View itemView) {
            super(itemView);
            imageEntreprise=(ImageView) itemView.findViewById(R.id.imageVEntreprise);
            titre=(TextView) itemView.findViewById(R.id.tv_titre);
            textDescription=(TextView)itemView.findViewById(R.id.tv_description);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_event,parent,false);
        ViewHolder mViewHolder=new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Evenement evenement=evenementList.get(position);
        holder.imageEntreprise.setImageResource(evenement.getImage());
        holder.titre.setText(evenement.getTitre());
        holder.textDescription.setText(evenement.getDescription());
    }

    @Override
    public int getItemCount() {
        return evenementList.size();
    }

}
