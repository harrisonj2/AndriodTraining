package com.example.harrisonj2.andriodtraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText emailEditText;
    EditText addressEditText;
    EditText cityEditText;

    Intent intent;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        cityEditText = (EditText) findViewById(R.id.cityEditText);

        dbHandler = new DBHandler(this, null);

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

    public void goToWelcome (View view){
        String name = nameEditText.getText().toString();

        if(name.trim().equals(""))
            Toast.makeText(this, "Please enter a name!", Toast.LENGTH_LONG).show();
        else{
            intent = new Intent(this, WelcomeActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }

    public void addData(View view){
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String city = cityEditText.getText().toString();

        if(name.trim().equals("") || email.trim().equals("") || address.trim().equals("") || city.trim().equals("")){
            Toast.makeText(this, "Please enter a name, email, address, and city!", Toast.LENGTH_LONG).show();
        }else{
            dbHandler.addPerson(name, email, address, city);
            Toast.makeText(this, "Person added!", Toast.LENGTH_LONG).show();
        }
    }

    public void getPeople(View view){
        intent = new Intent(this, PeopleResultsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_home :
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_welcome :
                intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
