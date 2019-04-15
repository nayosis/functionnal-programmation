package com.serli.workshop.functionnalprogrammation.dto;

import java.util.Objects;

public class Evenement {
    private String id;

    private String text;

    private String type;

    private String nom;

    private String client;

    private String date;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evenement)) return false;
        Evenement evenement = (Evenement) o;
        return Objects.equals(id, evenement.id) &&
                Objects.equals(text, evenement.text) &&
                Objects.equals(type, evenement.type) &&
                Objects.equals(nom, evenement.nom) &&
                Objects.equals(client, evenement.client) &&
                Objects.equals(date, evenement.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, type, nom, client, date);
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", client='" + client + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
