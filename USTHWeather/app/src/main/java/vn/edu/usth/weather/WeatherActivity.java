package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.*;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.weather.databinding.ActivityWeatherBinding;


public class WeatherActivity extends AppCompatActivity {

//    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Create a new Fragment to be placed in the activity l
        //ForecastFragment firstFragment = new ForecastFragment();
        // Add the fragment to the 'container' FrameLayout
        //getSupportFragmentManager().beginTransaction().add(R.id.main, firstFragment).commit();// container => main
        // Set locale to Vietnamese
        LocalHelper.setLocale(this, "vi");

        // Initialize ViewBinding
        setContentView(R.layout.activity_weather);

        ActivityWeatherBinding binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewPager viewPager = binding.viewPager;
        TabLayout tabLayout = binding.tabLayout;

        WeatherPagerAdapter adapter = new WeatherPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        Log.i("Weather", "onCreate Call");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i("Weather", "onStart Call");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("Weather", "onResume Call");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i("Weather", "onPause Call");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i("Weather", "onStop Call");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("Weather", "onDestroy Call");
    }


}