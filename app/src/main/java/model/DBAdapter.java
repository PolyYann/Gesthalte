package model;

import static model.EnfantDBHelper.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DBAdapter {
    private SQLiteDatabase db;
    private EnfantDBHelper helper;
    private Context context;
    private static RegistreEnfants registreEnfants;

    public DBAdapter(Context context) {
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
        registreEnfants = RegistreEnfants.getInstance();
        registreEnfants.ajouterEnfant(enf);
        ContentValues cv = new ContentValues();
        cv.put(COL_NOM, enf.getNom());
        cv.put(COL_PRENOM, enf.getPrenom());
        cv.put(COL_DATE_NAISSANCE, enf.getDateNaissance());
        cv.put(COL_AGE, enf.getAge());
        cv.put(COL_TELEPHONE, enf.getTelephone());
        cv.put(COL_ADRESSE, enf.getAdresse());
        cv.put(COL_VILLE, enf.getVille());
        cv.put(COL_PROVINCE, enf.getProvince());
        cv.put(COL_CODE_POSTAL, enf.getCodePostal());
        cv.put(COL_ALLERGIES, enf.getAllergies());
        cv.put(COL_PARENT1, enf.getParent1());
        cv.put(COL_PARENT2, enf.getParent2());
        cv.put(COL_PARENT3, enf.getParent3());
        cv.put(COL_PERS_AUTORISEES, enf.getPersAutorisees());
        cv.put(COL_EST_PRESENT, enf.isPresent());
        db.insert(TABLE_E, null, cv);
        Toast.makeText(context, "Enfant ajouté", Toast.LENGTH_LONG).show();
        closeBD();
    }
    public void updaterBd(Enfant enfant){
        openBD();

        ContentValues values = new ContentValues();


        values.put(COL_NOM, enfant.getNom());
        values.put(COL_PRENOM, enfant.getPrenom());
        values.put(COL_DATE_NAISSANCE, enfant.getDateNaissance());
        values.put(COL_AGE, enfant.getAge());
        values.put(COL_TELEPHONE, enfant.getTelephone());
        values.put(COL_ADRESSE, enfant.getAdresse());
        values.put(COL_VILLE, enfant.getVille());
        values.put(COL_PROVINCE, enfant.getProvince());
        values.put(COL_CODE_POSTAL, enfant.getCodePostal());
        values.put(COL_ALLERGIES, enfant.getAllergies());
        values.put(COL_PARENT1, enfant.getParent1());
        values.put(COL_PARENT2, enfant.getParent2());
        values.put(COL_PARENT3, enfant.getParent3());
        values.put(COL_PERS_AUTORISEES, enfant.getPersAutorisees());
        if(enfant.isPresent()){
            values.put(COL_EST_PRESENT, 1);
        }else{
            values.put(COL_EST_PRESENT, 0);
        }

        db.update(TABLE_E, values, COL_ID + "='" + enfant.get_id() + "'", null);
        Toast.makeText(context, "Modifié", Toast.LENGTH_LONG).show();
        db.close();



    }





    public void modifierPresence(boolean present, int id){
        openBD();
        ContentValues values = new ContentValues();
        values.put(COL_EST_PRESENT, present);
        db.update(TABLE_E, values, COL_ID + "='" + id + "'", null);
        Toast.makeText(context, "Presence modifiée", Toast.LENGTH_LONG).show();
        closeBD();
    }


}
