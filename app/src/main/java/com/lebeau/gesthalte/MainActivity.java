package com.lebeau.gesthalte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int option = item.getItemId();
        switch (option) {
            case R.id.app_bar_search:
                break;
            case R.id.registre:
                break;
            case R.id.modifier:
                break;
            case R.id.ajouter:
                break;
            case R.id.presences:
                break;
            case R.id.locaux:
                break;
            case R.id.horraires:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}