package com.example.semestralfd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



class RelatorioDAO {

    public List<Usuario> pesquisarUsuariosOrdenadosPorData() throws SQLException {
        Statement statement = ConnectionSingleton.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario ORDER BY usuario_dt_cadastro ASC");
        List<Usuario> usuarios = new ArrayList<>();

        while (resultSet.next()) {
            Usuario usuario = new Usuario();
            usuario.setUsuario_id(resultSet.getInt("usuario_id"));
            usuario.setUsuario_endereco_id(resultSet.getInt("endereco_endereco_id"));
            usuario.setUsuario_login(resultSet.getString("usuario_login"));
            usuario.setUsuario_senha(resultSet.getString("usuario_senha"));
            usuario.setUsuario_nome(resultSet.getString("usuario_nome"));
            usuario.setUsuario_numero(resultSet.getString("usuario_num"));
            usuario.setUsuario_email(resultSet.getString("usuario_email"));
            usuario.setUsuario_nvl_acesso(resultSet.getInt("nvl_acesso"));
            usuario.setUsuario_dt_cadastro(resultSet.getDate("usuario_dt_cadastro"));
            usuarios.add(usuario);
        }

        return usuarios;
    }

    public List<Animal> pesquisarAnimaisOrdenadosPorData() throws SQLException {
        Statement statement = ConnectionSingleton.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal ORDER BY animal_dt_cadastro ASC");
        List<Animal> animais = new ArrayList<>();

        while (resultSet.next()) {
            Animal animal = new Animal();
            animal.setAnimal_id(resultSet.getInt("animal_id"));
            animal.setOng_id(resultSet.getInt("ong_ong_id"));
            animal.setTipo_animal(resultSet.getString("tipo_animal"));
            animal.setRaca(resultSet.getString("raca_animal"));
            animal.setSexo_animal(resultSet.getString("sexo_animal"));
            animal.setPorte(resultSet.getString("porte_animal"));
            animal.setIdade_animal(resultSet.getInt("idade"));
            animal.setDescribe(resultSet.getString("descricao_animal"));
            animal.setAnimal_dt_cadastro(resultSet.getDate("animal_dt_cadastro"));
            animais.add(animal);
        }

        return animais;
    }

    public List<Adocao> pesquisarAdocoesOrdenadosPorData() throws SQLException {
        Statement statement = ConnectionSingleton.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM adocoes ORDER BY data_adocao ASC");
        List<Adocao> adocoes = new ArrayList<>();

        while (resultSet.next()) {
            Adocao adocao = new Adocao();
            adocao.setAdocao_id(resultSet.getInt(1));
            adocao.setAdocao_usuario_id(resultSet.getInt(2));
            adocao.setAdocao_ong_id(resultSet.getInt(3));
            adocao.setAdocao_animal_id(resultSet.getInt(4));
            adocao.setData_adocao(resultSet.getDate(5));
            adocoes.add(adocao);
        }

        return adocoes;
    }

}

