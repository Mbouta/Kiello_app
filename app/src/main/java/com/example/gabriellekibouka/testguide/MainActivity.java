package com.example.gabriellekibouka.testguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gabriellekibouka.testguide.activity.DetailsActivity;
import com.example.gabriellekibouka.testguide.fragment.itemAccueil;
import com.example.gabriellekibouka.testguide.fragment.itemArtisanat;
import com.example.gabriellekibouka.testguide.fragment.itemAssociationsPro;
import com.example.gabriellekibouka.testguide.fragment.itemBTP;
import com.example.gabriellekibouka.testguide.fragment.itemCommerce;
import com.example.gabriellekibouka.testguide.fragment.itemEauxEtForets;
import com.example.gabriellekibouka.testguide.fragment.itemEvent;
import com.example.gabriellekibouka.testguide.fragment.itemIndustrie;
import com.example.gabriellekibouka.testguide.fragment.itemALaUne;
import com.example.gabriellekibouka.testguide.fragment.itemService;
import com.example.gabriellekibouka.testguide.model.Image;
import com.example.gabriellekibouka.testguide.utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,new itemAccueil());
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
           setFragment(new itemALaUne());
        }
        //Groupe enntreprise avec les différentes catégories
        else if(id==R.id.nav_home){
            setFragment(new itemAccueil());
        } else if(id==R.id.nav_event){
            setFragment(new itemEvent());
        }//066519224 igor

        else if (id == R.id.nav_entreprise) {

        } else if (id == R.id.nav_entreprise1) {
            setFragment(new itemEauxEtForets());

        } else if (id == R.id.nav_entreprise2) {
            setFragment(new itemIndustrie());

        } else if (id == R.id.nav_entreprise3) {
            setFragment(new itemBTP());

        }
        else if (id == R.id.nav_entreprise4) {
            setFragment(new itemCommerce());

        } else if (id == R.id.nav_entreprise5) {
            setFragment(new itemService());

        } else if (id == R.id.nav_entreprise6) {
            setFragment(new itemArtisanat());

        } else if (id == R.id.nav_entreprise7) {
            setFragment(new itemAssociationsPro());

        }
        // Groupe utilitaire avec les differnts items qu'il contient
//        else if (id == R.id.nav_utilitaire) {
//
//        } else if (id == R.id.nav_entreprise8) {
//            setFragment(new itemGouvernementCongolais());
//
//        } else if (id == R.id.nav_entreprise9) {
//            setFragment(new itemGeneraliteCongo());
//
//        } else if (id == R.id.nav_entreprise10) {
//            setFragment(new itemAmbassadeAcrediteAuCongo());
//
//        }
//        else if (id == R.id.nav_entreprise11) {
//            setFragment(new itemAmbassadeCongoEtranger());
//        } else if (id == R.id.nav_entreprise12) {
//            setFragment(new itemOrganisationInternationale());
//
//        } else if (id == R.id.nav_entreprise13) {
//            setFragment(new itemJourFerie());
//
//        }
        //itemEvenement, ou seront affichés tous les évèmnements sorte de calendrier d'evenement

        item.setChecked(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setTitle(item.getTitle());
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }







}
