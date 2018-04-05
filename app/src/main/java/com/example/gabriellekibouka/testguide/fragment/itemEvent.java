package com.example.gabriellekibouka.testguide.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabriellekibouka.testguide.MainActivity;
import com.example.gabriellekibouka.testguide.R;
import com.example.gabriellekibouka.testguide.adapters.AdapterRecycleViewItemEvent;
import com.example.gabriellekibouka.testguide.objets.Entreprise;
import com.example.gabriellekibouka.testguide.objets.Evenement;

import java.util.ArrayList;
import java.util.List;

public class itemEvent extends Fragment {
//    String itemTitre="Evènement";
    RecyclerView recyclerViewEvent;
    LinearLayoutManager layoutManagerEvent;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context=getContext();
//        ((MainActivity)context).setActionBarTitle(itemTitre);
        View view=inflater.inflate(R.layout.fragment_item_event, container, false);
        recyclerViewEvent = (RecyclerView) view.findViewById(R.id.recycleViewEvent);
        layoutManagerEvent=new LinearLayoutManager(context);
        layoutManagerEvent.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEvent.setLayoutManager(layoutManagerEvent);
        recyclerViewEvent.setAdapter(new AdapterRecycleViewItemEvent(context,evenementList()));

        return view;
    }

    private List<Evenement> evenementList() {
        List evenementList=new ArrayList<>();
        evenementList.add(new Evenement(R.drawable.kybangou_banniere,"titre","Lorem ipsum dolor sit amet tempor inc"));
        evenementList.add(new Evenement(R.drawable.image,"titre","Lorem ipsum dolor sit amet tempor inc"));
        evenementList.add(new Evenement(R.drawable.image,"titre","Lorem ipsum dolor sit amet tempor inc"));
        evenementList.add(new Evenement(R.drawable.image,"titre","Lorem ipsum dolor sit amet tempor inc"));
        evenementList.add(new Evenement(R.drawable.image,"titre","Lorem ipsum dolor sit amet tempor inc"));
        evenementList.add(new Evenement(R.drawable.image,"titre","Lorem ipsum dolor sit amet tempor inc"));
        return evenementList;
    }


}
