package com.example.gabriellekibouka.testguide.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gabriellekibouka.testguide.MainActivity;
import com.example.gabriellekibouka.testguide.R;
import com.example.gabriellekibouka.testguide.activity.DetailsActivity;
import com.example.gabriellekibouka.testguide.adapters.AdapterRecycleVEntreprise;
import com.example.gabriellekibouka.testguide.adapters.AdapterRecycleVEntrepriseAlaUne;
import com.example.gabriellekibouka.testguide.model.Image;
import com.example.gabriellekibouka.testguide.objets.ALaUne;
import com.example.gabriellekibouka.testguide.objets.Entreprise;
import com.example.gabriellekibouka.testguide.utils.Tools;

import java.util.ArrayList;
import java.util.List;


public class itemAccueil extends Fragment {
    //    String titre="Accueil";
    private RecyclerView recyclerViewAlaUne;
    private RecyclerView recyclerViewEntreprise;
    private LinearLayoutManager layoutManagerAlaUne;
    private LinearLayoutManager layoutManagerEntreprise;

    private View view;

    private Context context;

    /* ============ ViewPager & AdapterImage Slider ================*/
    private ViewPager viewPager;
    private AdapterImageSlider adapterImageSlider;

    /* ============ Runnable using for autoSlideImage  ================*/
    private Runnable runnable = null;
    private Handler handler = new Handler();

    /* ============ Array of image of entreprise ================*/
    private static int[] array_image_entreprise = {
            R.drawable.dejeuner,
            R.drawable.dejeuner1,
            R.drawable.dejeuner2,
            R.drawable.dejeuner3,
            R.drawable.dejeuner9,
    };

    /* ============ Array of title of ads ================*/
    private static String[] array_titre_publicite = {
            "Foggy Hill",
            "The Backpacker",
            "River Forest",
            "Mist Mountain",
            "Side Park",
    };

    /* ============ Array of description of ads ================*/
    private static String[] array_description_publicite = {
            "Dui fringilla ornare finibus, orci odio",
            "Mauris sagittis non elit quis fermentum",
            "Mauris ultricies augue sit amet est sollicitudin",
            "Suspendisse ornare est ac auctor pulvinar",
            "Vivamus laoreet aliquam ipsum eget pretium",
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
//           ((MainActivity)getActivity()).setActionBarTitle(titre);

        view = inflater.inflate(R.layout.fragment_item_accueil, container, false);

        //Recycleview pour afficher les images des entreprises et activités a la une
        recyclerViewAlaUne=(RecyclerView)view.findViewById(R.id.recycleViewNews);
        layoutManagerAlaUne = new LinearLayoutManager(context);
        layoutManagerAlaUne.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewAlaUne.setLayoutManager(layoutManagerAlaUne);
        AdapterRecycleVEntrepriseAlaUne adapterRecycleVEntrepriseAlaUne = new AdapterRecycleVEntrepriseAlaUne(context, aLaUneList());
        recyclerViewAlaUne.setAdapter(adapterRecycleVEntrepriseAlaUne);

        ImageButton img_btn = (ImageButton) view.findViewById(R.id.img_btn);

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DetailsActivity.class);
                startActivity(intent);
            }
        });

        //Recycleview pour afficher une liste generale d'entreprie
        recyclerViewEntreprise = (RecyclerView) view.findViewById(R.id.recycleView);
        layoutManagerEntreprise = new LinearLayoutManager(context);
        layoutManagerEntreprise.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEntreprise.setLayoutManager(layoutManagerEntreprise);

        recyclerViewEntreprise.setAdapter(new AdapterRecycleVEntreprise(entrepriseList(), context));

        /* ============ Initialisation of initCompoment ================*/
        initCompment();

        return view;


    }

    private List<ALaUne> aLaUneList() {
        List listEntrepriseAlaUne = new ArrayList();
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_total, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_april, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_action_senso, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_logistica, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_zeop, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_arpce, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_logistica, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_action_senso, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_selecta, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_zeop, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_april, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_total, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        listEntrepriseAlaUne.add(new ALaUne(R.drawable.logo_april, "SOLDES CHEZ CASINO",
                "sode sur certains produites au super marché casino," +
                        " venez et profiter de ces promotions chers clients"));
        return listEntrepriseAlaUne;
    }


    private List<Entreprise> entrepriseList() {
        List listeEntreprise = new ArrayList<>();
        listeEntreprise.add(new Entreprise("Total", "Base industrielle total ",
                "056600000", "contacTotal@yahoo.fr"
                , "Industrie", "Octobre 1998", "Bp 402",
                "Lorem ipsum dolor sit amet tempor inc", R.drawable.logo_arpce));
        listeEntreprise.add(new Entreprise("Total", "Base industrielle total ",
                "056600000", "contacTotal@yahoo.fr"
                , "Industrie", "Octobre 1998", "Bp 402",
                "Lorem ipsum dolor sit amet tempor inc", R.drawable.logo_april));

        listeEntreprise.add(new Entreprise("Total", "Base industrielle total ",
                "056600000", "contacTotal@yahoo.fr"
                , "Industrie", "Octobre 1998", "Bp 402",
                "Lorem ipsum dolor sit amet tempor inc", R.drawable.logo_action_senso));






        return listeEntreprise;
    }


    /* ============ initCompment() Methode ================*/
    public void initCompment(){


        /* ============ Initialisation of viewPager and AdapterImageSlider ================*/
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapterImageSlider = new AdapterImageSlider(getActivity(), new ArrayList<Image>());

        final List<Image> items = new ArrayList<>();
        for (int i = 0; i < array_image_entreprise.length; i++) {
            Image obj = new Image();
            obj.image = array_image_entreprise[i];
            obj.imageDrw = getResources().getDrawable(obj.image);
            obj.slide_titre = array_titre_publicite[i];
            obj.slide_description = array_description_publicite[i];
            items.add(obj);
        }


        adapterImageSlider.setItems(items);
        viewPager.setAdapter(adapterImageSlider);

        // displaying selected image first
        viewPager.setCurrentItem(0);
        ((TextView) view.findViewById(R.id.tv_slide_titre)).setText(items.get(0).slide_titre);
        ((TextView) view.findViewById(R.id.tv_slide_description)).setText(items.get(0).slide_description);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                ((TextView) view.findViewById(R.id.tv_slide_titre)).setText(items.get(position).slide_titre);
                ((TextView) view.findViewById(R.id.tv_slide_description)).setText(items.get(position).slide_description);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });


        /* ============ startAutoSlider ================*/
        startAutoSlider(adapterImageSlider.getCount());
    }

    /* ========== Start Auto Slide Timer ============*/
    private void startAutoSlider(final int count) {
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = viewPager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                viewPager.setCurrentItem(pos);
                handler.postDelayed(runnable, 5000);
            }
        };
        handler.postDelayed(runnable, 5000);
    }

    /**================== Adapter for Slide Image =======================**/
    private static class AdapterImageSlider extends PagerAdapter {

        private Activity act;
        private List<Image> items;

        private AdapterImageSlider.OnItemClickListener onItemClickListener;

        private interface OnItemClickListener {
            void onItemClick(View view, Image obj);
        }

        public void setOnItemClickListener(AdapterImageSlider.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        // constructor
        private AdapterImageSlider(Activity activity, List<Image> items) {
            this.act = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        public Image getItem(int pos) {
            return items.get(pos);
        }

        public void setItems(List<Image> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final Image o = items.get(position);
            LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.item_slider_image, container, false);

            ImageView image = (ImageView) v.findViewById(R.id.image);
            LinearLayout lyt_parent = (LinearLayout) v.findViewById(R.id.lyt_parent);
            Tools.displayImageOriginal(act, image, o.image);
            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, o);
                    }
                }
            });

            ((ViewPager) container).addView(v);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);

        }

    }

    /* ============ onDestroy of startAutoImageSlider (Runnable) ================*/
    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }



}
