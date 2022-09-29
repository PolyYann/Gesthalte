package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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

    //ddl table
    public static final String DDL_ENFANT = "CREATE TABLE " + TABLE_E + " " +
            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT, " + COL_PRENOM + " TEXT, "
            + COL_DATE_NAISSANCE + " TEXT, " + COL_AGE + " INTEGER, " + COL_TELEPHONE + " TEXT, " + COL_ADRESSE +
            " TEXT, " + COL_VILLE + " TEXT, " + COL_PROVINCE + " TEXT, " + COL_CODE_POSTAL + " TEXT, " +
            "" + COL_ALLERGIES + " TEXT, " + COL_PARENT1 + " TEXT, " + COL_PARENT2 + " TEXT, " + COL_PARENT3 +
            " TEXT, " + COL_PERS_AUTORISEES + " TEXT, " + COL_EST_PRESENT + " INTEGER);";

    ;

    public EnfantDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DDL_ENFANT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
