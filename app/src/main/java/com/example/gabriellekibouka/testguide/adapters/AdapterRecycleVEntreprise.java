package com.example.gabriellekibouka.testguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriellekibouka.testguide.R;
import com.example.gabriellekibouka.testguide.objets.Entreprise;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

/**
 * Created by gabrielle kibouka on 13/03/2018.
 */

public class AdapterRecycleVEntreprise extends RecyclerView.Adapter<AdapterRecycleVEntreprise.MyViewholder>  {
    List<Entreprise> entreprisesList;
    Context context;

    public AdapterRecycleVEntreprise(List<Entreprise> entreprisesList, Context context) {
        this.entreprisesList = entreprisesList;
        this.context = context;
    }
    //inner classe pour permettre d'inflater les view
    public class MyViewholder extends RecyclerView.ViewHolder {
        ImageView imageViewEntreprise;

        TextView textnom;
        TextView texadresse;
        TextView textnumeroTel;
        TextView textemail;
        TextView textcategorie;
        TextView textdateDeCreation;
        TextView textboitePostale;
        TextView textdescription;

        public MyViewholder(View itemView) {
            super(itemView);
            textnom=(TextView) itemView.findViewById(R.id.textView1);
            texadresse=(TextView) itemView.findViewById(R.id.textView2);
            textnumeroTel=(TextView) itemView.findViewById(R.id.textView3);
            textemail=(TextView) itemView.findViewById(R.id.textView4);
            textcategorie=(TextView) itemView.findViewById(R.id.textView5);
            //textdateDeCreation=(TextView) itemView.findViewById(R.id.textView6);
            //textboitePostale=(TextView) itemView.findViewById(R.id.textView7);
            //textdescription=(TextView) itemView.findViewById(R.id.textView8);
            imageViewEntreprise=(ImageView)itemView.findViewById(R.id.imageVEntreprise);

        }
    }
    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_entreprise
                ,parent,false);
        MyViewholder myViewholder=new MyViewholder(view);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        Entreprise entreprise=entreprisesList.get(position);
        holder.imageViewEntreprise.setImageResource(entreprise.getImag());

        holder.textnom.setText(entreprise.getNom());
        holder.texadresse.setText(entreprise.getAdresse());
        holder.textnumeroTel.setText(entreprise.getNumeroTel());
        holder.textemail.setText(entreprise.getEmail());
        holder.textcategorie.setText(entreprise.getCategorie());
        //holder.textdateDeCreation.setText(entreprise.getDateDeCreation());
        //holder.textboitePostale.setText(entreprise.getBoitePostale());
        //holder.textdescription.setText(entreprise.getDescription());

    }

    @Override
    public int getItemCount() {return entreprisesList.size();}


}
