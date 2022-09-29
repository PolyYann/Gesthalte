package model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class RegistreEnfants {
    private static final RegistreEnfants instance = new RegistreEnfants();

    private static final ArrayList<Enfant> listEnfants = new ArrayList<>();
    private static final ArrayList<Enfant> mockEnfants = new ArrayList<>(List.of(new Enfant("Dupont", "Jean", "datenaissance",24,"telephone","addresse","ville","province","codePost","allergies", "parent1","parent2","parent3","persAuth",false),new Enfant("Dupont", "Jean", "datenaissance",24,"telephone","addresse","ville","province","codePost","allergies", "parent1","parent2","parent3","persAuth",false)
            ,new Enfant("Dupont1", "Jean", "datenaissance",24,"telephone","addresse","ville","province","codePost","allergies", "parent1","parent2","parent3","persAuth",false),
            new Enfant("Dupont2", "Jean", "datenaissance",24,"telephone","addresse","ville","province","codePost","allergies", "parent1","parent2","parent3","persAuth",false),
            new Enfant("Dupont3", "Jean", "datenaissance",24,"telephone","addresse","ville","province","codePost","allergies", "parent1","parent2","parent3","persAuth",false),
            new Enfant("Dupont4", "Jean", "datenaissance",24,"telephone","addresse","ville","province","codePost","allergies", "parent1","parent2","parent3","persAuth",false),
            new Enfant("Dupont5", "Jean", "datenaissance",24,"telephone","addresse","ville","province","codePost","allergies", "parent1","parent2","parent3","persAuth",false)));
    private RegistreEnfants() {

        if (instance != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }
    public static RegistreEnfants getInstance() {
        listEnfants.addAll(mockEnfants);
        return instance;
    }
    public void ajouterEnfant(Enfant enfant) {
        listEnfants.add(enfant);
    }
    public void supprimerEnfant(Enfant enfant) {
        listEnfants.remove(enfant);
    }
    public Enfant afficherEnfant(int id) {
        return listEnfants.get(id);
    }
    public List<Enfant> getEnfants(Context context) {
        return listEnfants;
    }

}
