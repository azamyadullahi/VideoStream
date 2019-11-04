package com.oxoo.spagreen.nav_fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.oxoo.spagreen.R;
import com.oxoo.spagreen.SearchActivity;
import com.oxoo.spagreen.fragments.HomeFragment;
import com.oxoo.spagreen.fragments.LiveTvFragment;
import com.oxoo.spagreen.fragments.MoviesFragment;
import com.oxoo.spagreen.fragments.TvSeriesFragment;
import com.oxoo.spagreen.settingblank;
import com.oxoo.spagreen.settingsFragment;

public class MainHomeFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;
    private ImageButton btnMovies,btnHome,btntvseries,btnsetting;
    private FloatingActionButton btnfav;
    private Fragment fragment=null;
    private Object Fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_main_home, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnHome=view.findViewById(R.id.home);
        btnfav=view.findViewById(R.id.add_fav);
        btnMovies=view.findViewById(R.id.movies);
        btntvseries=view.findViewById(R.id.recyclerViewTvSeries);
        btnsetting=view.findViewById(R.id.settings);



        btnfav.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        btnMovies.setColorFilter(getActivity().getResources().getColor(R.color.white));
        btnHome.setColorFilter(getActivity().getResources().getColor(R.color.white));
        btntvseries.setColorFilter(getActivity().getResources().getColor(R.color.white));
        btnsetting.setColorFilter(getActivity().getResources().getColor(R.color.white));


        btntvseries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment= new TvSeriesFragment();
                loadFragment(fragment);

                btntvseries.setColorFilter(getActivity().getResources().getColor(R.color.white));
                btnsetting.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnMovies.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnHome.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnfav.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_300)));


            }
        });

        btnMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new MoviesFragment();
                loadFragment(fragment);

                btntvseries.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnsetting.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnMovies.setColorFilter(getActivity().getResources().getColor(R.color.white));
                btnHome.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnfav.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_300)));


            }
        });

        btnfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new FavoriteFragment();
                loadFragment(fragment);

                btntvseries.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnsetting.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnfav.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                btnMovies.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnHome.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new HomeFragment();
                loadFragment(fragment);

                btntvseries.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnsetting.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnMovies.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnHome.setColorFilter(getActivity().getResources().getColor(R.color.white));
                btnfav.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_300)));
            }
        });

        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new settingblank();
                loadFragment(fragment);

                btntvseries.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnsetting.setColorFilter(getActivity().getResources().getColor(R.color.white));
                btnMovies.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnHome.setColorFilter(getActivity().getResources().getColor(R.color.grey_300));
                btnfav.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_300)));

            }
        });

//        bottomNavigationView = view.findViewById(R.id.navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment=null;
//                switch (item.getItemId()) {
//                    case R.id.navigation_home:
//                        fragment=new HomeFragment();
//                        break;
//
//                    case R.id.navigation_livetv:
//                        fragment=new LiveTvFragment();
//                        break;
//
//                    case R.id.navigation_movie:
//                        fragment=new MoviesFragment();
//                        break;
//
//                    case R.id.navigation_tvseries:
//                        fragment=new TvSeriesFragment();
//                        break;
//
//                }
//
//                loadFragment(fragment);
//                return true;
//            }
//        });

        loadFragment(new HomeFragment());

    }


    //----load fragment----------------------
    private boolean loadFragment(Fragment fragment){

        if (fragment!=null){

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();

            return true;
        }
        return false;

    }


}