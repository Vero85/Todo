package fr.eni.dal;

import fr.eni.bo.Todo;
import java.util.List;

/*
    INTERFACE ds laquelle je mets mes méthodes vides.
 */

public interface TodoDAO {
    //Création de la méthode vide insert
    void insert(Todo todo);

    //Création de la liste
    List<Todo> selectAll();


}
