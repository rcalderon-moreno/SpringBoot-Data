package com.example;

import com.example.entidades.Persona;
import com.example.repositorio.PersonaRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {
        private static Logger logCadena= LoggerFactory.getLogger(SpringJdbcApplication.class);


        @Autowired
        PersonaRepositorio personaRepositorio;
        
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception {


                logCadena.info("*****************************************************");
                logCadena.info("Consultar ID 1:" + personaRepositorio.buscarPorId(1).toString());
                logCadena.info("Consultar ID 2:" + personaRepositorio.buscarPorId(2).toString());            
                logCadena.info("*****************************************************");
                logCadena.info("Todas las personas"+ personaRepositorio.buscarTodos());
                logCadena.info("Todas las personas  -> {}", personaRepositorio.buscarTodosV2());
                logCadena.info("*****************************************************");
                
                logCadena.info("Insertando Persona" + personaRepositorio.insertar(new Persona(3, "Luis", "3")));

                logCadena.info("Actualizar Persona Id=1 -> {}", personaRepositorio.actualizar(new Persona(1, "Sandra", "Rojas")));

                personaRepositorio.eliminarPorId(2);
                
                logCadena.info("Todas las personas"+ personaRepositorio.buscarTodos());
                logCadena.info("*****************************************************");
        }

}
