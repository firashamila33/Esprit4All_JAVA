CREATE TABLE `espritforall`.`AnnonceObjetPerdu` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(50) NOT NULL , `description` VARCHAR(50) NOT NULL , `owner_id` INT NOT NULL , `creationDate` DATE NOT NULL , `expirationDate` DATE NOT NULL , `objectDescription` VARCHAR(50) NOT NULL , `lossDate` DATE NOT NULL , `lossLocation` VARCHAR(100) NOT NULL , PRIMARY KEY (`id`));

ALTER TABLE `AnnonceObjetPerdu` ADD INDEX(`owner_id`);

CREATE TABLE `espritforall`.`AnnonceCoLocation` ( `id` INT NOT NULL AUTO_INCREMENT , `address_id` INT NOT NULL , `dimensions` VARCHAR(50) NOT NULL , `maxCoLocataire` INT NOT NULL , `loyer` FLOAT NOT NULL , `name` VARCHAR(50) NOT NULL , `description` VARCHAR(50) NOT NULL , `owner_id` INT NOT NULL , `creationDate` DATE NOT NULL , `expirationDate` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
ALTER TABLE `AnnonceCoLocation` ADD INDEX(`address_id`);
ALTER TABLE `AnnonceCoLocation` ADD INDEX(`owner_id`);
ALTER TABLE `AnnonceCoLocation` ADD CONSTRAINT `fk_ownerId` FOREIGN KEY (`owner_id`) REFERENCES `User`(`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `AnnonceCoLocation` ADD CONSTRAINT `fk_addressId` FOREIGN KEY (`address_id`) REFERENCES `Address`(`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
CREATE TABLE `espritforall`.`ImageAnnonce` ( `id` INT NOT NULL AUTO_INCREMENT , `annonceCoLocation_id` INT NOT NULL , `imageUrl` VARCHAR(100) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `espritforall`.`AnnonceCoLocataire_R` ( `id` INT NOT NULL AUTO_INCREMENT , `annonceCoLocation_id` INT NOT NULL , `User_id` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
ALTER TABLE `AnnonceCoLocataire_R` ADD CONSTRAINT `fk_AnnonceCoLocationId` FOREIGN KEY (`annonceCoLocation_id`) REFERENCES `AnnonceCoLocation`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `AnnonceCoLocataire_R` ADD CONSTRAINT `fk_UserId` FOREIGN KEY (`User_id`) REFERENCES `User`(`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `ImageAnnonce` ADD CONSTRAINT `fk_AnnonceCoLocation` FOREIGN KEY (`annonceCoLocation_id`) REFERENCES `AnnonceCoLocation`(`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
