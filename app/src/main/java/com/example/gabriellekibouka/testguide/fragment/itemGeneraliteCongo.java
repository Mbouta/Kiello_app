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
public class itemGeneraliteCongo extends Fragment {
//    String itemTitre="Généralité sur le Congo";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ((MainActivity)getActivity()).setActionBarTitle(itemTitre);
        View view =inflater.inflate(R.layout.fragment_item_generalite_congo, container, false);
        return view;
    }

}
