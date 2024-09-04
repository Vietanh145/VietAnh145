package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    // Parameters for fragment initialization
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Variables to hold parameter values
    private String mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
        v.setBackgroundColor(0x2000FF00);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(getActivity());
        textView.setText("Thursday");
        textView.setTextSize(24);

        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(R.drawable.baseline_brightness_low_24);

        layout.addView(textView);
        layout.addView(imageView);

        ((ViewGroup) v).addView(layout);

        return v;
    }
}
