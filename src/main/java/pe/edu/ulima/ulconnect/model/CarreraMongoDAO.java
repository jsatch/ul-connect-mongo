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
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import pe.edu.ulima.ulconnect.model.beans.Carrera;

/**
 *
 * @author hquintana
 */
public class CarreraMongoDAO {
    private static CarreraMongoDAO dao = null;
    
    private MongoClient client;
    DB db;
    
    public static CarreraMongoDAO getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new CarreraMongoDAO();
        }
        return dao;
    }
    
    private CarreraMongoDAO() throws UnknownHostException{
        client = new MongoClient(new MongoClientURI("mongodb://heroku_app31292002:11h9ggq4lf5sfl0itp405iodn8@ds051170.mongolab.com:51170/heroku_app31292002"));
        db = client.getDB("heroku_app31292002");
    }
    
    public Carrera get(ObjectId id){
        DBCollection perfilCol = db.getCollection("carreras");
        
        DBObject filtro = new BasicDBObject("_id", id);
        DBObject carreraDoc = perfilCol.findOne(filtro);
        
        Carrera carrera = null;
        if (carreraDoc != null){
            carrera = new Carrera(
                    (ObjectId)carreraDoc.get("_id"),
                    carreraDoc.get("nombre").toString()
            );
        }
        return carrera;
    }
    
    public List<Carrera> retrieve(){
        DBCollection carreraCol = db.getCollection("carreras");
        
        DBCursor cursor = carreraCol.find();
        List<Carrera> carreras = new ArrayList<Carrera>();
        try{
            while (cursor.hasNext()){
                DBObject carreraDoc = cursor.next();
                Carrera carrera = new Carrera(
                        (ObjectId)carreraDoc.get("_id"),
                        carreraDoc.get("nombre").toString()
                );
                carreras.add(carrera);
            }
        }finally{
            cursor.close();
        }
        return carreras;
    }
}
