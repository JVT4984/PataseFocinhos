package com.example.semestralfd;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


    public class RelatorioDAO {


        public List<Animal> getAnimalRelatorio() throws SQLException {
            try (Statement statement = ConnectionSingleton.getConnection().createStatement();
                 ResultSet rs = statement.executeQuery("select * from animais where data_adocao between ? and ?;")) {
                List<Animal> animais = new ArrayList<>();
                while (rs.next()) {
                    Animal animal = new Animal();
                    animal.animal_dt_cadastro = rs.getDate(1);
                    animal.animal_dt_cadastro = rs.getDate(2);
                    usuarios.add(usuario);
                }
                return usuarios;
            }


        }
    }

