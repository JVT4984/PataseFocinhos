-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 28-Jun-2023 às 00:19
-- Versão do servidor: 5.7.36
-- versão do PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `patasebigodes`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `animal_id` int(11) NOT NULL AUTO_INCREMENT,
  `ong_ong_id` int(11) NOT NULL,
  `tipo__animal` varchar(45) NOT NULL,
  `raca_animal` varchar(20) NOT NULL,
  `sexo_animal` varchar(45) NOT NULL,
  `porte_animal` varchar(45) NOT NULL,
  `idade` int(2) NOT NULL,
  `descricao_animal` varchar(255) NOT NULL,
  `dtcadastro_animal` date NOT NULL,
  PRIMARY KEY (`animal_id`,`ong_ong_id`),
  KEY `fk_animal_ong1_idx` (`ong_ong_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`animal_id`, `ong_ong_id`, `tipo__animal`, `raca_animal`, `sexo_animal`, `porte_animal`, `idade`, `descricao_animal`, `dtcadastro_animal`) VALUES
(2, 1, 'Cachorro', 'Doberman', 'Feminino', 'Grande', 2, 'Bonito e protetor', '2023-06-03');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE IF NOT EXISTS `endereco` (
  `endereco_id` int(11) NOT NULL AUTO_INCREMENT,
  `pais` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  PRIMARY KEY (`endereco_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`endereco_id`, `pais`, `estado`, `cidade`) VALUES
(1, 'Brasil', 'Santa Catarina', 'Timbó');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ong`
--

DROP TABLE IF EXISTS `ong`;
CREATE TABLE IF NOT EXISTS `ong` (
  `ong_id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco_endereco_id` int(11) NOT NULL,
  `ong_login` varchar(100) NOT NULL,
  `ong_senha` varchar(100) NOT NULL,
  `ong_nome` varchar(100) NOT NULL,
  `ong_num` varchar(10) NOT NULL,
  `ong_email` varchar(50) NOT NULL,
  `nvl_acesso` int(1) NOT NULL,
  `ong_dtcadastro` date NOT NULL,
  PRIMARY KEY (`ong_id`,`endereco_endereco_id`),
  KEY `fk_ong_endereco1_idx` (`endereco_endereco_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ong`
--

INSERT INTO `ong` (`ong_id`, `endereco_endereco_id`, `ong_login`, `ong_senha`, `ong_nome`, `ong_num`, `ong_email`, `nvl_acesso`, `ong_dtcadastro`) VALUES
(1, 1, 'ong', '123', 'Ong Timbó', '2222222222', 'ong@gmail', 3, '2023-06-03');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco_endereco_id` int(11) NOT NULL,
  `usuario_login` varchar(100) NOT NULL,
  `usuario_senha` varchar(45) NOT NULL,
  `usuario_nome` varchar(75) NOT NULL,
  `usuario_num` varchar(10) NOT NULL,
  `usuario_email` varchar(50) NOT NULL,
  `nvl_acesso` int(1) NOT NULL,
  `usuario_dtcadastro` date NOT NULL,
  PRIMARY KEY (`usuario_id`,`endereco_endereco_id`),
  KEY `fk_usuario_endereco1_idx` (`endereco_endereco_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usuario_id`, `endereco_endereco_id`, `usuario_login`, `usuario_senha`, `usuario_nome`, `usuario_num`, `usuario_email`, `nvl_acesso`, `usuario_dtcadastro`) VALUES
(1, 1, 'adm', '123', 'admin', '1111111111', 'admin@gmail', 1, '2023-06-03');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `fk_animal_ong1` FOREIGN KEY (`ong_ong_id`) REFERENCES `ong` (`ong_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `ong`
--
ALTER TABLE `ong`
  ADD CONSTRAINT `fk_ong_endereco1` FOREIGN KEY (`endereco_endereco_id`) REFERENCES `endereco` (`endereco_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_endereco1` FOREIGN KEY (`endereco_endereco_id`) REFERENCES `endereco` (`endereco_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
