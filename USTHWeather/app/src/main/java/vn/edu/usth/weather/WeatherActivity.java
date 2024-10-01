package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import vn.edu.usth.weather.databinding.ActivityWeatherBinding;


public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";


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

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        ViewPager viewPager = binding.viewPager;
        TabLayout tabLayout = binding.tabLayout;

        // Extract the MP3 file to external storage
        extractMP3ToExternalStorage();
        // Play the MP3 after extraction
        playMP3FromExternalStorage();

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
    private void extractMP3ToExternalStorage() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.file);
            File outFile = new File(getExternalFilesDir(null), "file.mp3");
            FileOutputStream outputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
            Log.i(TAG, "MP3 extracted to: " + outFile.getAbsolutePath());
        } catch (IOException e) {
            Log.e(TAG, "Error extracting MP3", e);
        }
    }
    private void playMP3FromExternalStorage() {
        try {
            File mp3File = new File(getExternalFilesDir(null), "file.mp3");
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(mp3File.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Log.i(TAG, "Playing MP3");
        } catch (IOException e) {
            Log.e(TAG, "Error playing MP3", e);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_weather.xml
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                // Show a toast when the refresh action is clicked
                Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                // Start PrefActivity when the settings action is clicked
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}