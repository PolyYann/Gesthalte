package com.lebeau.gesthalte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.CustomListAdapter;
import model.DBAdapter;
import model.Enfant;
import model.RegistreEnfants;

public class RegistreActivity extends AppCompatActivity {
 private Intent monIntent;
 private ListView listViewRegistre;
 private CustomListAdapter adapter;
 private List<String> nomComplets = new ArrayList<>();
private DBAdapter dbAdapter;
 private RegistreEnfants registreEnfants;
private static boolean isActionMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        registreEnfants = RegistreEnfants.getInstance();
        getNomComplets();
        listViewRegistre = findViewById(R.id.listViewRegistre);
        listViewRegistre.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listViewRegistre.setMultiChoiceModeListener(modeListener);
        adapter = new CustomListAdapter(nomComplets, this);
        listViewRegistre.setAdapter(adapter);

    }
    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    };

    private void getNomComplets(){
        for (Enfant enfant : registreEnfants.getEnfants()) {

            nomComplets.add(enfant.getPrenom()+" "+enfant.getNom());
        }
    }

//    public void onCheckboxClick(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//
//        switch (view.getId()) {
//
//            case R.id.chkPresent:
//                int id = view.getId();
//                if (checked) {
//                    dbAdapter.modifierPresence(true, id);
//                } else {
//                    dbAdapter.modifierPresence(false,id);
//                }
//                break;
//
//            default:
//                throw new IllegalStateException("Unexpected value: " + view.getId());
//        }
//    }

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
            case R.id.menuAccueil:
                monIntent = new Intent(this, MainActivity.class);
                startActivity(monIntent);
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
}