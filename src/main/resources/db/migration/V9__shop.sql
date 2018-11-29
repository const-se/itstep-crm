CREATE TABLE `brand` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `category` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `thing` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `brand_id` INT UNSIGNED NOT NULL,
    `category_id` INT UNSIGNED NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `cost` INT NOT NULL,
    `thing_size` INT NOT NULL,
    `color` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_brand_id2` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
    CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
