/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Breno
 * Created: 19/10/2021
 */
CREATE SCHEMA `gerenciador_contas_bancarias` ;

CREATE TABLE IF NOT EXISTS `gerenciador_contas_bancarias`.`tipo_conta` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `gerenciador_contas_bancarias`.`Usuario` (
  `cpf` VARCHAR(14) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `idade` INT NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `gerenciador_contas_bancarias`.`Conta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero_conta` VARCHAR(45) NOT NULL,
  `numero_agencia` VARCHAR(45) NOT NULL,
  `vencimento` VARCHAR(6) NOT NULL,
  `cvv` INT NOT NULL,
  `Usuario_cpf` VARCHAR(14) NOT NULL,
  `tipo_conta_id` INT NOT NULL,
  `saldo` DECIMAL(16,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_Conta_Usuario_idx` (`Usuario_cpf` ASC),
  INDEX `fk_Conta_tipo_conta1_idx` (`tipo_conta_id` ASC),
  CONSTRAINT `fk_Conta_Usuario`
    FOREIGN KEY (`Usuario_cpf`)
    REFERENCES `gerenciador_contas_bancarias`.`Usuario` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conta_tipo_conta1`
    FOREIGN KEY (`tipo_conta_id`)
    REFERENCES `gerenciador_contas_bancarias`.`tipo_conta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `gerenciador_contas_bancarias`.`chaves_pix` (
  `chave` VARCHAR(45) NOT NULL,
  `Usuario_cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`chave`),
  INDEX `fk_chaves_pix_Usuario1_idx` (`Usuario_cpf` ASC, `chave` ASC),
  CONSTRAINT `fk_chaves_pix_Usuario1`
    FOREIGN KEY (`Usuario_cpf`)
    REFERENCES `gerenciador_contas_bancarias`.`Usuario` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `gerenciador_contas_bancarias`.`tipo_conta` (`id`, `descricao`) VALUES (1, 'conta corrente');
INSERT INTO `gerenciador_contas_bancarias`.`tipo_conta` (`id`, `descricao`) VALUES (2, 'conta poupança');
INSERT INTO `gerenciador_contas_bancarias`.`tipo_conta` (`id`, `descricao`) VALUES (3, 'conta digital');

