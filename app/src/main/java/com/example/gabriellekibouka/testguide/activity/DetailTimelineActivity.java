package com.example.gabriellekibouka.testguide.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.antapp.flash_ws.utils.AntappUtilsMethods;
import com.example.gabriellekibouka.testguide.R;

public class DetailTimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.image_id);
        TextView des = (TextView) findViewById(R.id.description);
        Intent intent = getIntent();

        AntappUtilsMethods.quickImageUrlIntoGlide(
                getApplicationContext(),
                intent.getStringExtra("image"),
                imageView
        );

        //change le titre de la toolbar
        ((AppCompatActivity)this).getSupportActionBar().setTitle(intent.getStringExtra("titre"));
        des.setText(intent.getStringExtra("contenu"));




    }
}
