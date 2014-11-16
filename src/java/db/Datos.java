/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CesarPC
 */
public class Datos {
    private String cadenaconexion; //Atributos necesarios para la conexión, tomados de los ejemplos Info III
    private Connection con; 
    //Este método inicia la conexión Oracle-Java
    private void inicializarconexion()
    {
        try
             {
                 Class.forName("com.mysql.jdbc.Driver");
                 String servidor="jdbc:mysql://127.0.0.1:3306/notappbd";
                 String usuarioBD="root";
                 String contra="oracle";
                 
                 con=(Connection) DriverManager.getConnection(servidor, usuarioBD, contra);
                 System.out.println("Conexion exitosa con BD");
             }
             catch(ClassNotFoundException ex)
             {
                         System.out.println("Error de libreria - class not found ");
             }
             catch(SQLException ex)
             {
                     System.out.println("Error de conexion SQL");
                    con=null;
             }
             catch(Exception ex)
             {
                    System.out.println("Error 3");
                    con=null;
             }
    }
    public Datos()
    {
        inicializarconexion(); //Así, cada vez que se cree un objeto, se creará una conexión Oracle-Java
    }
    public ResultSet busqueda(String consulta)
    {
        String consulta2;
        ResultSet rs;   //Código de las clases de Info III
         try
        {
            Statement st = con.createStatement(); 
            rs = st.executeQuery(consulta);
            return rs;   
        }
        catch(Exception ex)
        {
            
            return null;
        }
       
    }
    public int ejecutarDML(String consulta)
    {
        int filasAfectadas=0;
        try
        {
           Statement st = con.createStatement();
           filasAfectadas = st.executeUpdate(consulta);
           return filasAfectadas;
        }
        catch(Exception ex)
        {
            return 0;
        }
    }
}

