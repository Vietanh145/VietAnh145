package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WeatherPagerAdapter extends FragmentPagerAdapter {

    //private final String[] titles = new String[] { "HaNoi VN", "Paris France", "Toulouse Fr" };
    private final String[] titles = new String[] { "Hà Nội", "Hồ Chí Minh", "Nam Định" };

    public WeatherPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return WeatherAndForecastFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int page) {
        return titles[page];
    }
}