package com.example.samramez.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;
        ListView listView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);


            String[] forecastArray = {
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 54/49",
                    "Wed - Cloudy - 54/49",
                    "Thur - Sunny - 54/49",
                    "Fri - rainy - 54/49",
                    "Sat - snowy - 54/49",
                    "Sun - Foggy - 54/49",
            };

            List<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray) );

            // Initializing the Adaptor
            mForecastAdapter = new ArrayAdapter<String>(
                    // The current context (This fragment's parent activity)
                    getActivity(),
                    // ID of list item layout
                    R.layout.list_item_forecast,
                    // ID of texView to be populated
                    R.id.list_item_forecast_textView,
                    weekForecast
                    );

            listView = (ListView) rootView.findViewById(R.id.listView_Forecast);

            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
