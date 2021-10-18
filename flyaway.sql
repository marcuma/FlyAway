-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FlyAway
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FlyAway
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FlyAway` DEFAULT CHARACTER SET utf8 ;
USE `FlyAway` ;

-- -----------------------------------------------------
-- Table `FlyAway`.`tbl_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FlyAway`.`tbl_user` (
  `user_id` INT NOT NULL,
  `login_name` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FlyAway`.`tbl_airline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FlyAway`.`tbl_airline` (
  `airline_id` INT NOT NULL,
  `airline_name` VARCHAR(255) NULL,
  PRIMARY KEY (`airline_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FlyAway`.`tbl_passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FlyAway`.`tbl_passenger` (
  `passenger_id` INT NOT NULL,
  `first_name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  PRIMARY KEY (`passenger_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FlyAway`.`tbl_airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FlyAway`.`tbl_airport` (
  `airport_id` INT NOT NULL,
  `airport_code` VARCHAR(255) NULL,
  `airport_name` VARCHAR(255) NULL,
  `airport_location` VARCHAR(255) NULL,
  PRIMARY KEY (`airport_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FlyAway`.`tbl_flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FlyAway`.`tbl_flight` (
  `flight_id` INT NOT NULL,
  `fk_source` INT NOT NULL,
  `fk_destination` INT NOT NULL,
  `date` DATETIME NULL,
  `fk_airline_id` INT NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`flight_id`, `fk_source`, `fk_destination`, `fk_airline_id`),
  INDEX `airline_id_idx` (`fk_airline_id` ASC) VISIBLE,
  INDEX `source_idx` (`fk_source` ASC) VISIBLE,
  INDEX `destination_idx` (`fk_destination` ASC) VISIBLE,
  CONSTRAINT `airline_id`
    FOREIGN KEY (`fk_airline_id`)
    REFERENCES `FlyAway`.`tbl_airline` (`airline_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `source`
    FOREIGN KEY (`fk_source`)
    REFERENCES `FlyAway`.`tbl_airport` (`airport_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `destination`
    FOREIGN KEY (`fk_destination`)
    REFERENCES `FlyAway`.`tbl_airport` (`airport_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FlyAway`.`tbl_ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FlyAway`.`tbl_ticket` (
  `ticket_id` INT NOT NULL,
  `ticket_price` DECIMAL(5,2) NULL,
  `passenger_id` INT NOT NULL,
  `flight_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`, `passenger_id`, `flight_id`),
  INDEX `flight_id_idx` (`flight_id` ASC) VISIBLE,
  INDEX `passenger_id_idx` (`passenger_id` ASC) VISIBLE,
  CONSTRAINT `passenger_id`
    FOREIGN KEY (`passenger_id`)
    REFERENCES `FlyAway`.`tbl_passenger` (`passenger_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_id`
    FOREIGN KEY (`flight_id`)
    REFERENCES `FlyAway`.`tbl_flight` (`flight_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -------------------------------------------------------
-- Insert initial data into database
-- -------------------------------------------------------
insert into FlyAway.tbl_user values (1, "admin", "test123");

insert into FlyAway.tbl_airline values (1, "Southwest Airlines");
insert into FlyAway.tbl_airline values (2, "American Airlines");
insert into FlyAway.tbl_airline values (3, "Delta Airlines");
insert into FlyAway.tbl_airline values (4, "Sprint Airlines");
insert into FlyAway.tbl_airline values (5, "United Airlines");
insert into FlyAway.tbl_airline values (6, "Fronteir Airlines");

insert into FlyAway.tbl_airport values (1, "ATL", "Hartsfield-Jackson Atlanta International", "Atlanta, Ga");
insert into FlyAway.tbl_airport values (2, "ORD", "Chicago O'Hare International", "Chicago, IL");
insert into FlyAway.tbl_airport values (3, "CMH", "Port Columbus International", "Columbus, OH");
insert into FlyAway.tbl_airport values (4, "HNL", "Hawaii Honolulu International", "Honolulu, HI");
insert into FlyAway.tbl_airport values (5, "LAX", "Los Angeles International", "Los Angeles, CA");
insert into FlyAway.tbl_airport values (6, "LGA", "LaGuardia International", "New York, NY");

insert into FlyAway.tbl_flight (flight_id, fk_source, fk_destination, date, fk_airline_id, price) values (1, 3, 5, "2021-12-15", 1, 600.00); 
insert into FlyAway.tbl_flight (flight_id, fk_source, fk_destination, date, fk_airline_id, price) values (2, 5, 3, "2021-12-22", 1, 300.00);
insert into FlyAway.tbl_flight (flight_id, fk_source, fk_destination, date, fk_airline_id, price) values (3, 3, 2, "2021-11-13", 5, 400.00);
insert into FlyAway.tbl_flight (flight_id, fk_source, fk_destination, date, fk_airline_id, price) values (4, 2, 3, "2021-11-20", 5, 250.00);
