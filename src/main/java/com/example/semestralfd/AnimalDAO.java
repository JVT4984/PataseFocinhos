package com.example.semestralfd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public List<Animal> getAll() throws SQLException {
        try (Statement statement = ConnectionSingleton.getConnection().createStatement();
             ResultSet rs = statement.executeQuery("select * from animal;")) {
            List<Animal> animais = new ArrayList<>();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.animal_id = rs.getInt(1);
                animal.ong_id = rs.getInt(2);
                animal.tipo__animal = rs.getString(3);
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

    public void insert(Animal novoAnimal) throws SQLException {
        String sql = "insert into animal (ong_ong_id, tipo_animal, raca_animal," +
                " sexo_animal, porte_animal, idade, descricao_animal) values (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql);){
            preparedStatement.setInt(1, novoAnimal.ong_id);
            preparedStatement.setString(2, novoAnimal.tipo_animal);
            preparedStatement.setString(3, novoAnimal.raca_animal);
            preparedStatement.setString(4, novoAnimal.sexo_animal);
            preparedStatement.setString(5, novoAnimal.porte);
            preparedStatement.setInt(6, novoAnimal.idade_animal);
            preparedStatement.setString(7, novoAnimal.describe);

            preparedStatement.execute();

            //Obtem o ID do registro inserido
            try (ResultSet rs = preparedStatement.getGeneratedKeys()){
                rs.next();
                novoAnimal.animal_id = rs.getInt(1);
            }
        }
    }

    public void delete(Animal deleteAnimal) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement("delete from animal where animal_id = ?")) {
            preparedStatement.setInt(1, deleteAnimal.animal_id);
            preparedStatement.execute();

        }
    }

    public void update (Animal editAnimal) throws SQLException {
        String sql = "update animal SET ong_ong_id = ?, raca_animal = '?', porte_animal ='?', idade = ?, descricao_animal = '?' where animal_id = ?";
        try ( PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, editAnimal.ong_id);
            preparedStatement.setString(2, editAnimal.tipo_animal);
            preparedStatement.setString(3, editAnimal.raca_animal);
            preparedStatement.setString(4, editAnimal.sexo_animal);
            preparedStatement.setString(5, editAnimal.porte);
            preparedStatement.setInt(6, editAnimal.idade_animal);
            preparedStatement.setString(7, editAnimal.describe);
            preparedStatement.setInt(8, editAnimal.animal_id);
            preparedStatement.execute();
        }
    }
}
