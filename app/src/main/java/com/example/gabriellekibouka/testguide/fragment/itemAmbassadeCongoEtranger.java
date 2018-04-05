package com.example.gabriellekibouka.testguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabriellekibouka.testguide.MainActivity;
import com.example.gabriellekibouka.testguide.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class itemAmbassadeCongoEtranger extends Fragment {
//    String itemTitre="Ambassade du Congo à l'étranger";

    public itemAmbassadeCongoEtranger() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ((MainActivity)getActivity()).setActionBarTitle(itemTitre);
        return inflater.inflate(R.layout.fragment_item_ambassade_congo_etranger, container, false);
    }

}
