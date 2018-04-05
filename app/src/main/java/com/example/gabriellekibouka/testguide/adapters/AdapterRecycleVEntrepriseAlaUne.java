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
 * Created by gabrielle kibouka on 16/03/2018.
 */

public class AdapterRecycleVEntrepriseAlaUne extends RecyclerView.Adapter<AdapterRecycleVEntrepriseAlaUne.mViewHolder> {
    Context context;
    List<ALaUne> ALaUneList;

    public AdapterRecycleVEntrepriseAlaUne(Context context, List<ALaUne> ALaUneList) {
        this.context = context;
        this.ALaUneList = ALaUneList;
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        ImageView imageEntreprise;
        TextView textDescription;
        TextView titre;

        public mViewHolder(View itemView) {
            super(itemView);
            imageEntreprise=(ImageView) itemView.findViewById(R.id.image_entreprise_a_la_une);
            titre=(TextView) itemView.findViewById(R.id.tv_titre);
            textDescription=(TextView)itemView.findViewById(R.id.tv_description);
        }
    }

    @Override
    public AdapterRecycleVEntrepriseAlaUne.mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_entreprise_a_la_une
                ,parent,false);
       mViewHolder mViewHolder=new mViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterRecycleVEntrepriseAlaUne.mViewHolder holder, int position) {
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
