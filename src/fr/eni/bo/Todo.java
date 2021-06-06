package fr.eni.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Todo {
    /*
    attributs de la classe
     */

    public LocalDate date;
    public int id;
    public String texte;

    /*
    Constructeur
     */

    public Todo(LocalDate date, String texte) {
        this.date = date;
        this.texte = texte;
    }

    public Todo(String texte) {
        this.texte = texte;
    }

    public Todo(LocalDate date, int id, String texte) {
        this.date = date;
        this.id = id;
        this.texte = texte;
    }

    /*
    GETTERS
     */

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    /*
    SETTERS
     */

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
