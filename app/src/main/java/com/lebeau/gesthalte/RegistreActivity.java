package com.lebeau.gesthalte;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import model.Enfant;


public class RegistreActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RegistreAdapter registreAdapter;
    private Intent monIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        EnfantDBHelper dbHelper = new EnfantDBHelper(this);
        List<Enfant> enfants = dbHelper.getAllEnfants();

        if(enfants.size() > 0){
            registreAdapter = new RegistreAdapter(enfants,RegistreActivity.this);
            recyclerView.setAdapter(registreAdapter);
        }else{
            Toast.makeText(this, "Il n'y a pas d'enfant dans la base de données", Toast.LENGTH_SHORT).show();
        }

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
            case R.id.menuRegistre:
                monIntent = new Intent(this, RegistreActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuAjouter:
                monIntent = new Intent(this, AjouterActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuPresences:
                Toast.makeText(this, R.string.presenceManagement,
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.menuLocaux:
                Toast.makeText(this, R.string.roomManagement_Construction,
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.menuHoraires:
                Toast.makeText(this, R.string.schedulePlanning_Construction,
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.menuAccueil:
                monIntent = new Intent(this, MainActivity.class);
                startActivity(monIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}