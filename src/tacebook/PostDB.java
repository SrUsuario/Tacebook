/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * Esta clase guardará toda la persistencia de datos de las publicaciones
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class PostDB {

    /**
     * Este método permite guardar una publicación y añadirla arriba del todo en
     * la lista de publiaciones.
     *
     * @param post
     */
    public static void save(Post post) {
        post.getProfile().getPosts().add(0, post);
    }

    /**
     * Este método guarda un like en la lista de likes de un post.
     *
     * @param post
     * @param profile
     */
    public static void saveLike(Post post, Profile profile) {
        post.getProfileLikes().add(profile);
    }
}
