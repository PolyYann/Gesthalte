package com.lebeau.gesthalte;

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

import model.Enfant;

public class ModifierActivity extends AppCompatActivity {
    private Intent monIntent;
    private ModifierAdapter modifierAdapter;
    private RecyclerView recyclerView;
    private Enfant enfant;
    private String[] label;
    private EnfantDBHelper dbHelper;
    private String[] champsEnfant;
    private Intent intent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        recyclerView = findViewById(R.id.recyclerModifier);

        label = new String[]{getString(R.string.name), getString(R.string.firstName),
                getString(R.string.DateNaissance), getString(R.string.age), getString(R.string.phone),
                getString(R.string.address), getString(R.string.city), getString(R.string.province),
                getString(R.string.zipCode), getString(R.string.allergy), getString(R.string.parent1),
                getString(R.string.parent2), getString(R.string.parent3), getString(R.string.authorizedPersons)};
        monIntent = getIntent();
        enfant = (Enfant) monIntent.getSerializableExtra("enfant");
        champsEnfant = new String[]{enfant.getNom(), enfant.getPrenom(), enfant.getDateNaissance(),
                String.valueOf(enfant.getAge()), enfant.getTelephone(), enfant.getAdresse(),
                enfant.getVille(), enfant.getProvince(), enfant.getCodePostal(), enfant.getAllergies(),
                enfant.getParent1(), enfant.getParent2(), enfant.getParent3(), enfant.getPersAutorisees()};


        if (enfant != null) {
            modifierAdapter = new ModifierAdapter(this, label, champsEnfant);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(modifierAdapter);

        } else {
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


    public void onEnregistrer(View view) {
        dbHelper = new EnfantDBHelper(this);
        EditText txtLigneItem;
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View v = recyclerView.getChildAt(i);
            txtLigneItem = v.findViewById(R.id.txtLigneItem);
            switch (i) {
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

        dbHelper.updateEnfant(enfant);

        intent = new Intent(this, RegistreActivity.class);
        startActivity(intent);
    }
}