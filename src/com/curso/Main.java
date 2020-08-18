package com.curso;

import com.curso.clases.BaseDeDatos;
import com.curso.clases.Municipio;
import com.curso.clases.Provincia;
import com.curso.clases.Autonomía;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main
{
    public static BaseDeDatos bbdd = new BaseDeDatos();
    public static void main(String[] args)
    {
        try{
            bbdd.conectarBD();

            Provincia p = new Provincia("50");
            Autonomía a = new Autonomía("02","Aragón");

            List<Municipio> municipios = p.municipios();//

            if(municipios==null){
                System.out.println("La provincia no existe");
            } else {
                //TODO: aqui mostraria la lista de municipios
            }



//
//
//            Municipio m = new Municipio("99", "297");
//            Provincia p = new Provincia("05");
//            if(m.getVálido()) {
//                System.out.println(m.aCadena());
//            }else{
//                System.out.println("No existe el municipio indicado");
//            }
//            if(p.getVálido()) {
//                System.out.println(p.aCadena());
//            }else{
//                System.out.println("No existe la provincia indicada");
//            }

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

