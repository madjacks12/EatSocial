package com.mdjdev.eatsocial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;

public class ListActivity extends AppCompatActivity {

    @Bind(R.id.restaurantHeader) TextView mRestaurantHeader;
    @Bind(R.id.listView) ListView mListView;

    private String[] restaurants = new String[] {"Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food",
            "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar",
            "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };
    private String[] friends = new String[] {"Brice Phillips", "Susan Samson", "Chris Davis", "Linda Romano", "Thomas Shelby", "Ashford Delanto", "Britney Houston", "Scooter Richards", "Patty Daniels", "Phillip Buch", "Dave Johnson", "Kathy Smith", "Arnold California", "Del Olds", "Freddy Friday", "Lisa Simpson" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}
