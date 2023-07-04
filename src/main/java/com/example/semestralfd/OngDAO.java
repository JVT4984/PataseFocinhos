package com.example.semestralfd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<Ong> getAll() throws SQLException {
        try (Statement statement = ConnectionSingleton.getConnection().createStatement();
             ResultSet rs = statement.executeQuery("select * from ong;")) {
            List<Ong> ongs = new ArrayList<>();
            while (rs.next()) {
                Ong ong = new Ong();
                ong.ong_id = rs.getInt(1);
                ong.ong_login = rs.getString(3);
                ong.ong_senha = rs.getString(4);
                ong.ong_nome = rs.getString(5);
                ong.ong_telefone = rs.getInt(6);
                ong.ong_email = rs.getString(7);
                ong.ong_endereco_id = rs.getInt(2);
                ong.ong_nvl_acesso = rs.getInt(8);
                ongs.add(ong);
            }
            return ongs;
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

    public void delete(Ong deleteOng) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement("delete from ong where ong_id = ?")) {
            preparedStatement.setInt(1, deleteOng.ong_id);
            preparedStatement.execute();

        }
    }

    public void update (Ong editOng) throws SQLException {
        String sql = "update ong SET endereco_endereco_id, ong_nome, ong_num, ong_email where ong_id = ?";
        try ( PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, editOng.ong_endereco_id);
            preparedStatement.setString(2, editOng.ong_nome);
            preparedStatement.setInt(3, editOng.ong_telefone);
            preparedStatement.setString(4, editOng.ong_email);
            preparedStatement.execute();
        }
    }
}
