package com.example.semestralfd;

import java.sql.*;

public class UsuarioDAO {

    public boolean existe(Usuario usuario) throws SQLException {
        String sql =  "select count(*) from usuario where usuario_login = ? AND usuario_senha = ? ";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.usuario_login);
            preparedStatement.setString(2, usuario.usuario_senha);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                resultado.next();
                int quantidadeUsuarios = resultado.getInt(1);

                if (quantidadeUsuarios > 0) {
                    return true;
                } else {
                    return false;
                }

            }
        }
    }
    public void insertUsuario(Usuario novoUsuario) throws SQLException {
        String sql = "insert into usuario (usuario_id, endereco_endereco_id, usuario_login, usuario_senha, usuario_nome," +
                " usuario_num, usuario_email, nvl_acesso, usuario_dtcadastro) values(?, ?, ?, ?, ?, ?, ?, 2, ?)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql);){
            preparedStatement.setInt(1, novoUsuario.usuario_id);
            preparedStatement.setString(2, novoUsuario.usuario_login);
            preparedStatement.setString(3, novoUsuario.usuario_senha);
            preparedStatement.setString(4, novoUsuario.usuario_nome);
            preparedStatement.setInt(5, novoUsuario.usuario_numero);
            preparedStatement.setString(6, novoUsuario.usuario_email);
            preparedStatement.setInt(7, novoUsuario.usuario_endereco_id);

            preparedStatement.execute();
        }
    }
}