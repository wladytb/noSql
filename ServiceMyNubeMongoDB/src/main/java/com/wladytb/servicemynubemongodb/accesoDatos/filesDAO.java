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
import com.wladytb.servicemynubemongodb.modelo.file;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wladi
 */
public class filesDAO {

    conexion cn;
    private DBCollection tabla;
    private DB db;
    file respuesta;
    List<file> listaFile;

    public boolean insert(file fl) {
        try {
            cn = new conexion();
            db = cn.getConexion();
            tabla = db.getCollection("files");
            BasicDBObject fila = new BasicDBObject()
                    .append("idUser", fl.getIdUser())
                    .append("name", fl.getName())
                    .append("fileURL", fl.getFileURL())
                    .append("description", fl.getDescription())
                    .append("type", fl.getType());
            tabla.insert(fila);
            return true;
        } catch (MongoCommandException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public List<file> obtener(file fl) {

        try {
            cn = new conexion();
            db = cn.getConexion();
            tabla = db.getCollection("files");
            BasicDBObject filtro = new BasicDBObject();
            filtro.put("idUser", fl.getIdUser());
            DBCursor cur = tabla.find(filtro);
            listaFile = new ArrayList<>();
            while (cur.hasNext()) {
                DBObject fila = cur.next();
                respuesta = new file(
                        fila.get("_id").toString(),
                        fila.get("idUser").toString(),
                        fila.get("name").toString(),
                        fila.get("fileURL").toString(),
                        fila.get("description").toString(),
                        fila.get("type").toString());
                listaFile.add(respuesta);
                System.out.println(fila);
            }
            return listaFile;
        } catch (MongoCommandException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listaFile;
    }

    public boolean update(file fl) {
        try {
            cn = new conexion();
            db = cn.getConexion();
            tabla = db.getCollection("files");
            BasicDBObject filtro = new BasicDBObject();
            ObjectId id = new ObjectId(fl.getIdFile());
            filtro.put("_id", id);
            System.out.println(filtro.toJson());
            BasicDBObject data = new BasicDBObject();
            data.put("name", fl.getName());
            data.put("description", fl.getDescription());
            System.out.println(data.toJson());
            BasicDBObject doc = new BasicDBObject();
            doc.put("$set", data);
            System.out.println(doc.toJson());
            tabla.update(filtro, doc);
            return true;
        } catch (MongoCommandException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    public boolean delete(file fl) {
        try {
            cn = new conexion();
            db = cn.getConexion();
            tabla = db.getCollection("files");
            BasicDBObject filtro = new BasicDBObject();
            ObjectId id = new ObjectId(fl.getIdFile());
            filtro.put("_id", id);
            System.out.println(filtro.toJson());
            tabla.remove(filtro);
            return true;
        } catch (MongoCommandException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
