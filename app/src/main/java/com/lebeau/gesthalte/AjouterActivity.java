package com.lebeau.gesthalte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class AjouterActivity extends AppCompatActivity {

    private Intent monIntent;
    private SimpleAdapter simpleAdapter;

    private ListView listViewAjouter;

    private ArrayList<HashMap<String, String> > listeChampsAjouter = new ArrayList<>();

    private String[] champsAjouter = {getString(R.string.name), getString(R.string.firstName),
            getString(R.string.DateNaissance), getString(R.string.age), getString(R.string.phone),
            getString(R.string.address), getString(R.string.city), getString(R.string.province),
            getString(R.string.zipCode), getString(R.string.allergy), getString(R.string.parent1),
            getString(R.string.parent2), getString(R.string.parent3), getString(R.string.authorizedPersons)};

    private String[] plainTexts ={"", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        setWidgets();
        setListeners();
    }

    private void setListeners() {
        listViewAjouter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AjouterActivity.this, champsAjouter[i], Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setWidgets() {
        //écouter ce qui va se passer dans le id listingView
        listViewAjouter = findViewById(R.id.listViewAjouter);
        String[] from = {"label", "plainText"};
        int[] to = {R.id.lblLigneItem, R.id.txtLigneItem} ;
        //construire la liste
        for(int i=0 ; i< champsAjouter.length; i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("label", champsAjouter[i]);
            map.put("plainText", plainTexts[i]);
            listeChampsAjouter.add(map);

        }
        simpleAdapter = new SimpleAdapter(AjouterActivity.this, listeChampsAjouter,
                R.layout.ligne_item_ajouter, from, to );
        listViewAjouter.setAdapter(simpleAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEnregistrer(){
        Toast.makeText(AjouterActivity.this, R.string.saving_Construction,
                Toast.LENGTH_LONG).show();

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
            case R.id.menuModifier:
                monIntent = new Intent(this, ModifierActivity.class);
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
        }
        return super.onOptionsItemSelected(item);
    }
}