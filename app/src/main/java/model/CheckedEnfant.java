package model;

public class CheckedEnfant {
    private String nomComplet;
    private boolean isPresent;

    public CheckedEnfant(String nomComplet, boolean isPresent) {
        this.nomComplet = nomComplet;
        this.isPresent = isPresent;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
