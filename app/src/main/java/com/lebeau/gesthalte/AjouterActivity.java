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

    private String[] champsAjouter = {"Nom:", "Prénom:", "Date de naissance:", "Âge", "Téléphone:",
            "Adresse:", "Ville:", "Province:", "Code postal:", "Allergie(s):", "Parent 1:",
            "Parent 2:", "Parent 3:", "Personnes autorisées: "};

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
        Toast.makeText(AjouterActivity.this, "Enregistrement est à développer",
                Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int option = item.getItemId();
        switch (option) {
            case R.id.app_bar_search:
                break;
            case R.id.menuRegistre:
                monIntent = new Intent(AjouterActivity.this, RegistreActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuModifier:
                monIntent = new Intent(AjouterActivity.this, ModifierActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuAjouter:
                monIntent = new Intent(AjouterActivity.this, AjouterActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuPresences:
                monIntent = new Intent(AjouterActivity.this, PresencesActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuLocaux:
                Toast.makeText(this, "Gestion des locaux en developpement",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.menuHoraires:
                Toast.makeText(this, "Gestion des horaires en developpement",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}