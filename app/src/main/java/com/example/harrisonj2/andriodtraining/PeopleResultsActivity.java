package com.example.harrisonj2.andriodtraining;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PeopleResultsActivity extends AppCompatActivity {

    private Person[] peopleData;
    DBHandler dbHandler;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_results);

        dbHandler = new DBHandler(this, null);

        String [] noPeople = {"No people found!"};

        peopleData = dbHandler.getPeople();

        if(peopleData != null){
            adapter = new PeopleResultsAdapter(this, peopleData);
        }else{
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noPeople);
        }

        ListView listView = (ListView) findViewById(R.id.peopleListView);
        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
