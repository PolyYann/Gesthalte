package model;

import static model.EnfantDBHelper.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DBA {
    private SQLiteDatabase db;
    private EnfantDBHelper helper;
    private Context context;
    private static RegistreEnfants registreEnfants;

    public DBA(Context context) {
        this.context = context;
        this.helper = new EnfantDBHelper(context, EnfantDBHelper.BD_NAME, null, EnfantDBHelper.VERSION);
    }

    public void openBD() {
        db = helper.getWritableDatabase();
    }

    public void closeBD() {
        db.close();
    }

    public void ajouterEnfant(Enfant enf){
        openBD();

        ContentValues cv = new ContentValues();
        cv.put(COL_NOM, enf.getNom());
        cv.put(COL_PRENOM, enf.getPrenom());
        cv.put(EnfantDBHelper.COL_DATE_NAISSANCE, enf.getDateNaissance());
        cv.put(EnfantDBHelper.COL_AGE, enf.getAge());
        cv.put(EnfantDBHelper.COL_TELEPHONE, enf.getTelephone());
        cv.put(EnfantDBHelper.COL_ADRESSE, enf.getAdresse());
        cv.put(EnfantDBHelper.COL_VILLE, enf.getVille());
        cv.put(EnfantDBHelper.COL_PROVINCE, enf.getProvince());
        cv.put(EnfantDBHelper.COL_CODE_POSTAL, enf.getCodePostal());
        cv.put(EnfantDBHelper.COL_ALLERGIES, enf.getAllergies());
        cv.put(EnfantDBHelper.COL_PARENT1, enf.getParent1());
        cv.put(EnfantDBHelper.COL_PARENT2, enf.getParent2());
        cv.put(EnfantDBHelper.COL_PARENT3, enf.getParent3());
        cv.put(EnfantDBHelper.COL_PERS_AUTORISEES, enf.getPersAutorisees());
        cv.put(EnfantDBHelper.COL_EST_PRESENT, enf.isPresent());
        db.insert(EnfantDBHelper.TABLE_E, null, cv);
        Toast.makeText(context, "Enfant ajouté", Toast.LENGTH_LONG).show();
        closeBD();
    }

    public void afficherEnfants(){
        openBD();
        //indiquer les colonnes du sélect
        String[] colonnes = {COL_ID, COL_NOM, COL_PRENOM, COL_DATE_NAISSANCE, COL_AGE, COL_TELEPHONE,
                COL_ADRESSE, COL_VILLE, COL_PROVINCE, COL_CODE_POSTAL, COL_ALLERGIES, COL_PARENT1,
                COL_PARENT2, COL_PARENT3, COL_PERS_AUTORISEES, COL_EST_PRESENT};
        Cursor cursor = db.query(EnfantDBHelper.TABLE_E, colonnes, null, null, null, null, null);
        //parcourir le curseur et remplir le registre mémoire
        boolean estPresent;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String nom = cursor.getString(1);
            String prenom = cursor.getString(2);
            String dateNaissance = cursor.getString(3);
            int age = cursor.getInt(4);
            String telephone = cursor.getString(5);
            String adresse = cursor.getString(6);
            String ville = cursor.getString(7);
            String province = cursor.getString(8);
            String codePostal = cursor.getString(9);
            String allergies = cursor.getString(10);
            String parent1 = cursor.getString(11);
            String parent2 = cursor.getString(12);
            String parent3 = cursor.getString(13);
            String persAutorisees = cursor.getString(14);
            int present = cursor.getInt(15);
            if(present==1){
                estPresent = true;
            }else {
                estPresent = false;
            }
            Enfant enf = new Enfant(id, nom, prenom, dateNaissance, age, telephone, adresse, ville,
                    province, codePostal, allergies, parent1, parent2, parent3, persAutorisees, estPresent);
            registreEnfants.ajouterEnfant(enf);
              cursor.moveToNext();
        }
    }
}
