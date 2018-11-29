CREATE TABLE `cart` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `cart_thing` (
    `cart_id` INT UNSIGNED NOT NULL,
    `thing_id` INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
    CONSTRAINT `fk_thing_id` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;