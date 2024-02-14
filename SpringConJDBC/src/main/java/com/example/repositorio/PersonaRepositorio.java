
package com.example.repositorio;



import com.example.entidades.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepositorio {
 
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Persona buscarPorId(Integer id) {
            return jdbcTemplate.queryForObject("SELECT * FROM PERSONA  where id=?", new BeanPropertyRowMapper<>(Persona.class), id);            
    }  
    public List<Persona> buscarTodos() {
            return jdbcTemplate.query("select * from persona", new PersonaRowMapper());
    }
    
    public List<Persona> buscarTodosV2() {
            return jdbcTemplate.query("select * from persona", new  BeanPropertyRowMapper<>(Persona.class));
    }
    
    public void eliminarPorId(long id) {
        jdbcTemplate.update("delete from persona where id=?", id);
    }

    public int insertar(Persona persona) {
        return jdbcTemplate.update("insert into persona (id, nombres, apellidos) " + "values(?,  ?, ?)",
                persona.getId(), persona.getNombres(), persona.getApellidos());
    }

    public int actualizar(Persona persona) {
        return jdbcTemplate.update("update persona " + " set nombres = ?, apellidos = ? " + " where id = ?",
                persona.getNombres(), persona.getApellidos(), persona.getId());
    }
    
}
