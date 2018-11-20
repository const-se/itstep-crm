ALTER TABLE `users` DROP COLUMN `role`;

CREATE TABLE `roles` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX (`name`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `roles` (
    `name`
) VALUES (
    "ROLE_USER"
), (
    "ROLE_ADMIN"
);
