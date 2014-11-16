/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;

/**
 *
 * @author CesarPC
 */
public class Logica {
    Datos d=new Datos(); 
    
    public ResultSet consultar(int id)
    {
        String consulta,retorno;
        consulta="SELECT username FROM usuario WHERE _id ="+id;
        ResultSet conjuntodatos;
        conjuntodatos=d.busqueda(consulta);

        return conjuntodatos;
    }
    public int RegistrarUsuario(String name,String username, String password)
    {
        String consulta;
        int x=0;
        consulta="insert into usuario values ('"+x+"','"+name+"','"+username+"', '"+password+"')";
        return d.ejecutarDML(consulta);
    }
    public int EditarCuentaUsuario(String name,String username, String password, String usernameInicial)
    {
        String consulta;
        consulta="update usuario set nombre = '"+name+"', username = '"+username+"', password ='"+password+"' where username = '"+usernameInicial+"'";
        return d.ejecutarDML(consulta);
    }
    public int EliminarCuentaUsuario(String username)
     {
         String consulta;
        consulta="delete from usuario where username = '"+username+"'";
        return d.ejecutarDML(consulta);
     }
    public int ingresarNota(String nombre,String tag, String tipo, String contenido, String archivosound, String horafecha, float latitud, float longitud, String creador)
    {
        String consulta;
        int x=0;
        consulta="insert into nota values ('"+x+"','"+nombre+"','"+tag+"', '"+tipo+
                "', '"+contenido+"', '"+archivosound+"', '"+horafecha+"', '"+latitud+"', '"+longitud+"', '"+creador+"')";
        return d.ejecutarDML(consulta);
    }
    public int EliminarNota(String nombre, String creador)
     {
         String consulta;
         consulta="delete from nota where (creador = '"+creador+"' and nombre ='"+nombre+"')";
         return d.ejecutarDML(consulta);
     }
    public int editarNota(String nuevoCreador, String creadorAntiguo)
    {
        String consulta;
        int x=0;
        consulta="update nota set creador='"+nuevoCreador+"' where creador ='"+creadorAntiguo+"'";
        return d.ejecutarDML(consulta);
    }
}
