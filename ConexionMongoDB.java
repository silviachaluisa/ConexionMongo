public class ConexionMongoDB {
    private String usuario;
    private String contraseña;
    private String url;
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    public ConexionMongoDB(String usuario, String contraseña, String url) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.url = url;
    }
    public boolean getCredenciales(String user, String password, String tipoUsuario) {
        return true;
    }
    public String getTipoUsuario() {
        return "tipoUsuario";
    }
}
