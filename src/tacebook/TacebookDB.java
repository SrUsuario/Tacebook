/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class TacebookDB {

    private static ArrayList<Profile> profiles = new ArrayList<>();

    /**
     * Getter del arrayList profiles, este método es crucial para trabajar con
     * las otras clases, porque con el vamos siempre hacer llamadas a este
     * arrayList para recibir y entregar datos.
     *
     * @return el objeto profile
     */
    public static ArrayList<Profile> getProfiles() {
        return profiles;
    }

}
