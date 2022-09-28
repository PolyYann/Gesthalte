package model;

import java.util.ArrayList;
import java.util.List;

public class RegistreEnfants {
    private static final RegistreEnfants instance = new RegistreEnfants();

    private final ArrayList<Enfant> listEnfants = new ArrayList<>();

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
    public Enfant modifierEnfant(Enfant enfant) {
        for (Enfant e : listEnfants) {
            if (e.get_id() == enfant.get_id()) {
                e.setNom(enfant.getNom());
                e.setPrenom(enfant.getPrenom());
                e.setDateNaissance(enfant.getDateNaissance());
                e.setAge(enfant.getAge());
                e.setTelephone(enfant.getTelephone());
                e.setAdresse(enfant.getAdresse());
                e.setVille(enfant.getVille());
                e.setProvince(enfant.getProvince());
                e.setCodePostal(enfant.getCodePostal());
                e.setAllergies(enfant.getAllergies());
                e.setParent1(enfant.getParent1());
                e.setParent2(enfant.getParent2());
                e.setParent3(enfant.getParent3());
                e.setPersAutorisees(enfant.getPersAutorisees());
                e.setPresent(enfant.isPresent());
                return e;
            }
        }
        return null;
    }
}
