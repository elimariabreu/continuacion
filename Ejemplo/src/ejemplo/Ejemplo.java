package ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejemplo {

    
    public static void main(String[] args) {
      Connection conexion;
       String url="jdbc:mysql://localhost:3306/javadb";
       String usuario="root";
       String clave="mysql2017";
        try {
            conexion= DriverManager.getConnection(url,usuario,clave);
             System.out.println("Se conecto");
            String cadena="INSERT INTO ejemplo (idejemplo,dato) VALUES (1,1) ";
            Statement sentencia;
            sentencia=conexion.createStatement();
            sentencia.execute(cadena);
        } catch (SQLException ex) {
            //ex es un objeto de tipo SQLException, este tiene un metodo especifico que se llama getErrorCode 
            //que nos da un codigo para un error especifico
            switch(ex.getErrorCode()){
                case 1045:
                    System.out.println("Acceso denegado para el usuario");
                    break;
                case 1046:
                    System.out.println("No se ha seleccionado una base de datos");
                    break;
                case 1062:
                    System.out.println("Entrada duplicada, por favor inserte una nueva");
                    break;
                case 1064:
                    System.out.println("La sentencia no esta completa, o no es valida");
                    break;  
                 case 1146:
                    System.out.println("La base de datos no existe");
                    break;
            }
            
        }
       
       
    }
    
}