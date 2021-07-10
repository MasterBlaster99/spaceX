package com.example.spacex;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountryInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);
        //Direct Defining
        TextView countryNameTV = findViewById(R.id.countryName);
        TextView capitalNameTV = findViewById(R.id.capitalName);
        TextView regionTV = findViewById(R.id.region);
        TextView population = findViewById(R.id.population);
        ImageView imageView = findViewById(R.id.flagImage);

        Intent intent = getIntent();
        JSONObject jsonObject;
        String objectValue = intent.getStringExtra("object");
        try {
            jsonObject = new JSONObject(objectValue);
            countryNameTV.setText("Crew Name : "+jsonObject.getString("name"));
            capitalNameTV.setText("Agency : "+jsonObject.getString("agency"));
            regionTV.setText("Status : "+jsonObject.getString("status"));
            Picasso.get().load(jsonObject.getString("image")).into(imageView);
            population.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = null;
                    try {
                        url = jsonObject.getString("wikipedia");
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}