package fr.eni.dal;

/*
    Je demande à la Factory de me donner une instance de ma DAO que j'appelle ici todoDAO2
    C'est un nouvele objet
 */

import fr.eni.dal.jdbc.TodoDAOJdbcImpl;

public class DAOFactory {
    public static TodoDAO getTodoDAO(){
        TodoDAO todoDAO2 = new TodoDAOJdbcImpl();
        return todoDAO2;
    }
}
