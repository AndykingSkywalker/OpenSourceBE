DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255)
);

CREATE TABLE `item` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255),
	`quantity` DOUBLE,
	`price` DOUBLE,
	`basket_id` INT,
	FOREIGN KEY (`basket_id`) REFERENCES `basket` (`id`)
);