package utils;

import controller.ControllerImplementation;
import model.dao.DAOArrayList;
import model.dao.DAOHashMap;
import view.DataStorageSelection;

/**
 *
 * @author aniol
 */
public class Constants {

    private void handleDataStorageSelection() {
        // Declaracion de variables
    private final String ARRAYLIST_SELECTED = "ArrayList";
    private final String HASHMAP_SELECTED = "HashMap";
    private final String FILE_SELECTED = "File";
    private final String FILE_SERIALIZATION_SELECTED = "File (Serialization)";
    private final String SQL_DATABASE_SELECTED = "SQL - Database";
    private final String JPA_DATABASE_SELECTED = "JPA - Database";

    String daoSelected = ((javax.swing.JCheckBox) (dSS.getAccept()[1])).getText();

    dSS.dispose ();

    switch (daoSelected) {
        case ARRAYLIST_SELECTED:
            dao = new DAOArrayList();
            break;
        case HASHMAP_SELECTED:
            dao = new DAOHashMap();
            break;
        case FILE_SELECTED:
            setupFileStorage();
            break;
        case FILE_SERIALIZATION_SELECTED:
            setupFileSerialization();
            break;
        case SQL_DATABASE_SELECTED:
            setupSQLDatabase();
            break;
        case JPA_DATABASE_SELECTED:
            setupJPADatabase();
            break;
    }
            setupMenu();
}
}
