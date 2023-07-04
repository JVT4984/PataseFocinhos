package com.example.semestralfd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> getAll() throws SQLException {
        try (Statement statement = ConnectionSingleton.getConnection().createStatement();
             ResultSet rs = statement.executeQuery("select * from usuario;")) {
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.usuario_id = rs.getInt(1);
                usuario.usuario_endereco_id = rs.getInt(2);
                usuario.usuario_login = rs.getString(3);
                usuario.usuario_senha = rs.getString(4);
                usuario.usuario_nome = rs.getString(5);
                usuario.usuario_numero = rs.getInt(6);
                usuario.usuario_email = rs.getString(7);
                usuario.usuario_nvl_acesso = rs.getInt(8);
                usuarios.add(usuario);
            }
            return usuarios;
        }

    }

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
                " usuario_num, usuario_email, nvl_acesso) values(?, ?, ?, ?, ?, ?, ?, 2)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql);){
            preparedStatement.setInt(1, novoUsuario.usuario_id);
            preparedStatement.setInt(2, novoUsuario.usuario_endereco_id);
            preparedStatement.setString(3, novoUsuario.usuario_login);
            preparedStatement.setString(4, novoUsuario.usuario_senha);
            preparedStatement.setString(5, novoUsuario.usuario_nome);
            preparedStatement.setInt(6, novoUsuario.usuario_numero);
            preparedStatement.setString(7, novoUsuario.usuario_email);


            preparedStatement.execute();
        }
    }

    public void delete(Usuario deleteUsuario) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement("delete from usuario where usuario_id = ?")) {
            preparedStatement.setInt(1, deleteUsuario.usuario_id);
            preparedStatement.execute();

        }
    }

    public void update (Usuario editUsuario) throws SQLException {
        String sql = "update usuario SET endereco_endereco_id = ?, usuario_nome = ?, usuario_num = ?, usuario_email = ? where usuario_id = ?";
        try ( PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, editUsuario.usuario_endereco_id);
            preparedStatement.setString(2, editUsuario.usuario_nome);
            preparedStatement.setInt(3, editUsuario.usuario_numero);
            preparedStatement.setString(4, editUsuario.usuario_email);
            preparedStatement.setInt(5, editUsuario.usuario_id);
            preparedStatement.execute();
        }
    }
}