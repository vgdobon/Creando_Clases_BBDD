package com.curso.clases;

import com.curso.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Municipio {

    private String provincia;
    private String código;
    private String nombre;
    private int población;
    private float superficie;
    private float latitud;
    private float longitud;
    private boolean válido;

    public boolean getVálido() {
        return this.válido;
    }

    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Municipio(String códigoProvincia,String códigoMunicipio) throws SQLException {
        this.provincia=códigoProvincia;
        this.código=códigoMunicipio;

        String sql = "SELECT * FROM municipio WHERE código = ? AND provincia = ?";
        PreparedStatement ps = Main.bbdd.Conexión.prepareStatement(sql);
        ps.setString(1,this.código);
        ps.setString(2,this.provincia);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            this.nombre = rs.getString("nombre");
            this.población =rs.getInt("población");
            this.superficie =rs.getFloat("superficie");
            this.latitud = rs.getFloat("latitud");
            this.longitud = rs.getFloat("longitud");
            this.válido = true;
        }else{
            this.válido = false;
        }



    }

    public String aCadena(){
        String texto="Nombre" +this.nombre + "\n Población: " + this.población;
        String texto2 ="Población " + this.población;

        return texto + texto2;
    }
}
