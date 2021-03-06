-- MySQL Script generated by MySQL Workbench
-- Tue Nov  2 23:05:27 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema meubanco
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema meubanco
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `meubanco` DEFAULT CHARACTER SET utf8 ;
USE `meubanco` ;

-- -----------------------------------------------------
-- Table `meubanco`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `nascimento` DATE NOT NULL,
  `sexo` VARCHAR(20) NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(255) NOT NULL,
  `rua` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(20) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`oficina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`oficina` (
  `id_oficina` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `cidade` VARCHAR(255) NOT NULL,
  `Rua` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(20) NOT NULL,
  `bairro` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_oficina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`item` (
  `id_item` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `preco` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`id_item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`modelo_fabricante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`modelo_fabricante` (
  `id_modelo_fabricante` INT NOT NULL AUTO_INCREMENT,
  `fabricante` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_modelo_fabricante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`bicicleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`bicicleta` (
  `id_bicicleta` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  `id_modelo_fabricante` INT NOT NULL,
  PRIMARY KEY (`id_bicicleta`),
  INDEX `fk_bicicleta_modelo_fabricante1_idx` (`id_modelo_fabricante` ASC) VISIBLE,
  CONSTRAINT `fk_bicicleta_modelo_fabricante1`
    FOREIGN KEY (`id_modelo_fabricante`)
    REFERENCES `meubanco`.`modelo_fabricante` (`id_modelo_fabricante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`cliente_bicicleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`cliente_bicicleta` (
  `id_cliente` INT NOT NULL,
  `id_bicicleta` INT NOT NULL,
  `id_cliente_bicicleta` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_cliente_bicicleta`),
  INDEX `fk_cliente_has_bicicleta_bicicleta1_idx` (`id_bicicleta` ASC) VISIBLE,
  INDEX `fk_cliente_has_bicicleta_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_bicicleta_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `meubanco`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_bicicleta_bicicleta1`
    FOREIGN KEY (`id_bicicleta`)
    REFERENCES `meubanco`.`bicicleta` (`id_bicicleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`ordem_servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`ordem_servico` (
  `id_ordem` INT NOT NULL AUTO_INCREMENT,
  `id_oficina` INT NOT NULL,
  `id_cliente_bicicleta` INT NOT NULL,
  `valor_total` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`id_ordem`),
  INDEX `fk_ordem_servico_oficina1_idx` (`id_oficina` ASC) VISIBLE,
  INDEX `fk_ordem_servico_cliente_bicicleta1_idx` (`id_cliente_bicicleta` ASC) VISIBLE,
  CONSTRAINT `fk_ordem_servico_oficina1`
    FOREIGN KEY (`id_oficina`)
    REFERENCES `meubanco`.`oficina` (`id_oficina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordem_servico_cliente_bicicleta1`
    FOREIGN KEY (`id_cliente_bicicleta`)
    REFERENCES `meubanco`.`cliente_bicicleta` (`id_cliente_bicicleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`mao_de_obra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`mao_de_obra` (
  `id_mao_de_obra` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  `valor_mao_de_obra` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`id_mao_de_obra`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`ordem_servico_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`ordem_servico_item` (
  `id_item` INT NOT NULL AUTO_INCREMENT,
  `id_ordem_servico` INT NOT NULL,
  `id_ordem_servico_item` INT NOT NULL,
  `id_mao_de_obra` INT NOT NULL,
  PRIMARY KEY (`id_ordem_servico_item`),
  INDEX `fk_itens_has_ordem_servico_ordem_servico1_idx` (`id_ordem_servico` ASC) VISIBLE,
  INDEX `fk_itens_has_ordem_servico_itens1_idx` (`id_item` ASC) VISIBLE,
  INDEX `fk_ordem_servico_item_mao_de_obra1_idx` (`id_mao_de_obra` ASC) VISIBLE,
  CONSTRAINT `fk_itens_has_ordem_servico_itens1`
    FOREIGN KEY (`id_item`)
    REFERENCES `meubanco`.`item` (`id_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_has_ordem_servico_ordem_servico1`
    FOREIGN KEY (`id_ordem_servico`)
    REFERENCES `meubanco`.`ordem_servico` (`id_ordem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordem_servico_item_mao_de_obra1`
    FOREIGN KEY (`id_mao_de_obra`)
    REFERENCES `meubanco`.`mao_de_obra` (`id_mao_de_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`cliente_telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`cliente_telefone` (
  `id_cliente_telefone` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  INDEX `fk_cliente_telefone_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  PRIMARY KEY (`id_cliente_telefone`),
  CONSTRAINT `fk_cliente_telefone_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `meubanco`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`oficina_telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`oficina_telefone` (
  `id_oficina_telefone` INT NOT NULL AUTO_INCREMENT,
  `telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_oficina_telefone`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`agendamento` (
  `id_agendamento` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `horario` DATETIME NOT NULL,
  `cliente_id_cliente` INT NOT NULL,
  `oficina_id_oficina` INT NOT NULL,
  `ordem_servico_id_ordem` INT NOT NULL,
  PRIMARY KEY (`id_agendamento`),
  INDEX `fk_agendamento_cliente1_idx` (`cliente_id_cliente` ASC) VISIBLE,
  INDEX `fk_agendamento_oficina1_idx` (`oficina_id_oficina` ASC) VISIBLE,
  INDEX `fk_agendamento_ordem_servico1_idx` (`ordem_servico_id_ordem` ASC) VISIBLE,
  CONSTRAINT `fk_agendamento_cliente1`
    FOREIGN KEY (`cliente_id_cliente`)
    REFERENCES `meubanco`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendamento_oficina1`
    FOREIGN KEY (`oficina_id_oficina`)
    REFERENCES `meubanco`.`oficina` (`id_oficina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendamento_ordem_servico1`
    FOREIGN KEY (`ordem_servico_id_ordem`)
    REFERENCES `meubanco`.`ordem_servico` (`id_ordem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`pergunta_seguranca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`pergunta_seguranca` (
  `id_pergunta_seguranca` INT NOT NULL AUTO_INCREMENT,
  `descricao_pergunta` VARCHAR(45) NULL,
  PRIMARY KEY (`id_pergunta_seguranca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meubanco`.`pergunta_seguranca_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meubanco`.`pergunta_seguranca_cliente` (
  `id_pergunta_seguranca_cliente` INT NOT NULL AUTO_INCREMENT,
  `desc_reposta_cliente` VARCHAR(222) NULL,
  `pergunta_seguranca_id_pergunta_seguranca` INT NOT NULL,
  `cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_pergunta_seguranca_cliente`, `pergunta_seguranca_id_pergunta_seguranca`, `cliente_id_cliente`),
  INDEX `fk_pergunta_seguranca_cliente_pergunta_seguranca1_idx` (`pergunta_seguranca_id_pergunta_seguranca` ASC) VISIBLE,
  INDEX `fk_pergunta_seguranca_cliente_cliente1_idx` (`cliente_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_pergunta_seguranca_cliente_pergunta_seguranca1`
    FOREIGN KEY (`pergunta_seguranca_id_pergunta_seguranca`)
    REFERENCES `meubanco`.`pergunta_seguranca` (`id_pergunta_seguranca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pergunta_seguranca_cliente_cliente1`
    FOREIGN KEY (`cliente_id_cliente`)
    REFERENCES `meubanco`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
