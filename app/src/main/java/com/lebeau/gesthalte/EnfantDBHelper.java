package com.lebeau.gesthalte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import model.Enfant;

public class EnfantDBHelper extends SQLiteOpenHelper {
    //déclaration des Constantes
    public static final String BD_NAME = "Halte";
    public static final int VERSION = 1;
    //table
    public static final String TABLE_E = "enfant";
    //colonnes
    public static final String COL_ID = "_id";
    public static final String COL_NOM = "nom";
    public static final String COL_PRENOM = "prenom";
    public static final String COL_DATE_NAISSANCE = "date_naissance";
    public static final String COL_AGE = "age";
    public static final String COL_TELEPHONE = "telephone";
    public static final String COL_ADRESSE = "adresse";
    public static final String COL_VILLE = "ville";
    public static final String COL_PROVINCE = "province";
    public static final String COL_CODE_POSTAL = "code_postal";
    public static final String COL_ALLERGIES = "allergies";
    public static final String COL_PARENT1 = "parent1";
    public static final String COL_PARENT2 = "parent2";
    public static final String COL_PARENT3 = "parent3";
    public static final String COL_PERS_AUTORISEES = "personnes_autorisees";
    public static final String COL_EST_PRESENT = "est_present";
    private SQLiteDatabase sqLiteDatabase;
    //ddl table
    private static final String DDL_ENFANT = "CREATE TABLE " + TABLE_E + " " +
            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT, " + COL_PRENOM + " TEXT, "
            + COL_DATE_NAISSANCE + " TEXT, " + COL_AGE + " INTEGER, " + COL_TELEPHONE + " TEXT, " + COL_ADRESSE +
            " TEXT, " + COL_VILLE + " TEXT, " + COL_PROVINCE + " TEXT, " + COL_CODE_POSTAL + " TEXT, " +
            "" + COL_ALLERGIES + " TEXT, " + COL_PARENT1 + " TEXT, " + COL_PARENT2 + " TEXT, " + COL_PARENT3 +
            " TEXT, " + COL_PERS_AUTORISEES + " TEXT, " + COL_EST_PRESENT + " INTEGER);";

    ;

    public EnfantDBHelper(@Nullable Context context) {
        super(context, BD_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DDL_ENFANT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_E);
        onCreate(db);
    }
    public void addEnfant(Enfant enfant){
        ContentValues contentValues = new ContentValues();
        contentValues.put(EnfantDBHelper.COL_NOM, enfant.getNom());
        contentValues.put(EnfantDBHelper.COL_PRENOM, enfant.getPrenom());
        contentValues.put(EnfantDBHelper.COL_DATE_NAISSANCE, enfant.getDateNaissance());
        contentValues.put(EnfantDBHelper.COL_AGE, enfant.getAge());
        contentValues.put(EnfantDBHelper.COL_TELEPHONE, enfant.getTelephone());
        contentValues.put(EnfantDBHelper.COL_ADRESSE, enfant.getAdresse());
        contentValues.put(EnfantDBHelper.COL_VILLE, enfant.getVille());
        contentValues.put(EnfantDBHelper.COL_PROVINCE, enfant.getProvince());
        contentValues.put(EnfantDBHelper.COL_CODE_POSTAL, enfant.getCodePostal());
        contentValues.put(EnfantDBHelper.COL_ALLERGIES, enfant.getAllergies());
        contentValues.put(EnfantDBHelper.COL_PARENT1, enfant.getParent1());
        contentValues.put(EnfantDBHelper.COL_PARENT2, enfant.getParent2());
        contentValues.put(EnfantDBHelper.COL_PARENT3, enfant.getParent3());
        contentValues.put(EnfantDBHelper.COL_PERS_AUTORISEES, enfant.getPersAutorisees());
        contentValues.put(EnfantDBHelper.COL_EST_PRESENT, enfant.isPresent());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(EnfantDBHelper.TABLE_E, null,contentValues);
    }
    public List<Enfant> getAllEnfants(){
        String sql = "Select * from " +TABLE_E;
        sqLiteDatabase = this.getReadableDatabase();
        List<Enfant> enfantList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Enfant enfant = new Enfant();
                enfant.set_id(cursor.getInt(0));
                enfant.setNom(cursor.getString(1));
                enfant.setPrenom(cursor.getString(2));
                enfant.setDateNaissance(cursor.getString(3));
                enfant.setAge(cursor.getInt(4));
                enfant.setTelephone(cursor.getString(5));
                enfant.setAdresse(cursor.getString(6));
                enfant.setVille(cursor.getString(7));
                enfant.setProvince(cursor.getString(8));
                enfant.setCodePostal(cursor.getString(9));
                enfant.setAllergies(cursor.getString(10));
                enfant.setParent1(cursor.getString(11));
                enfant.setParent2(cursor.getString(12));
                enfant.setParent3(cursor.getString(13));
                enfant.setPersAutorisees(cursor.getString(14));
                if(cursor.getInt(15) == 1){
                    enfant.setPresent(true);
                }else{
                    enfant.setPresent(false);
                }
                enfantList.add(enfant);
            }while(cursor.moveToNext());
        }
        cursor.close();
        for(Enfant enfant : enfantList){
            Log.d("EnfantDBHelper", "getAllEnfants: " + enfant.get_id());
        }
        return enfantList;
    }


}
