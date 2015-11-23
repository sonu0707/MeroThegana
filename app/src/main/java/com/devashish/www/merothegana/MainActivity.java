package com.devashish.www.merothegana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    private Toolbar toolbar;
    AutoCompleteTextView at;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        spinnerfunction();
        autoCompleteTextFunction();
    }

    public void spinnerfunction() {
        Spinner spinner, spinner2, spinner3;
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter array = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter array2 = ArrayAdapter.createFromResource(this, R.array.district, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter array3 = ArrayAdapter.createFromResource(this, R.array.municipality, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(array);
        spinner2.setAdapter(array2);
        spinner3.setAdapter(array3);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
    }

    public void autoCompleteTextFunction() {

        String[] st = {"Nabil Bank", "Aaryan Sharma", "Ambar", "Aasman", "Ankur", "Bibek", "Sonu", "Saurav",
                "Bina", "Malika", "Puzen", "Pizza King", "Bamdev Resturant"};

        at = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, st);
        at.setThreshold(1);
        at.setAdapter(adapter);
    }

    public void searchButtonFunction(View v) {
      if(at.getText().toString().equals("Nabil Bank")){
        startActivity(new Intent(this, MatchingResults.class));
      }
        if (at.getText().toString().equals("Aaryan Sharma")){
            startActivity(new Intent(this, MatchingName.class));
        }
        else{
            Toast.makeText(MainActivity.this,"UnderConstruction",Toast.LENGTH_SHORT).show();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
