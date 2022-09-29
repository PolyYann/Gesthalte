package com.lebeau.gesthalte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import model.DBAdapter;
import model.Enfant;

public class AjouterActivity extends AppCompatActivity {

    private Intent monIntent;
    private SimpleAdapter simpleAdapter;
    private DBAdapter dbAdapter;
    private ListView listViewAjouter;
    private Button btnAjouter;
    private ArrayList<HashMap<String, String> >listeChampsAjouter = new ArrayList<>(); ;

    private String[] label;
    private String[] plainTexts ={"Cailloux", "Agathe", "2020-02-20", "19", "(123)456-7890", "12 carrieres", "St-Granite",  "Quebec","J1P 2P2", "roche", "Fred Cailloux", "Délima Cailloux", "aucun", "Arthur LaRoche"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        label = new String[]{getString(R.string.name), getString(R.string.firstName),
                getString(R.string.DateNaissance), getString(R.string.age), getString(R.string.phone),
                getString(R.string.address), getString(R.string.city), getString(R.string.province),
                getString(R.string.zipCode), getString(R.string.allergy), getString(R.string.parent1),
                getString(R.string.parent2), getString(R.string.parent3), getString(R.string.authorizedPersons)};
        dbAdapter = new DBAdapter(this);
        setWidgets();
        setListeners();
    }

    private void setListeners() {
        listViewAjouter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AjouterActivity.this, label[i], Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setWidgets() {
        //écouter ce qui va se passer dans le id listingView
        btnAjouter = findViewById(R.id.btnAjouter);
        listViewAjouter = findViewById(R.id.listViewAjouter);
        String[] from = {"label", "plainText"};
        int[] to = {R.id.lblLigneItem, R.id.txtLigneItem} ;
        //construire la liste
        for(int i = 0; i< label.length; i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("label", label[i]);
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

    public void onAjouter(View view) {
        //creer enfant
        Enfant enfant = new Enfant();
        enfant.setNom(plainTexts[0]);
        enfant.setPrenom(plainTexts[1]);
        enfant.setDateNaissance(plainTexts[2]);
        enfant.setAge(Integer.parseInt(plainTexts[3]));
        enfant.setTelephone(plainTexts[4]);
        enfant.setAdresse(plainTexts[5]);
        enfant.setVille(plainTexts[6]);
        enfant.setProvince(plainTexts[7]);
        enfant.setCodePostal(plainTexts[8]);
        enfant.setAllergies(plainTexts[9]);
        enfant.setParent1(plainTexts[10]);
        enfant.setParent2(plainTexts[11]);
        enfant.setParent3(plainTexts[12]);
        enfant.setPersAutorisees(plainTexts[13]);
        enfant.setPresent(false);
        //ajouter enfant dans la bd
        dbAdapter.ajouterEnfant(enfant);
        Toast.makeText(AjouterActivity.this, "ajouter", Toast.LENGTH_LONG).show();
    }
}