package com.example.semestralfd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OngDAO {

    public boolean ong_existe(Ong ong) throws SQLException {
        String sql =  "select count(*) from ong where ong_login = ? AND ong_senha = ? ";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, ong.ong_login);
            preparedStatement.setString(2, ong.ong_senha);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                resultado.next();
                int quantidadeOngs = resultado.getInt(1);

                if (quantidadeOngs > 0) {
                    return true;
                } else {
                    return false;
                }

            }
        }
    }
    public void insertOng(Ong novaOng) throws SQLException {
        String sql = "insert into ong (ong_id, endereco_endereco_id, ong_login, ong_senha, ong_nome, ong_num, ong_email, nvl_acesso) values" +
                "(?, ?, ?, ?, ?, ?, ?, 3)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql);){
            preparedStatement.setInt(1, novaOng.ong_id);
            preparedStatement.setInt(2, novaOng.ong_endereco_id);
            preparedStatement.setString(3, novaOng.ong_login);
            preparedStatement.setString(4, novaOng.ong_senha);
            preparedStatement.setString(5, novaOng.ong_nome);
            preparedStatement.setInt(6, novaOng.ong_telefone);
            preparedStatement.setString(7, novaOng.ong_email);


            preparedStatement.execute();
        }
    }
}
