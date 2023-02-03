/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 *
 * Esta clase es el modelo de vista de nuestro programa, es la parte "visual"
 * frente al cliente, aqui se implementa todo tipo de menu, mensaje y metodos
 * para que trabajen en conjunto con los controladores
 */
public class ProfileView {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'ás' HH:mm:ss");
    private int postsShowed = 10;
    private ProfileController profileController;

    /**
     * Este constructor se inicia pasando como parametro el objeto "profile
     * controler" para que la interfaz tenga interacción y comunicación con las
     * demas clases
     *
     * @param profileController
     */
    public ProfileView(ProfileController profileController) {
        this.profileController = profileController;
    }

    /**
     * Este método hace con que el usuario vea el perfil de algun usuario o, su
     * propio perfil, sacando mensajes por pantalla.
     */
    // AVISO    
    /*
    Modificaremos tamén os métodos "showProfileInfo" para que mostre a información completa do perfil 
    (incluíndo publicacións, comentarios, solicitudes de amizade, amizades e mensaxes) e "showProfileMenu" 
    para que mostre todas as opcións e chame a un método distinto para cada opción que se escolla. Ademais, 
    engadiranse os seguintes métodos:
     */
    private void showProfileInfo(boolean ownProfile, Profile profile) {
        /*
        Si está mirando su proprio perfil, entonces le damos una condicion 
        verdadera, que será llamada de ownprofile
         */
        if (ownProfile) {
            //aquí avisará que está mirando su propio perfil
            System.out.println("Estás vendo o teu propio perfil");
        } else {
            /*
            Pero si ownprofile es false, significa que esta mirando un perfil 
            por lo cual indicamos ese perfil llamando a getname y getstatus
             */
            System.out.println("Estás vendo o perfil de " + profile.getName());
        }
        System.out.println("Tu usuario: " + profile.getName());
        System.out.println("Tu estado: " + profile.getStatus());
    }

    /**
     * Este método permite que el usuario cambie de estado. Si own profile es
     * false, avisará que el estado solo se puede cambiar en su propia biografia
     */
    private void changeStatus(boolean ownProfile, Scanner scanner, Profile profile) {
        /*
        Si ownprofile es true, indica que el usuario está intentando cambiar su 
        propio estado, por lo cual el método sacará un scanner pidiendo los 
        datos.
         */
        if (ownProfile) {
            System.out.println("Actualiza o teu estado: ");
            String newStatus = scanner.next();
            profileController.updateProfileStatus(newStatus);
        } else {
            /*
            Si own profile es false, avisará que el estado solo se puede cambiar
            en su propia biografia.
             */
            System.out.println("Esta opción solo se pode utilizar no teu propio perfil");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método llama al método showProfileInfo y entrega opciones al
     * usuario. Las opciones serán cambiar de estado o cerrar sessión.
     *
     * @param profile
     */
    // AVISO    
    /*
    Modificaremos tamén os métodos "showProfileInfo" para que mostre a información completa do perfil 
    (incluíndo publicacións, comentarios, solicitudes de amizade, amizades e mensaxes) e "showProfileMenu" 
    para que mostre todas as opcións e chame a un método distinto para cada opción que se escolla. Ademais, 
    engadiranse os seguintes métodos:
     */
    public void showProfileMenu(Profile profile) {
        Scanner scan = new Scanner(System.in);

        showProfileInfo(true, profile);

        int select;

        do {
            System.out.println("1. Cambiar estado");
            System.out.println("2. Pechar a sesion");
            select = scan.nextInt();
            scan.nextLine();
        } while (select > 2);

        switch (select) {
            /*
            Si el usuario selecciona la opcion 1, que reciba un scanner para que
            pueda cambiar su estado.
             */
            case 1:
                changeStatus(true, scan, profile);
                break;
            /*
            Si el usuario selecciona la opcion 2, que simplemente cierre la 
            sesión y que salga del bucle.
             */
            case 2:
                break;
        }
    }

    /**
     * Método getter del atributo postsShowed.
     *
     * @return postsShowed
     */
    public int getPostsShowed() {
        return postsShowed;
    }

    /**
     * Método setter del atributo postsShowed
     *
     * @param postsShowed cantidad de posts a mostrar.
     */
    public void setPostsShowed(int postsShowed) {
        this.postsShowed = postsShowed;
    }

    private int selectElement(String text, int maxNumber, Scanner scanner) {
        return 0;
    }

    /**
     * Este método pide o texto para crear una nueva publicacion
     * 
     * @param scanner
     * @param profile 
     */
    private void writeNewPost(Scanner scanner, Profile profile) {
        System.out.println("Escribe o texto da publicacion");
    }

    /**
     * Este método introduce un comentario nun post
     * 
     * @param scanner
     * @param profile 
     */
    private void commentPost(Scanner scanner, Profile profile) {
        System.out.println("Selecciona unha publicacion");
        String text = scanner.next();
        profileController.newComment(null , text);
    }

    private void addLike(Scanner scanner, Profile profile) {
        System.out.println("Selecciona unha publicacion");
        scanner.nextInt();
        profileController.newLike(profile.getPosts().get(0));
    }

    private void showBiography(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            
        }
    }

    private void sendFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile) {
    }

    private void proccessFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile, boolean accept) {
    }

    private void sendPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
    }

    private void readPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
    }

    private void deletePrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
    }

    private void showOldPosts(Scanner scanner, Profile profile) {
    }

    public void showProfileNotFoundMessage() {
    }

    public void showCannotLikeOwnPostMessage() {
    }

    public void showAlreadyLikedPostMessage() {
    }

    public void showIsAlreadyFriendMessage(String profileName) {
    }

    public void showExistsFrienshipRequestMessage(String profileName) {
    }

    public void showDuplicateFrienshipRequestMessage(String profileName) {
    }
}
