
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta classe guardará todos los atributos y metodos que se relacionan con los
 * posts.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Post {

    private int id;
    private Date date;
    private String text;
    private ArrayList<Profile> profileLikes;
    private ArrayList<Profile> author;
    private ArrayList<Profile> profile;
    private ArrayList<Comment> comments;

    /**
     * Este es el constructor de la clase Post
     *
     * @param id
     * @param date
     * @param text
     * @param profileLikes
     * @param author
     * @param profile
     * @param comments
     */
    public Post(int id, Date date, String text, ArrayList<Profile> profileLikes, ArrayList<Profile> author, ArrayList<Profile> profile, ArrayList<Comment> comments) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.profileLikes = profileLikes;
        this.author = author;
        this.profile = profile;
        this.comments = comments;
    }

    /**
     * getter de id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * setter de id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter de date
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * setter de date
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getter de text
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * setter de text
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * getter de ProfileLikes
     *
     * @return
     */
    public ArrayList<Profile> getProfileLikes() {
        return profileLikes;
    }

    /**
     * Setter de ProfileLikes
     *
     * @param profileLikes
     */
    public void setProfileLikes(ArrayList<Profile> profileLikes) {
        this.profileLikes = profileLikes;
    }

    /**
     * array list profile que guarda los autores (perfiles que publicaron el
     * post)
     *
     * @return author
     */
    public ArrayList<Profile> getAuthor() {
        return author;
    }

    /**
     * setter de author
     *
     * @param author
     */
    public void setAuthor(ArrayList<Profile> author) {
        this.author = author;
    }

    /**
     * array list profile que recibe el perfil de los autores.
     *
     * @return
     */
    public ArrayList<Profile> getProfile() {
        return profile;
    }

    /**
     * setter de profile
     *
     * @param profile
     */
    public void setProfile(ArrayList<Profile> profile) {
        this.profile = profile;
    }

    /**
     * getter de comments
     *
     * @return
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * setter de coments
     *
     * @param comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

}
