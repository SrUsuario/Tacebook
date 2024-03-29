/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import model.Profile;

/**
 *
 * Esta interfaz es implementada en GUIProfileView y TextProfileView y obliga a
 * esas dos clases a implementar estos métodos
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public interface ProfileView {

    public int getPostsShowed();

    public void showProfileMenu(Profile profile);

    public void showProfileNotFoundMessage();

    public void showCannotLikeOwnPostMessage();

    public void showAlreadyLikedPostMessage();

    public void showIsAlreadyFriendMessage(String profileName);

    public void showExistsFrienshipRequestMessage(String profileName);

    public void showDuplicateFrienshipRequestMessage(String profileName);

    public void showConnectionErrorMessage();

    public void showReadErrorMessage();

    public void showWriteErrorMessage();

}
