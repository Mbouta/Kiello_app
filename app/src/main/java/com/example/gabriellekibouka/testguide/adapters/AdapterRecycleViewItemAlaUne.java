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

import java.util.List;

/**
 * Created by gabrielle kibouka on 18/03/2018.
 */

public class AdapterRecycleViewItemAlaUne extends RecyclerView.Adapter<AdapterRecycleViewItemAlaUne.viewHolder> {
    Context context;
    List<ALaUne> ALaUneList;

    public AdapterRecycleViewItemAlaUne(Context context, List<ALaUne> ALaUneList) {
        this.context = context;
        this.ALaUneList = ALaUneList;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageEntreprise;
        TextView textDescription;
        TextView titre;

        public viewHolder(View itemView) {
            super(itemView);

            imageEntreprise=(ImageView) itemView.findViewById(R.id.imageALaUne);
            titre=(TextView) itemView.findViewById(R.id.tv_titre);
            textDescription=(TextView)itemView.findViewById(R.id.tv_descript);
        }
    }
    @Override
    public AdapterRecycleViewItemAlaUne.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_a_la_une
                ,parent,false);
        viewHolder mViewHolder=new viewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterRecycleViewItemAlaUne.viewHolder holder, int position) {
        ALaUne aLaUne=ALaUneList.get(position);
        holder.imageEntreprise.setImageResource(aLaUne.getImage());
        holder.titre.setText(aLaUne.getTitre());
        holder.textDescription.setText(aLaUne.getDescription());
    }

    @Override
    public int getItemCount() {
        return ALaUneList.size();
    }
}
