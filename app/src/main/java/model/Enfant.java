package model;

import java.io.Serializable;

public class Enfant implements Serializable {
    private int _id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private int age;
    private String telephone;
    private String adresse;
    private String ville;
    private String province;
    private String codePostal;
    private String allergies;
    private String parent1;
    private String parent2;
    private String parent3;
    private String persAutorisees;
    private boolean present ;
    public Enfant() {
    }

    public Enfant(String nom, String prenom, String dateNaissance, int age, String telephone,
                  String adresse, String ville, String province, String codePostal, String allergies,
                  String parent1, String parent2, String parent3, String persAutorisees, Boolean present) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.age = age;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
        this.province = province;
        this.codePostal = codePostal;
        this.allergies = allergies;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.parent3 = parent3;
        this.persAutorisees = persAutorisees;
        this.present = present;
    }

    public Enfant(int _id, String nom, String prenom, String dateNaissance, int age, String telephone,
                  String adresse, String ville, String province, String codePostal, String allergies,
                  String parent1, String parent2, String parent3, String persAutorisees, boolean present) {
        this._id = _id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.age = age;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
        this.province = province;
        this.codePostal = codePostal;
        this.allergies = allergies;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.parent3 = parent3;
        this.persAutorisees = persAutorisees;
        this.present = present;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getParent1() {
        return parent1;
    }

    public void setParent1(String parent1) {
        this.parent1 = parent1;
    }

    public String getParent2() {
        return parent2;
    }

    public void setParent2(String parent2) {
        this.parent2 = parent2;
    }

    public String getParent3() {
        return parent3;
    }

    public void setParent3(String parent3) {
        this.parent3 = parent3;
    }

    public String getPersAutorisees() {
        return persAutorisees;
    }

    public void setPersAutorisees(String persAutorisees) {
        this.persAutorisees = persAutorisees;
    }
}
