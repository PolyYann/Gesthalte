package com.lebeau.gesthalte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import model.DBAdapter;
import model.Enfant;
import model.RegistreEnfants;

public class RegistreActivity extends AppCompatActivity {
 private Intent monIntent;
 private SimpleAdapter simpleAdapter;
 private AdapterView listViewRegistre;
 private CheckBox chkPresent;
    private DBAdapter dbAdapter;
    private ArrayList<HashMap<String, String>> listeChampsRegistre = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        setListener();
        setWigets();
    }

    private void setListener() {
        listViewRegistre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //todo intent vers modifier
            }
        });    }

    private void setWigets() {
        monIntent = getIntent();
        listViewRegistre = findViewById(R.id.listViewRegistre);
        chkPresent = findViewById(R.id.chkPresent);
        for(Enfant e : RegistreEnfants.getInstance().getEnfants()){
            String nomComplet = e.getPrenom() + " " + e.getNom();
            if(e.isPresent()) {
               chkPresent = findViewById(R.id.chkPresent);
               chkPresent.isChecked();
            }

        }

        listViewRegistre.setAdapter(simpleAdapter);
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
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCheckboxClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {

            case R.id.chkPresent:
                int id = view.getId();
                if (checked) {
                    dbAdapter.modifierPresence(true, id);
                } else {
                    dbAdapter.modifierPresence(false,id);
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}