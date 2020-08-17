package com.curso.clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Comunidad {

    private String código;
    private String nombre;

    public List <Provincia> getPRovincias()  {

        List<Provincia> resultado = new ArrayList<Provincia>();
        return resultado;
    }

    public List<Municipio> getMunicipios()
    {
        List<Municipio> resultado = new ArrayList<Municipio>();

        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.56.2/geografia";
            String usuario ="censo";
            String clave = "620312786";
            Connection c = DriverManager.getConnection(url,usuario,clave);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ccaa");
            while(rs.next()){
                Municipio m = new Municipio();
                m.setNombre(rs.getString("nombre"));
            }

        } catch (ClassNotFoundException e){
            System.out.println("No encuentro la BBDD");
        } catch (SQLException e){
            System.out.println("Error de SQL" +e.toString());
        }


//        Municipio m = new Municipio();
//        m.setNombre("Villa Arriba");
//        resultado.add(m);
//
//        Municipio m2 = new Municipio();
//        m2.setNombre("Villa Abajo");
//        resultado.add(m);


        return resultado;
    }
}
