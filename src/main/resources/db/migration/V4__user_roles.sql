CREATE TABLE `user_roles` (
    `user_id` INT UNSIGNED NOT NULL,
    `role_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT IGNORE INTO `users` (
    `username`,
    `password`
) VALUES (
    "admin",
    "$2a$10$b1jhaUmEYFrtD6MI5CC01uV.ILPFKOV0Dh96gOCN8x4Ai7O5U.rpK"
);

INSERT INTO `user_roles`
SELECT u.`id` AS `user_id`, r.`id` AS `role_id`
FROM `roles` r
LEFT JOIN `users` u ON u.`username` = "admin";
