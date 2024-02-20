import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConexionMongoDB {
    private String usuario;
    private String contraseña;
    private String url;
    MongoClient cliente;
    private MongoDatabase baseDatos;
    private MongoCollection coleccion;
    // Constructor
    public ConexionMongoDB(String url) {
         cliente = MongoClients.create(url);
    }

    public void getAcceso(String nombreBaseDatos, String nombreColeccion) {
        baseDatos = cliente.getDatabase(nombreBaseDatos);
        coleccion = baseDatos.getCollection(nombreColeccion);
    }
    public void Insertar_documento(Document documento){
        coleccion.insertOne(documento);
    }
}
