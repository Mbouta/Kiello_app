package com.example.gabriellekibouka.testguide.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabriellekibouka.testguide.MainActivity;
import com.example.gabriellekibouka.testguide.R;
import com.example.gabriellekibouka.testguide.adapters.AdapterRecycleVEntreprise;
import com.example.gabriellekibouka.testguide.adapters.AdapterRecycleVEntrepriseAlaUne;
import com.example.gabriellekibouka.testguide.objets.Entreprise;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class itemAmbassadeAcrediteAuCongo extends Fragment {
    Context context;
    String itemTitre="Ambassade acrédité au Congo";
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    public itemAmbassadeAcrediteAuCongo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getContext();
        ((MainActivity)context).setActionBarTitle(itemTitre);
        View view= inflater.inflate(R.layout.fragment_item_ambassade_acredite_au_congo, container, false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recycleView);
        linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AdapterRecycleVEntreprise(entrepriseList(),context));


        return view;    }

    private List<Entreprise> entrepriseList() {
        List listeEntreprise=new ArrayList<>();
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc",R.drawable.image));
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc" ,R.drawable.image));
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc",R.drawable.image));
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc",R.drawable.image));
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc",R.drawable.image));
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc",R.drawable.image));
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc",R.drawable.image));
        listeEntreprise.add(new Entreprise("Total","Base industrielle total ",
                "056600000","contacTotal@yahoo.fr"
                ,"Industrie","Octobre 1998","Bp 402",
                "Lorem ipsum dolor sit amet tempor inc",R.drawable.image));
        return listeEntreprise;
    }

}
