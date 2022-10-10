package com.lebeau.gesthalte;

import static java.util.List.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Enfant;

public class AjouterActivity extends AppCompatActivity {
    private Button btnAjouter;
    private RecyclerView recyclerView;
    private EnfantDBHelper dbHelper;
    private String[] labels;
    private AjouterAdapter adapter;

    private Intent monIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        btnAjouter = findViewById(R.id.btnAjouter);
        recyclerView = (RecyclerView) findViewById(R.id.ListAjouter);
        labels = new String[]{getString(R.string.name), getString(R.string.firstName),
                getString(R.string.DateNaissance), getString(R.string.age), getString(R.string.phone),
                getString(R.string.address), getString(R.string.city), getString(R.string.province),
                getString(R.string.zipCode), getString(R.string.allergy), getString(R.string.parent1),
                getString(R.string.parent2), getString(R.string.parent3), getString(R.string.authorizedPersons)};

        adapter = new AjouterAdapter(this,labels);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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

    public void onAjouter() {


    }


    public void onAjouter(View view) {
        EditText txtLigneItem;
        Enfant enfant = new Enfant();
        dbHelper = new EnfantDBHelper(this);
        for(int i = 0; i< recyclerView.getChildCount(); i++){
            View v = recyclerView.getChildAt(i);
            txtLigneItem = v.findViewById(R.id.txtLigneItem);
            switch (i){
                case 0:
                    enfant.setNom(txtLigneItem.getText().toString());
                    break;
                case 1:
                    enfant.setPrenom(txtLigneItem.getText().toString());
                    break;
                case 2:
                    enfant.setDateNaissance(txtLigneItem.getText().toString());
                    break;
                case 3:
                    enfant.setAge(Integer.parseInt(txtLigneItem.getText().toString()));
                    break;
                case 4:
                    enfant.setTelephone(txtLigneItem.getText().toString());
                    break;
                case 5:
                    enfant.setAdresse(txtLigneItem.getText().toString());
                    break;
                case 6:
                    enfant.setVille(txtLigneItem.getText().toString());
                    break;
                case 7:
                    enfant.setProvince(txtLigneItem.getText().toString());
                    break;
                case 8:
                    enfant.setCodePostal(txtLigneItem.getText().toString());
                    break;
                case 9:
                    enfant.setAllergies(txtLigneItem.getText().toString());
                    break;
                case 10:
                    enfant.setParent1(txtLigneItem.getText().toString());
                    break;
                case 11:
                    enfant.setParent2(txtLigneItem.getText().toString());
                    break;
                case 12:
                    enfant.setParent3(txtLigneItem.getText().toString());
                    break;
                case 13:
                    enfant.setPersAutorisees(txtLigneItem.getText().toString());
                    break;
            }
        }

        enfant.setPresent(false);
        dbHelper.addEnfant(enfant);
        monIntent = new Intent(this, RegistreActivity.class);
        startActivity(monIntent);
    }
}
