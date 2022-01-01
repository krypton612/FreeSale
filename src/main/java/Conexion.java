
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    String base_datos = "pollo_panchita";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "pollo";
    String password = "12345678";
    String driver = "com.mysql.cj.jdbc.Driver";
     
    Connection cx;

    public Conexion (String bd){
        this.base_datos = bd;

    }
    public Connection conectart (){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+base_datos, user, password);
            //System.out.println(" se conecto ");
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("no se conecto" );
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return cx;
    }
    public void desconectar(){
        try {
            
            cx.close();
        } catch (Exception e) {
            System.err.println("No se pudo desconectar");
        }
    }
    

}
