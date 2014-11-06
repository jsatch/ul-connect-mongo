/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.ulima.ulconnect.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import pe.edu.ulima.ulconnect.model.beans.Perfil;
import java.util.List;
import java.util.ArrayList;
import org.bson.types.ObjectId;

/**
 *
 * @author hquintana
 */
public class PerfilMongoDAO {
    private static PerfilMongoDAO dao = null;
    
    private MongoClient client;
    DB db;
    
    public static PerfilMongoDAO getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new PerfilMongoDAO();
        }
        return dao;
    }
    
    private PerfilMongoDAO() throws UnknownHostException{
        client = new MongoClient(new MongoClientURI("mongodb://heroku_app31292002:11h9ggq4lf5sfl0itp405iodn8@ds051170.mongolab.com:51170/heroku_app31292002"));
        db = client.getDB("heroku_app31292002");
    }
    
    public Perfil get(ObjectId id){
        DBCollection perfilCol = db.getCollection("perfiles");
        
        DBObject filtro = new BasicDBObject("_id", id);
        DBObject perfilDoc = perfilCol.findOne(filtro);
        
        Perfil perfil = null;
        if (perfilDoc != null){
            perfil = new Perfil(
                    (ObjectId)perfilDoc.get("_id"),
                    perfilDoc.get("nombre").toString()
            );
        }
        return perfil;
    }
    
    public List<Perfil> retrieve(){
        DBCollection perfilCol = db.getCollection("perfiles");
        
        DBCursor cursor = perfilCol.find();
        List<Perfil> perfiles = new ArrayList<Perfil>();
        try{
            while (cursor.hasNext()){
                DBObject perfilDoc = cursor.next();
                Perfil perfil = new Perfil(
                        (ObjectId)perfilDoc.get("_id"),
                        perfilDoc.get("nombre").toString()
                );
                perfiles.add(perfil);
            }
        }finally{
            cursor.close();
        }
        return perfiles;
    }
}
