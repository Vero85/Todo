package fr.eni.dal.jdbc;

import fr.eni.bo.Todo;
import fr.eni.dal.DALException;
import fr.eni.dal.TodoDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

    /*
    Contrat d'obligation qui implémente l'interface TodoDAO.
    - appel à l'url via Setting
    - création des requêtes SQL
    - création des méthodes
    */

public class TodoDAOJdbcImpl implements TodoDAO {
    private final String URL = Settings.getPropriete("url");
    private final String SQL_INSERT = "INSERT INTO Todo" + "(datetime, texte, id) " + "VALUES(?,?,?)";
    private final String SELECT_ALL = "SELECT * FROM table_todo;";

    public void insert(Todo todo) {
        try (
                Connection connection = JdbcTools.Connection();
                PreparedStatement etat = connection.prepareStatement(this.SQL_INSERT);
        ) {
            // Je fixe les valeurs des paramètres
            etat.setDate(1, Date.valueOf(todo.getDate()));
            etat.setString(2, todo.getTexte());
            etat.setInt(3, Integer.parseInt(String.valueOf(todo.getId())));

            etat.executeUpdate(); // j'exécute la méthode insert
            // J'exécute un état sans modification (que de l'affichage)
            ResultSet rs = etat.executeQuery("insert datetime, texte, id from Table_todo");
            // j'exploite le résultat et me déplace avec next ds les lignes
            if (rs.next()) {
                Date date = rs.getDate(1);
                String texte = rs.getString(2);
                Integer id = rs.getInt(3);
                // je mets les infos grace aux setters
                todo.setDate(date);
                todo.setTexte(texte);
                todo.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    Sélectionne tous les champs de la table todo
     */

    public ArrayList<Todo> selectAll() {
        List <Todo> maListe = new ArrayList<>();
        try (Connection connection = JdbcTools.Connection()) {
                PreparedStatement etat = connection.prepareStatement(this.SELECT_ALL);
                ResultSet rs = PreparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getDate("date") == null) {
                    maListe.add(new Todo(rs.getDate("date"),
                            rs.getString("texte"),
                            rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Todo>) maListe;
    }






}
