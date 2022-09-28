package model;

import java.util.ArrayList;
import java.util.List;

public class RegistreEnfants {
    private static final RegistreEnfants instance = new RegistreEnfants();

    private static final ArrayList<Enfant> listEnfants = new ArrayList<>();

    private RegistreEnfants() {
        if (instance != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }
    public static RegistreEnfants getInstance() {
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
}
