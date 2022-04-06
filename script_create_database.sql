-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MF0226_3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MF0226_3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MF0226_3` DEFAULT CHARACTER SET utf8 ;
USE `MF0226_3` ;

-- -----------------------------------------------------
-- Table `MF0226_3`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MF0226_3`.`curso` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `horas` FLOAT NOT NULL,
  PRIMARY KEY (`id_curso`),
  UNIQUE INDEX `id_curso_UNIQUE` (`id_curso` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MF0226_3`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MF0226_3`.`alumno` (
  `id_alumno` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(150) NOT NULL,
  UNIQUE INDEX `id_alumno_UNIQUE` (`id_alumno` ASC) VISIBLE,
  PRIMARY KEY (`id_alumno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MF0226_3`.`profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MF0226_3`.`profesor` (
  `id_profesor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_profesor`),
  UNIQUE INDEX `id_profesor_UNIQUE` (`id_profesor` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MF0226_3`.`imparticiones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MF0226_3`.`imparticiones` (
  `id_curso` INT NOT NULL,
  `id_profesor` INT NOT NULL,
  `cod_curso` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  PRIMARY KEY (`id_curso`, `id_profesor`, `cod_curso`),
  INDEX `fk_curso_has_profesor_profesor1_idx` (`id_profesor` ASC) VISIBLE,
  INDEX `fk_curso_has_profesor_curso1_idx` (`id_curso` ASC) VISIBLE,
  UNIQUE INDEX `cod_curso_UNIQUE` (`cod_curso` ASC) VISIBLE,
  CONSTRAINT `fk_curso_has_profesor_curso1`
    FOREIGN KEY (`id_curso`)
    REFERENCES `MF0226_3`.`curso` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_has_profesor_profesor1`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `MF0226_3`.`profesor` (`id_profesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MF0226_3`.`participantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MF0226_3`.`participantes` (
  `cod_curso` VARCHAR(45) NOT NULL,
  `id_alumno` INT NOT NULL,
  `nota` FLOAT NOT NULL,
  `resenia_valoracion` INT NOT NULL,
  `resenia_descripcion` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`cod_curso`, `id_alumno`),
  INDEX `fk_profesor_imparte_curso_has_alumno_alumno1_idx` (`id_alumno` ASC) VISIBLE,
  INDEX `fk_profesor_imparte_curso_has_alumno_profesor_imparte_curso_idx` (`cod_curso` ASC) VISIBLE,
  UNIQUE INDEX `cod_curso_UNIQUE` (`cod_curso` ASC) VISIBLE,
  CONSTRAINT `fk_profesor_imparte_curso_has_alumno_profesor_imparte_curso1`
    FOREIGN KEY (`cod_curso`)
    REFERENCES `MF0226_3`.`imparticiones` (`cod_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesor_imparte_curso_has_alumno_alumno1`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `MF0226_3`.`alumno` (`id_alumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
