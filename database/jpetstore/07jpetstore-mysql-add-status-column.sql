ALTER TABLE `jpetstore`.`category` ADD COLUMN `status` VARCHAR(2) NULL  AFTER `descn` ;
ALTER TABLE `jpetstore`.`product` ADD COLUMN `status` VARCHAR(2) NULL  AFTER `descn` ;