package com.curso;

import com.curso.clases.Municipio;
import com.curso.clases.Provincia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    public static Connection Conexión = null;

    //Conectar a la bbdd
    public static void conectarBD() throws SQLException , ClassNotFoundException {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.56.2/geografia";
            String usuario = "censo";
            String clave = "620312786";
            Conexión = DriverManager.getConnection(url, usuario, clave);


    }
    public static void main(String[] args)
    {
        try{
            conectarBD();
            Municipio m = new Municipio("99", "297");
            Provincia p = new Provincia("05");
            if(m.getVálido()) {
                System.out.println(m.aCadena());
            }else{
                System.out.println("No existe el municipio indicado");
            }
            if(p.getVálido()) {
                System.out.println(p.aCadena());
            }else{
                System.out.println("No existe la provincia indicada");
            }

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        } catch (ClassNotFoundException e) {
        System.out.println("No encuentro la clase: " + e.toString());
    }
    }

        //Provincia p = new Provincia("28");
        //Comunidad c = new Comunidad("02", "Aragón");
        //List<Municipio> municipios = c.getMunicipiosV2();

        /*Provincia p = new Provincia("50", "Zaragoza");
        List<Municipio> municipios = p.getMunicipios();

        if (municipios.isEmpty()) {
            System.out.println("No tiene municipios");
        }
        else {
            System.out.println("Lista de municipios: ");
            for (int i = 0; i < municipios.size(); i++) {
                Municipio m = municipios.get(i);
                System.out.println(m.getNombre());
            }
        }*/
}

