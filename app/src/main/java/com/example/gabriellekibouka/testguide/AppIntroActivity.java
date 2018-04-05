package com.example.gabriellekibouka.testguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gabriellekibouka.testguide.utils.PrefManager;

public class AppIntroActivity extends AppCompatActivity {


    private static final int MAX_STEP = 4;

    /* ============ ViewPager ================*/
    private ViewPager viewPager;

    /* ============ View Pager Adapter ================*/
    private MyViewPagerAdapter myViewPagerAdapter;

    /* ============ Button Commencer (btn_got_it) ================*/
    private Button btn_got_it;

    /* ============ Preference Manager ================*/
    private PrefManager prefManager;

    /* ============ Array of title ================*/
    private String title_array[] = {
            "Ready to Travel",
            "Pick the Ticket",
            "Flight to Destination",
            "Enjoy Holiday"
    };

    /* ============ Array of Description ================*/
    private String description_array[] = {
            "Choose your destination, plan Your trip. Pick the best place for Your holiday",
            "Select the day, pick Your ticket. We give you the best prices. We guarantee!",
            "Safe and Comfort flight is our priority. Professional crew and services.",
            "Enjoy your holiday, Dont forget to feel the moment and take a photo!",
    };

    /* ============ Array of Image ================*/
    private int about_images_array[] = {
            R.drawable.img_wizard_1,
            R.drawable.img_wizard_2,
            R.drawable.img_wizard_3,
            R.drawable.img_wizard_4
    };

    /* ============ Array of color ================*/
    private int color_array[] = {
            R.color.red_600,
            R.color.blue_grey_600,
            R.color.purple_600,
            R.color.deep_orange_600
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_intro);

        /* ============ Initialisation of all Compoment ================*/
        initComponent();
    }


    /* ============ Methode initCompoment use for putting all Setting of Compoment ================*/
    private void initComponent() {

        /* ============ Setting PrefManager ================*/
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        /* ============ Making Notification Bar translucente ================*/
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }


        /* ============ Change statusBarColor Setting ================*/
        changeStatusBarColor();

        /* ============ Initialisation of ViewPager ================*/
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        /* ============ Initialisation of Button Commencer (btn_got_it) ================*/
        btn_got_it = (Button) findViewById(R.id.btn_got_it);


        /* ============ Adding Bottoms Dots ================*/
        bottomProgressDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btn_got_it.setVisibility(View.GONE);
        btn_got_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        ((ImageView) findViewById(R.id.btn_skip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });
    }


    /* ============ launchHomeScreen() Methode use for start and finish AppIntroActivity  ================*/
    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(AppIntroActivity.this, MainActivity.class));
        finish();
    }

    /* ============ changeStatusBarColor() Methode use for settings statusBarColor ================*/
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    /* ============ bottomProgressDots() use for settings the progression of bottom Dots ================*/
    private void bottomProgressDots(int current_index) {
        LinearLayout dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        ImageView[] dots = new ImageView[MAX_STEP];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle);
            dots[i].setColorFilter(getResources().getColor(R.color.overlay_dark_30), PorterDuff.Mode.SRC_IN);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current_index].setImageResource(R.drawable.shape_circle);
            dots[current_index].setColorFilter(getResources().getColor(R.color.grey_10), PorterDuff.Mode.SRC_IN);
        }
    }

    /* ============ ViewPager.OnChangeListener ================*/
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            bottomProgressDots(position);
            if (position == title_array.length - 1) {
                btn_got_it.setVisibility(View.VISIBLE);
            } else {
                btn_got_it.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };



    /* ============ ViewPagerAdapter ================*/
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.item_stepper_wizard_color, container, false);
            ((TextView) view.findViewById(R.id.title)).setText(title_array[position]);
            ((TextView) view.findViewById(R.id.description)).setText(description_array[position]);
            ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);
            ((RelativeLayout) view.findViewById(R.id.lyt_parent)).setBackgroundColor(getResources().getColor(color_array[position]));
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return title_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
