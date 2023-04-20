-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbalura
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbalura
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbalura` DEFAULT CHARACTER SET utf8mb4 ;
USE `dbalura` ;

-- -----------------------------------------------------
-- Table `dbalura`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbalura`.`categoria` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `dbalura`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbalura`.`produto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `CATEGORIA_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `CATEGORIA_ID` (`CATEGORIA_ID` ASC),
  CONSTRAINT `produto_ibfk_1`
    FOREIGN KEY (`CATEGORIA_ID`)
    REFERENCES `dbalura`.`categoria` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
