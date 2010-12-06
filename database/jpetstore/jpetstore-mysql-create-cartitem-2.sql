CREATE  TABLE IF NOT EXISTS `jpetstore`.`cartitem` (

  `userid` VARCHAR(80) NOT NULL ,

  `itemid` VARCHAR(10) NOT NULL ,

  `quantity` INT NULL ,

  `instock` VARCHAR(4) NULL ,

  `total` DECIMAL(10,2) NULL ,

  `created_on` DATE NULL ,

  PRIMARY KEY (`userid`, `itemid`) ,

  INDEX (`itemid` ASC) ,

  INDEX (`userid` ASC) ,

  CONSTRAINT `fk_itemid_1`

    FOREIGN KEY (`itemid` )

    REFERENCES `jpetstore`.`item` (`itemid` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_userid_2`

    FOREIGN KEY (`userid` )

    REFERENCES `jpetstore`.`account` (`userid` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION);

