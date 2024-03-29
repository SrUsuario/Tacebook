/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 * 
 * Esta clase guardará todos los atributos y métodos que se relacionan con los
 * profile
 * 
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Profile {

    private String name;
    private String password;
    private String status;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<Profile> friends = new ArrayList<>();
    private ArrayList<Profile> friendshipRequests = new ArrayList<>();

    /**
     * Constructor de la clase Profile
     *
     * @param name
     * @param password
     * @param status
     */
    public Profile(String name, String password, String status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

    /**
     * Getter de name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter de name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter de password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter de password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter de status
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter de status
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter de posts
     *
     * @return
     */
    public ArrayList<Post> getPosts() {
        return posts;
    }

    /**
     * Setter de status
     *
     * @param posts
     */
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    /**
     * Getter de messages
     *
     * @return
     */
    public ArrayList<Message> getMessages() {
        return messages;
    }

    /**
     * Setter de messages
     *
     * @param messages
     */
    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    /**
     * Getter de friends
     *
     * @return
     */
    public ArrayList<Profile> getFriends() {
        return friends;
    }

    /**
     * Setter de friends
     *
     * @param friends
     */
    public void setFriends(ArrayList<Profile> friends) {
        this.friends = friends;
    }

    /**
     * Getter de friendshipRequests
     *
     * @return
     */
    public ArrayList<Profile> getFriendshipRequests() {
        return friendshipRequests;
    }

    /**
     * Setter de friendshipRequests
     *
     * @param friendshipRequests
     */
    public void setFriendshipRequests(ArrayList<Profile> friendshipRequests) {
        this.friendshipRequests = friendshipRequests;
    }

}
