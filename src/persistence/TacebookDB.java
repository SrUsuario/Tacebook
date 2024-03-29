/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.util.ArrayList;
import model.Profile;

/**
 *
 * Esta clase guarda unicamente un arrayList de objetos "profile" de la clase
 * "Profile". Esta es la clase de persistencia de datos, para almacenar todos
 * los cambios.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class TacebookDB {

    /**
     * Este es el arraylist que guardará todos los perfiles
     */
    private static ArrayList<Profile> profiles = new ArrayList<>();

    /**
     * Este método es el getter de arrayList profiles, este método es crucial
     * para trabajar con las otras clases, porque con el vamos siempre a hacer
     * llamadas a este arrayList para recibir e entregar datos.
     *
     * @return Devolve o objecto profile
     * @throws persistence.PersistenceException
     */
    public static ArrayList<Profile> getProfiles() throws PersistenceException {
        return profiles;
    }

    /**
     * Este metodo cierra la conexion con la base de datos, aunque de momento
     * no hace nada
     */
    public static void close() {
    }

}
