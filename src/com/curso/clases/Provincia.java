package com.curso.clases;

import com.curso.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Provincia {
    private String código;
    private String nombre;
    private String autonomía;

    public boolean getVálido() {
        return válido;
    }

    private boolean válido;

    public Provincia (String código) throws SQLException
    {
        this.código = código;

        String sql = "SELECT * FROM provincia" +
                " WHERE código = ?";
        PreparedStatement ps = Main.Conexión.prepareStatement(sql);
        ps.setString(1,this.código);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            this.nombre=rs.getString("nombre");
            this.autonomía=rs.getString("autonomía");
            this.válido=true;
        }else{
            this.válido=false;
        }
    }

    public String aCadena(){
        String texto="Código: " +this.código+"\n Nombre:"+ this.nombre + "\n Autonomía: " + this.autonomía;

        return texto;
    }

    public int getPoblación()
    {
        int resultado = -1;

        try {
            Statement s = Main.Conexión.createStatement();
            String sql = "SELECT sum(población) AS total FROM municipio" +
                    " WHERE provincia = '" + this.código + "'";
            ResultSet rs = s.executeQuery(sql);

            rs.next(); // avanza a la primera (y única) fila de resultado
            resultado = rs.getInt("total");
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
            Statement s = Main.Conexión.createStatement();
            String sql = "SELECT * FROM municipio" +
                    " WHERE provincia = '" + this.código + "'" +
                    " ORDER BY nombre";
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