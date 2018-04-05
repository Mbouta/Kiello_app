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
import com.example.gabriellekibouka.testguide.adapters.AdapterRecycleViewItemAlaUne;
import com.example.gabriellekibouka.testguide.objets.ALaUne;

import java.util.ArrayList;
import java.util.List;

public class itemALaUne extends Fragment {
    Context context;
//    String itemTitre="A la une";
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getContext();
//        ((MainActivity)context).setActionBarTitle(itemTitre);
       View view = inflater.inflate(R.layout.fragment_item_a_la_une, container, false);
       recyclerView = (RecyclerView)view.findViewById(R.id.recycleView);
       layoutManager=new LinearLayoutManager(context);
       layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(new AdapterRecycleViewItemAlaUne(context,aLaUneList()));

       return view;
    }

    private List<ALaUne> aLaUneList() {
        List listEntrepriseAlaUne=new ArrayList();
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.image,"SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino,"+
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.image,"SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino,"+
                        " venez et profiter de ces promotions chers clients"));

        return listEntrepriseAlaUne;
    }

}
