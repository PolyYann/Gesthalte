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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import model.Enfant;

public class AjouterActivity extends AppCompatActivity {

    private Intent monIntent;
    private SimpleAdapter simpleAdapter;
    private EditText txtLigneItem;
    private ListView listViewAjouter;
    private Button btnAjouter;
    private ArrayList<HashMap<String, String> >listeChampsAjouter = new ArrayList<>(); ;

    private String[] label;
    private String[] plainTexts ={"","","","","","","","","","","","","",""};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        label = new String[]{getString(R.string.name), getString(R.string.firstName),
                getString(R.string.DateNaissance), getString(R.string.age), getString(R.string.phone),
                getString(R.string.address), getString(R.string.city), getString(R.string.province),
                getString(R.string.zipCode), getString(R.string.allergy), getString(R.string.parent1),
                getString(R.string.parent2), getString(R.string.parent3), getString(R.string.authorizedPersons)};

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

    public void onAjouter(View view) {
        //creer enfant
        EnfantDBHelper enfantDBHelper = new EnfantDBHelper(this);
        Enfant enfant = new Enfant();
        enfant.setNom(listeChampsAjouter.get(0).get("plainText"));
        Toast.makeText(AjouterActivity.this, listeChampsAjouter.get(0).get("plainText"),
                Toast.LENGTH_LONG).show();
        enfant.setPrenom(listeChampsAjouter.get(1).get("plainText"));
        enfant.setDateNaissance(listeChampsAjouter.get(2).get("plainText"));
        enfant.setAge(Integer.parseInt(listeChampsAjouter.get(3).get("plainText")));
        enfant.setTelephone(listeChampsAjouter.get(4).get("plainText"));
        enfant.setAdresse(listeChampsAjouter.get(5).get("plainText"));
        enfant.setVille(listeChampsAjouter.get(6).get("plainText"));
        enfant.setProvince(listeChampsAjouter.get(7).get("plainText"));
        enfant.setCodePostal(listeChampsAjouter.get(8).get("plainText"));
        enfant.setAllergies(listeChampsAjouter.get(9).get("plainText"));
        enfant.setParent1(listeChampsAjouter.get(10).get("plainText"));
        enfant.setParent2(listeChampsAjouter.get(11).get("plainText"));
        enfant.setParent3(listeChampsAjouter.get(12).get("plainText"));
        enfant.setPersAutorisees(listeChampsAjouter.get(13).get("plainText"));
        enfant.setPresent(false);
        //ajouter enfant dans la bd
        enfantDBHelper.addEnfant(enfant);
    }
}