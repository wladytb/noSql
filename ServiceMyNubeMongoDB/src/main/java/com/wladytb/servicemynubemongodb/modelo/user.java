/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wladytb.servicemynubemongodb.modelo;

/**
 *
 * @author wladi
 */
public class user {
    private String idUser;
    private String userName,password,email,photo;

    public user() {
    }

    public user(String idUser, String userName, String password, String email, String photo) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.photo = photo;
    }

    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
