package fr.eni.bll;
import fr.eni.bllException.BLLException;
import fr.eni.bo.Todo;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.TodoDAO;

import java.util.List;

/*
Le manager qui est ds la BLL appelle la Factory pour avoir une instance du DAO
 */

public class TodoManager {
    // Attribut d'instance
    private TodoDAO todoDAO2 = DAOFactory.getTodoDAO();

    // singleton : (pour faire un singleton,
    // il faut un constructeur vide privé et une méthode get instance)
    private static TodoManager instance;

    // constructeur vide
    public TodoManager() {
    }

    //une méthode get instance
    public static TodoManager getInstance(){
        if (instance == null) {
            instance = new TodoManager();
        }
        return instance;
    }

    // une méthode pour afficher une liste
    public List<Todo> getTodo() throws BLLException, DALException {
        return todoDAO2.selectAll();
    }





}

