/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wladytb.servicemynubemongodb.accesoDatos;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoCommandException;
import com.wladytb.servicemynubemongodb.modelo.user;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wladi
 */
public class userDAO {

    conexion cn;
    private DBCollection tabla;
    private DB db;
    user respuesta;
    List<user> listaUser;

    public boolean insert(user us) {
        try {
            cn = new conexion();
            db = cn.getConexion();
            tabla = db.getCollection("user");
            BasicDBObject fila = new BasicDBObject()
                    .append("userName", us.getUserName())
                    .append("password", us.getPassword())
                    .append("email", us.getEmail())
                    .append("photo", us.getPhoto());
            tabla.insert(fila);
            return true;
        } catch (MongoCommandException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public List<user> verificar(user us) {

        try {
            cn = new conexion();
            db = cn.getConexion();
            tabla = db.getCollection("user");
            BasicDBObject filtro = new BasicDBObject();
            filtro.put("userName", us.getUserName());
            filtro.put("password", us.getPassword());
            DBCursor cur = tabla.find(filtro);
            listaUser = new ArrayList<>();
            while (cur.hasNext()) {
                DBObject fila = cur.next();
                respuesta = new user(fila.get("_id").toString(), "", "", "", "");
                listaUser.add(respuesta);
                System.out.println(fila);
            }
            return listaUser;
        } catch (MongoCommandException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listaUser;
    }
}
