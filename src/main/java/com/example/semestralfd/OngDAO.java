package com.example.semestralfd;

import java.sql.*;
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
                ong.ong_telefone = rs.getString(6);
                ong.ong_email = rs.getString(7);
                ong.ong_endereco_id = rs.getInt(2);
                ong.ong_nvl_acesso = rs.getInt(8);
                ongs.add(ong);
            }
            return ongs;
        }

    }
    public void insertOng(Ong novaOng) throws SQLException {
        String sql = "insert into ong (ong_id, endereco_endereco_id, ong_login, ong_senha, ong_nome, ong_num, ong_email, nvl_acesso, ong_dt_cadastro) values" +
                "(?, ?, ?, ?, ?, ?, ?, 3, ?)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql);){
            preparedStatement.setInt(1, novaOng.ong_id);
            preparedStatement.setInt(2, novaOng.ong_endereco_id);
            preparedStatement.setString(3, novaOng.ong_login);
            preparedStatement.setString(4, novaOng.ong_senha);
            preparedStatement.setString(5, novaOng.ong_nome);
            preparedStatement.setString(6, novaOng.ong_telefone);
            preparedStatement.setString(7, novaOng.ong_email);
            preparedStatement.setDate(8, (Date) novaOng.ong_dt_cadastro);


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
        String sql = "update ong SET endereco_endereco_id = ?, ong_login = ?, ong_senha = ?, ong_nome = ?, ong_num = ?, ong_email = ? where ong_id = ?";
        try ( PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, editOng.ong_endereco_id);
            preparedStatement.setString(2, editOng.ong_login);
            preparedStatement.setString(3, editOng.ong_senha);
            preparedStatement.setString(4, editOng.ong_nome);
            preparedStatement.setString(5, editOng.ong_telefone);
            preparedStatement.setString(6, editOng.ong_email);
            preparedStatement.setInt(7, editOng.ong_id);
            preparedStatement.execute();
        }
    }

    public static Ong getOng(Ong ong) throws SQLException {
        String sql =  "select * from ong where ong_login = ? AND ong_senha = ? ";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, ong.ong_login);
            preparedStatement.setString(2, ong.ong_senha);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    Ong ongLogada = new Ong();
                    ongLogada.ong_id = resultado.getInt("ong_id");
                    ongLogada.ong_endereco_id = resultado.getInt("endereco_endereco_id");
                    ongLogada.ong_login = resultado.getString("ong_login");
                    ongLogada.ong_senha = resultado.getString("ong_senha");
                    ongLogada.ong_nome = resultado.getString("ong_nome");
                    ongLogada.ong_telefone = resultado.getString("ong_num");
                    ongLogada.ong_email = resultado.getString("ong_email");
                    ongLogada.ong_nvl_acesso = resultado.getInt("nvl_acesso");
                    return ongLogada;
                } else {
                    return null;
                }
            }
        }
    }
}
