package com.example.mypaindiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.mypaindiary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.appBar.toolbar);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home_screen_fragment,
                R.id.nav_data_entry_fragment,
                R.id.nav_daily_record_fragment,
                R.id.nav_maps_fragment,
                R.id.nav_reports_fragment
                )
//to display the Navigation button as a drawer symbol,not being shown as an Up button
                .setDrawerLayout(binding.drawerLayout)
                .build();
        FragmentManager fragmentManager= getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment)
                fragmentManager.findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        //Sets up a NavigationView for use with a NavController.
        NavigationUI.setupWithNavController(binding.navView, navController);
        //Sets up a Toolbar for use with a NavController.
        NavigationUI.setupWithNavController(binding.appBar.toolbar,navController,
                mAppBarConfiguration);
    }
}