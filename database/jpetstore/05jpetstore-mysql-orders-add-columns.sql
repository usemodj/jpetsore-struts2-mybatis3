ALTER TABLE `jpetstore`.`orders` ADD COLUMN `shipcellphone` VARCHAR(20) NULL DEFAULT NULL  AFTER `shipzip` , 
ADD COLUMN `shipphone` VARCHAR(20) NULL DEFAULT NULL  AFTER `shipzip` ;

