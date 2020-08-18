package com.curso.clases;

import com.curso.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    public static Connection Conexión = null;

    //Conectar a la bbdd
    public static void conectarBD() throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://192.168.56.2/geografia";
        String usuario = "censo";
        String clave = "620312786";
        Conexión = DriverManager.getConnection(url, usuario, clave);


    }

    /*
    Devuelve una lista con los municipios de una provincia
    o NULL si la provincia no existe
     */

    public List<Municipio> municipiosProvincia(String códigoProvincia)
    throws  SQLException{
        List<Municipio> resultado = new ArrayList<Municipio>();


        String sql = "SELECT * FROM municipio where provincia = ?";
        PreparedStatement ps = Main.bbdd.Conexión.prepareStatement(sql);
        ps.setString(1, códigoProvincia);
        ResultSet rs = ps.executeQuery();

       if(rs.next()) {
           do{
               String códigoMunicipio = rs.getString("código");
               Municipio m = new Municipio(códigoProvincia,códigoMunicipio);
               m.setNombre(rs.getString("nombre"));
               resultado.add(m);
           }while(rs.next());

        }

       return resultado;
    }

    //devuelva la lsita de municipios de una autonomia, o NULL si no existe
    public List<Municipio> municipiosAutonomía(String códigoAutonomia) throws SQLException {
        List<Municipio> resultado = new ArrayList<Municipio>();

        String sql = "SELECT M.* FROM municipio M , provincia P where M.provincia = P.código AND P.autonomía = ?";
        PreparedStatement ps = Main.bbdd.Conexión.prepareStatement(sql);
        ps.setString(1, códigoAutonomia);
        ResultSet rs = ps.executeQuery();


        return resultado;
    }
}