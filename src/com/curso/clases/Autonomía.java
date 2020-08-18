package com.curso.clases;

import com.curso.Main;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Autonomía
{
    private String código;
    private String nombre;

    public Autonomía(String código, String nombre)
    {
        this.código = código;
        this.nombre = nombre;
    }

    public List<Provincia> getProvincias()
    {
        List<Provincia> resultado = new ArrayList<Provincia>();

        // ...y aquí rellenaríamos la lista

        return resultado;
    }

    public List<Municipio> getMunicipiosV2()
    {
        List<Municipio> resultado = new ArrayList<Municipio>();

        try {
            String sql = "SELECT * FROM municipio M," +
                    " provincia P WHERE M.provincia = P.código" +
                    " AND P.autonomía = ? ORDER BY M.nombre";
            PreparedStatement ps = Main.bbdd.Conexión.prepareStatement(sql);
            ps.setString(1, this.código);
            ResultSet rs = ps.executeQuery();

//            while (rs.next()) {
//                Municipio m = new Municipio();
//                m.setNombre(rs.getString("nombre"));
//                resultado.add(m);
//            }
        }
        catch (SQLException e) {
            System.out.println("Error de SQL: " + e.toString());
        }

        return resultado;
    }

    public List<Municipio> getMunicipios()
    {
        List<Municipio> resultado = new ArrayList<Municipio>();

        try {
            Statement s = Main.bbdd.Conexión.createStatement();
            String sql = "SELECT * FROM municipio M," +
                    " provincia P WHERE M.provincia = P.código" +
                    " AND P.autonomía = '" + this.código + "'";
            ResultSet rs = s.executeQuery(sql);

//            while (rs.next()) {
//                Municipio m = new Municipio();
//                m.setNombre(rs.getString("nombre"));
//                resultado.add(m);
//            }
        }
        catch (SQLException e) {
            System.out.println("Error de SQL: " + e.toString());
        }

        return resultado;
    }

}