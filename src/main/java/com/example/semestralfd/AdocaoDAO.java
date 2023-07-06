package com.example.semestralfd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdocaoDAO {

    public List<Animal> getAll() throws SQLException {
        try (Statement statement = ConnectionSingleton.getConnection().createStatement();
             ResultSet rs = statement.executeQuery("select * from animal;")) {
            List<Animal> animais = new ArrayList<>();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.animal_id = rs.getInt(1);
                animal.ong_id = rs.getInt(2);
                animal.tipo_animal = rs.getString(3);
                animal.raca_animal = rs.getString(4);
                animal.sexo_animal = rs.getString(5);
                animal.porte = rs.getString(6);
                animal.idade_animal = rs.getInt(7);
                animal.describe = rs.getString(8);
                animais.add(animal);
            }
            return animais;
        }

    }

    public void insertAdocao(Adocao novaAdocao) throws SQLException {
        String sql = "insert into adocao (adocao_id, usuario_usuario_id, ong_ong_id, animal_animal_id, data_adocao) values (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql);){
            preparedStatement.setInt(1, novaAdocao.adocao_id);
            preparedStatement.setInt(2, novaAdocao.adocao_usuario_id);
            preparedStatement.setInt(3, novaAdocao.adocao_ong_id);
            preparedStatement.setInt(4, novaAdocao.adocao_animal_id);
            preparedStatement.setDate(5, (Date) novaAdocao.data_adocao);

            preparedStatement.execute();

        }
    }
}


