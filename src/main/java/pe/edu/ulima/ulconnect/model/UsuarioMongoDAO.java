/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.ulima.ulconnect.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import org.bson.types.ObjectId;
import pe.edu.ulima.ulconnect.model.beans.Carrera;
import pe.edu.ulima.ulconnect.model.beans.Perfil;
import pe.edu.ulima.ulconnect.model.beans.Usuario;

/**
 *
 * @author hquintana
 */
public class UsuarioMongoDAO {
    private static UsuarioMongoDAO dao = null;
    
    private MongoClient client;
    DB db;
    
    public static UsuarioMongoDAO getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new UsuarioMongoDAO();
        }
        return dao;
    }
    
    private UsuarioMongoDAO() throws UnknownHostException{
        client = new MongoClient(new MongoClientURI("mongodb://heroku_app31292002:11h9ggq4lf5sfl0itp405iodn8@ds051170.mongolab.com:51170/heroku_app31292002"));
        db = client.getDB("heroku_app31292002");
    }
    
    public void create(Usuario usuario){
        DBCollection usuCol = db.getCollection("usuarios");
        DBObject usuDoc = new BasicDBObject("_id", usuario.getCodigo())
                .append("nombre", usuario.getNombre())
                .append("password", usuario.getPassword())
                .append("perfil", new BasicDBObject("_id", usuario.getPerfil().getId())
                        .append("nombre", usuario.getPerfil().getNombre()))
                .append("carrera", new BasicDBObject("_id", usuario.getCarrera().getId())
                        .append("nombre", usuario.getCarrera().getNombre()));
        
        usuCol.insert(usuDoc);
    }
    
    public Usuario get(String codigo, String password){
        DBCollection usuCol = db.getCollection("usuarios");
        DBObject filtro = new BasicDBObject("_id", codigo)
                .append("password", password);
        DBObject usuDoc = usuCol.findOne(filtro);
        Usuario usuario = null;
        if (usuDoc != null){
            Perfil perfil = new Perfil(
                    (ObjectId)((DBObject) usuDoc.get("perfil")).get("_id"),
                    ((DBObject) usuDoc.get("perfil")).get("nombre").toString()   
            );
            Carrera carrera = new Carrera(
                    (ObjectId)((DBObject) usuDoc.get("carrera")).get("_id"),
                    ((DBObject) usuDoc.get("carrera")).get("nombre").toString()
            );
            usuario = new Usuario(
                    usuDoc.get("_id").toString(),
                    usuDoc.get("nombre").toString(),
                    usuDoc.get("password").toString(),
                    perfil,
                    carrera
            );
        }
        return usuario;
    }
}
