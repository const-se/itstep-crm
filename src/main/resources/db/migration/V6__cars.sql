CREATE TABLE `cars` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `brand_id` INT UNSIGNED NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `cost` INT NOT NULL DEFAULT 0,
    `description` TEXT NOT NULL,
    PRIMARY KEY (`id`),
    KEY `brand_id` (`brand_id`),
    CONSTRAINT `fk_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
