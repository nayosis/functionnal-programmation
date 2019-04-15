package com.serli.workshop.functionnalprogrammation.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Serlian implements Serializable {

    private String id;
    private String nom;
    private String prenom;
    private String email;
    private List<String> roles;
    private List<String> recompenses;
    private List<String> competences;
    private List<Evenement> evenements;
    private String twitter;


    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRecompenses() {
        return recompenses;
    }

    public void setRecompenses(List<String> recompenses) {
        this.recompenses = recompenses;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serlian)) return false;
        Serlian serlian = (Serlian) o;
        return Objects.equals(id, serlian.id) &&
                Objects.equals(nom, serlian.nom) &&
                Objects.equals(prenom, serlian.prenom) &&
                Objects.equals(email, serlian.email) &&
                Objects.equals(roles, serlian.roles) &&
                Objects.equals(recompenses, serlian.recompenses) &&
                Objects.equals(competences, serlian.competences) &&
                Objects.equals(evenements, serlian.evenements) &&
                Objects.equals(twitter, serlian.twitter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, email, roles, recompenses, competences, evenements, twitter);
    }

    @Override
    public String toString() {
        return "Serlian{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", recompenses=" + recompenses +
                ", competences=" + competences +
                ", evenements=" + evenements +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
