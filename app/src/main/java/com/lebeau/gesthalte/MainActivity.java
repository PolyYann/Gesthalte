package com.lebeau.gesthalte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Intent monIntent;

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
            case R.id.menuRegistre:
                monIntent = new Intent(MainActivity.this, RegistreActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuModifier:
                monIntent = new Intent(MainActivity.this, ModifierActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuAjouter:
                monIntent = new Intent(MainActivity.this, AjouterActivity.class);
                startActivity(monIntent);
                break;
            case R.id.menuPresences:
                Toast.makeText(this, "Gestion des présences en developpement",
                        Toast.LENGTH_LONG).show();
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