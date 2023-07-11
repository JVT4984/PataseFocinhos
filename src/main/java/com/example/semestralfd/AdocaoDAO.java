package com.example.semestralfd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdocaoDAO {

    public List<Adocao> getAdocoes() throws SQLException {
        try (Statement statement = ConnectionSingleton.getConnection().createStatement();
             ResultSet rs = statement.executeQuery("select * from adocoes;")) {
            List<Adocao> adocaos = new ArrayList<>();
            while (rs.next()) {
                Adocao adocao = new Adocao();
                adocao.adocao_id = rs.getInt(1);
                adocao.adocao_usuario_id = rs.getInt(2);
                adocao.adocao_ong_id = rs.getInt(3);
                adocao.adocao_animal_id = rs.getInt(4);
                adocao.data_adocao = rs.getDate(5);

            }
            return adocaos;
        }

    }

    public void insertAdocao(Adocao novaAdocao) throws SQLException {
        String sql = "insert into adocoes (adocao_id, usuario_usuario_id, ong_ong_id, animal_animal_id, data_adocao) values (?, ?, ?, ?, ?)";
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


