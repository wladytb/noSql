/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wladytb.servicemynubemongodb.accesoDatos;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCommandException;

/**
 *
 * @author wladi
 */
public class conexion {

    private MongoClient mongoClient;
    private DB db;

    public DB getConexion() {
        try {
            mongoClient = new MongoClient(
                    new MongoClientURI("mongodb://localhost:27017"));
            db = mongoClient.getDB("myNube");
            System.out.println("Conectado..");
            return db;
        } catch (MongoCommandException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
}
