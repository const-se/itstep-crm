ALTER TABLE `orders` ADD COLUMN `car_id` INT UNSIGNED NULL;

ALTER TABLE `orders` ADD KEY `car_id` (`car_id`);

ALTER TABLE `orders` ADD CONSTRAINT `fk_car_id` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`);
