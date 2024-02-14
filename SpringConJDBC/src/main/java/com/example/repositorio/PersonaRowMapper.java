
package com.example.repositorio;



import com.example.entidades.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public  class PersonaRowMapper   implements RowMapper<Persona>  {

    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
       
        Persona persona=new Persona();
        persona.setId(Integer.valueOf(rs.getString("id")));
        persona.setNombres(rs.getString("nombres"));
        persona.setApellidos(rs.getString("apellidos"));
        return persona;
    }
    
}