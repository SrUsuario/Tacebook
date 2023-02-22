/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Esta clase es el modelo de vista de nuestro programa, es la parte "visual"
 * frente al cliente, aqui se implementa todo tipo de menu, mensaje y metodos
 * para que trabajen en conjunto con los controladores
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class ProfileView {

    /**
     * El formato de la fecha
     */
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'ás' HH:mm:ss");
    /**
     * Los posts a visualizar
     */
    private int postsShowed = 10;
    /**
     * Mantiene la referencia al objecto controlador (ProfileController)
     */
    private ProfileController profileController;

    /**
     * Este constructor se inicia pasando como parametro el objeto "profile
     * controler" para que la interfaz tenga interacción y comunicación con las
     * demas clases
     *
     * @param profileController mantiene la referencia al objecto controlador
     * (ProfileController)
     */
    public ProfileView(ProfileController profileController) {
        this.profileController = profileController;
    }

    /**
     * Getter del atributo postsShowed
     *
     * @return postsShowed
     */
    public int getPostsShowed() {
        return postsShowed;
    }

    /**
     * Setter del atributo postsShowed
     *
     * @param postsShowed cantidad de posts a mostrar
     */
    public void setPostsShowed(int postsShowed) {
        this.postsShowed = postsShowed;
    }

    /**
     * Este método hace con que el usuario vea el perfil de algun usuario o, su
     * propio perfil, sacando mensajes por pantalla.
     *
     * @param ownProfile si está en su perfil o no
     * @param profile el perfil que muesta la información
     *
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

        /*
        Condición if si hay mensajes
         */
        if (!profile.getMessages().isEmpty()) {
            System.out.println("---> Hai mensaxes recibidas");
            System.out.println("");
            System.out.println("---> Mensaxes:");
        }

        /*
        Bucle for para los mensajes
         */
        for (int i = 0; i < profile.getMessages().size(); i++) {
            System.out.println("");
            System.out.println("Fecha:" + profile.getMessages().get(i).getDate());
            System.out.println("De: " + profile.getMessages().get(i).getSourceProfile());
            System.out.println("Para: " + profile.getMessages().get(i).getDestProfile());
            System.out.println(profile.getMessages().get(i).getId() + " " + profile.getMessages().get(i).getText());
            System.out.println("-------------------------------------------------------------------");
        }

        /*
        Condición if si hay solicitudes de amistad
         */
        if (!profile.getFriendshipRequests().isEmpty()) {
            System.out.println("---> Hai peticions de amizade recibidas");
            System.out.println("");
            System.out.println("---> Peticions de amizade");
        }
        /*
        Bucle for para las solicitudes de amistad recibidas
         */
        for (int i = 0; i < profile.getFriendshipRequests().size(); i++) {
            System.out.println("");
            System.out.println("ID: " + i);
            System.out.println("Nome: " + profile.getFriendshipRequests().get(i).getName());
            System.out.println("-------------------------------------------------------------------");
        }

        /*
        Condición if si hay amigos
         */
        if (!profile.getFriends().isEmpty()) {
            System.out.println("---> Este perfil ten amigos");
            System.out.println("");
            System.out.println("---> Amigos");
        }

        /*
        Bucle for para los amigos
         */
        for (int i = 0; i < profile.getFriends().size(); i++) {
            System.out.println("");
            System.out.println("ID: " + i);
            System.out.println("Nome: " + profile.getFriends().get(i).getName());
            System.out.println("-------------------------------------------------------------------");
        }

        /*
        Condición if si hay publicaciones
         */
        if (!profile.getPosts().isEmpty()) {
            System.out.println("---> Este perfil ten publicacions");
            System.out.println("");
            System.out.println("---> Publicacions");
        }

        /*
        Bucle for para las publicaciones
         */
        for (int i = 0; i < profile.getPosts().size() && i < postsShowed; i++) {
            System.out.println("");
            System.out.println("ID: " + profile.getPosts().get(i).getId());
            System.out.println("Autor: " + profile.getPosts().get(i).getAuthor().getName());
            //Fecha del post con un formato determinado (formatter)
            System.out.println("Data: " + formatter.format(profile.getPosts().get(i).getDate()));
            System.out.println("Texto: " + profile.getPosts().get(i).getText());
            System.out.println("Likes: " + profile.getPosts().get(i).getProfileLikes().size());
            System.out.println("-------------------------------------------------------------------");

            /*
        Condición if si hay comentarios en una publicacion
             */
            if (!profile.getPosts().get(i).getComments().isEmpty()) {
                System.out.println("---> Esta publicacion ten comentarios");
                System.out.println("");
                System.out.println("---> Comentarios");
            }

            /*
            Bucle for para los comentarios del post
             */
            for (int j = 0; j < profile.getPosts().get(i).getComments().size(); j++) {
                System.out.println("");
                System.out.println("-> Comentarios: " + i);
                System.out.println(profile.getPosts().get(i).getComments().get(j).getId() + " " + profile.getPosts().get(i).getComments().get(j).getText());
                System.out.println("-------------------------------------------------------------------");
            }

        }
        System.out.println("Tu usuario: " + profile.getName());
        System.out.println("Tu estado: " + profile.getStatus());
        System.out.println("Mostrando " + postsShowed + " últimos posts");
    }

    /**
     * Este método permite que el usuario cambie de estado. Si own profile es
     * false, avisará que el estado solo se puede cambiar en su propia biografia
     *
     * @param ownProfile si está en su perfil o no
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que cambia el estado
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
            System.out.println("Esta opcion so se pode utilizar no teu propio perfil");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método llama al método showProfileInfo y entrega opciones al usuario
     *
     * @param profile el perfil al que se entrega las opciones
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
            System.out.println("Selecciona unha opcion:");
            System.out.println("1. Escribir unha nova publicacion");
            System.out.println("2. Comentar unha publicacion");
            System.out.println("3. Facer me gusta sobre unha publicacion");
            System.out.println("4. Ver a biografia dun amigo");
            System.out.println("5. Enviar unha solicitude de amizade");
            System.out.println("6. Aceptar unha solicitude de amizade");
            System.out.println("7. Rexeitar unha solicitude de amizade");
            System.out.println("8. Enviar unha mensaxe privada a un amigo");
            System.out.println("9. Ler unha mensaxe privada");
            System.out.println("10. Eliminar unha mensaxe privada");
            System.out.println("11. Ver publicacions anteriores");
            System.out.println("12. Cambiar o estado");
            System.out.println("13. Pechar a sesion");
            select = scan.nextInt();
            scan.nextLine();
        } while (select > 13);

        switch (select) {
            case 1:
                writeNewPost(scan, profile);
                break;
            case 2:
                commentPost(scan, profile);
                break;
            case 3:
                addLike(scan, profile);
                break;
            case 4:
                showBiography(true, scan, profile);
                break;
            case 5:
                sendFriendshipRequest(true, scan, profile);
                break;
            case 6:
                // Si acepta la solicitud es true el valor de la variable accept
                proccessFriendshipRequest(true, scan, profile, true);
                break;
            case 7:
                // Si rechaza la solicitud es false el valor de la variable accept
                proccessFriendshipRequest(true, scan, profile, false);
                break;
            case 8:
                sendPrivateMessage(true, scan, profile);
                break;
            case 9:
                readPrivateMessage(true, scan, profile);
                break;
            case 10:
                deletePrivateMessage(true, scan, profile);
                break;
            case 11:
                showOldPosts(scan, profile);
                break;
            /*
            Si el usuario selecciona la opcion 12, que reciba un scanner para que
            pueda cambiar su estado.
             */
            case 12:
                changeStatus(true, scan, profile);
                break;
            /*
            Si el usuario selecciona la opcion 13, que simplemente cierre la 
            sesión y que salga del bucle.
             */
            case 13:
                break;
        }
    }

    /**
     * Este método pide al usuario un numero y lo devuelve
     *
     * @param text el texto que se muestra
     * @param maxNumber el número máximo para localizar
     * @param scanner el scanner que se utiliza
     * @return Devuelve un número introducido por el usuario
     */
    private int selectElement(String text, int maxNumber, Scanner scanner) {
        int index;
        do {
            System.out.println(text);
            index = scanner.nextInt();
            scanner.nextLine();
            if (index < 0 || index > maxNumber - 1) {
                System.out.println("Debes introducir un numero entre 0 e " + (maxNumber - 1));
            }
        } while (index < 0 || index > maxNumber - 1);

        return index;
    }

    /**
     * Este método pide el texto para crear una nueva publicacion
     *
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que escribe el post
     */
    private void writeNewPost(Scanner scanner, Profile profile) {
        System.out.println("Introduce o texto da publicacion");
        String text = scanner.nextLine();
        profileController.newPost(text, profile);
    }

    /**
     * Este método introduce un comentario en un post
     *
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que escribe el comentario
     */
    private void commentPost(Scanner scanner, Profile profile) {
        if (profile.getPosts().isEmpty()) {
            System.out.println("---> Non hai publicacions");
            showProfileMenu(profile);
        } else {
            int postNum = selectElement("Indica o numero do post que queres comentar", Math.min(profile.getPosts().size(), this.postsShowed), scanner);
            Post postCommented = profile.getPosts().get(postNum);
            System.out.println("Escribe o comentario que desexas");
            String commentText = scanner.nextLine();
            this.profileController.newComment(postCommented, commentText);
        }
    }

    /**
     * Este método hace que a una publicición un usuario le de like
     *
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que da like
     */
    private void addLike(Scanner scanner, Profile profile) {
        int position = selectElement("Introduce o numero da publicacion", profile.getPosts().size(), scanner);
        profileController.newLike(profile.getPosts().get(position));
    }

    /**
     * Este método muestra el perfil de una amistad del perfil si está viendo su
     * porpio perfil o muestra el perfil que está viendo
     *
     * @param ownProfile si está en su perfil o no
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que muestra la biografía
     */
    private void showBiography(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            if (profile.getFriends().isEmpty()) {
                System.out.println("Todavia non tes ningun amigo engadido :(");
                showProfileMenu(profile);
            } else {
                int friendNum = selectElement("Introduce a amistade a que queres ver a biografia", profile.getFriends().size(), scanner);
                this.profileController.setShownProfile(profile.getFriends().get(friendNum));
            }
        } else {
            this.profileController.setShownProfile(this.profileController.getSessionProfile());
        }
    }

    /**
     * Este método permite enviar una solicitud de amistad
     *
     * @param ownProfile si está en su perfil o no
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que muestra la biografía
     *
     */
    private void sendFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            System.out.println("Introduce o nome do perfil que queres enviar pedido de amistade");
            String profileUser = scanner.nextLine();
            System.out.println("---> Has enviado unha solicitude de amizade a " + profileUser);
            this.profileController.newFriendshipRequest(profileUser);
        } else {
            System.out.println("Esta opcion so se pode utilizar na tua biografia");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método pide el número de la solicitud de amistad para aceptarla o
     * rechazarla
     *
     * @param ownProfile si está en su perfil o no
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que recibe la solicitud de amistad
     * @param accept true para aceptar la solicitud o false para rechazarla
     */
    private void proccessFriendshipRequest(boolean ownProfile, Scanner scanner, Profile profile, boolean accept) {

        if (ownProfile) {
            if (profile.getFriendshipRequests().isEmpty()) {
                System.out.println("Non tes ningunha solicitude de amizade pendente");
                showProfileMenu(profile);
            } else {
                int pedidoAmistadNumber = selectElement("Introduce o numero da solicitude que queres selecionar", profile.getFriendshipRequests().size(), scanner);
                if (accept) {
                    System.out.println("---> Has aceptado a solicitude de amizade");
                    this.profileController.acceptFriendshipRequest(profile.getFriendshipRequests().get(pedidoAmistadNumber));
                } else {
                    System.out.println("---> Has rechazado a solicitude de amizade");
                    this.profileController.rejectFriendshipRequest(profile.getFriendshipRequests().get(pedidoAmistadNumber));
                }
            }
        } else {
            System.out.println("So podes modificar o teu propio perfil");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método envia un mensaje privado a una amistad
     *
     * @param ownProfile si está en su perfil o no
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que envia el mensaje
     */
    private void sendPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        Profile destProfile = null;
        int numAmg;//amg de amigo, no de mercedes a45
        if (ownProfile) {
            if (profile.getFriends().isEmpty()) {
                System.out.println("A tua lista de amigos esta vacia :(");
                showProfileMenu(profile);
                return;
            }
            numAmg = selectElement("Indica o amigo(a) que desear enviar un mensaxe", profile.getFriends().size(), scanner);
            destProfile = profile.getFriends().get(numAmg);
        }
        System.out.println("Introduce o texto da mensaxe:");
        String msgTxt = scanner.nextLine();
        this.profileController.newMessage(destProfile, msgTxt);
    }

    /*
    FALLA Y REALIZA UNA SALIDA DE LA SESION EXISTENTE
     */
    private void readPrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        if (ownProfile) {
            if (profile.getMessages().isEmpty()) {
                System.out.println("Non tes ningun mensaxe :(");
                showProfileMenu(profile);
            } else {
                String msgTxt;
                int msgNum = selectElement("Selecciona o numero do mensaxe que queres ler", profile.getMessages().size(), scanner);
                Message msg = profile.getMessages().get(msgNum);

                // Muestra el mensaje seleccionado
                System.out.println("---------------");
                System.out.println("Mensaxe privado");
                System.out.println("De: " + msg.getSourceProfile().getName());
                System.out.println("Data:" + this.formatter.format(msg.getDate()));
                System.out.println("Texto: ");
                System.out.println(msg.getText());
                System.out.println();
                System.out.println("Elixe unha opcion:");
                System.out.println("1. Contestar o mensaxe");
                System.out.println("2. Eliminar o mensaxe");
                System.out.println("3. Marcar como lida a mensaxe e volver a biografia");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Escribe o mensaxe:");
                        msgTxt = scanner.nextLine();
                        this.profileController.replyMessage(msg, msgTxt);
                        return;

                    case 2:
                        this.profileController.deleteMessage(msg);
                        return;

                    case 3:
                        this.profileController.markMessageAsRead(msg);
                        return;
                }

                System.out.println("Introduce un numero de 1 a 3");
                showProfileMenu(profile);
            }
        } else {
            System.out.println("So podes utilizar esta opcion na tua biografia");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método permite borrar un mensaje
     *
     * @param ownProfile si está en su perfil o no
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que borra el mensaje
     */
    private void deletePrivateMessage(boolean ownProfile, Scanner scanner, Profile profile) {
        int msgSelect;
        if (ownProfile) {
            if (profile.getMessages().isEmpty()) {
                System.out.println("Non tes mensaxes :(");
                showProfileMenu(profile);
            } else {
                msgSelect = selectElement("indica o mensaxe que desexas eliminar", profile.getMessages().size(), scanner);
                profileController.deleteMessage(profile.getMessages().get(msgSelect));
            }
        } else {
            System.out.println("So podes configurar o teu propio perfil");
            showProfileMenu(profile);
        }
    }

    /**
     * Este método pregunta al usuario el número de posts a visualizar y recarga
     * el perfil
     *
     * @param scanner el scanner que se utiliza
     * @param profile el perfil que modifica el número de posts
     */
    private void showOldPosts(Scanner scanner, Profile profile) {
        System.out.println("Introduce o numero de publicacions a visualizar");
        int number = scanner.nextInt();
        postsShowed = number;
        profileController.reloadProfile();
    }

    /**
     * Este método muestra un mensaje al usuario sobre que no se encontro un
     * perfil
     */
    public void showProfileNotFoundMessage() {
        System.out.println("O perfil que estas intentando buscar non existe");
    }

    /**
     * Este método muestra un mensaje al usuario sobre que no puedes dar like a
     * tu proia publicación
     */
    public void showCannotLikeOwnPostMessage() {
        System.out.println("Non podes dar like a tua propia publicacion");
    }

    /**
     * Este método muestra un mensaje al usuario sobre que no es posible dar
     * like a una publicación que ya distes
     */
    public void showAlreadyLikedPostMessage() {
        System.out.println("Non e posible dar like a unha publicacion que xa diste like");
    }

    /**
     * Este método muestra un mensaje al usuario sobre que ya eres amigo de
     * profileName
     *
     * @param profileName nombre de la persona
     */
    public void showIsAlreadyFriendMessage(String profileName) {
        System.out.println("Xa eres amigo de " + profileName);
    }

    /**
     * Este método muestra un mensaje al usuario sobre que ya tienes enviada una
     * solicitud de amistad a profileName
     *
     * @param profileName nombre de la persona
     */
    public void showExistsFrienshipRequestMessage(String profileName) {
        System.out.println("Xa tes unha solicitude de amizade enviada a " + profileName);
    }

    /**
     * Este método muestra un mensaje al usuario sobre que ya tienes una
     * solicitud de amistad con profileName
     *
     * @param profileName nombre de la persona
     */
    public void showDuplicateFrienshipRequestMessage(String profileName) {
        System.out.println("Xa tes unha peticion de amizade con " + profileName);
    }
}
