ALTER TABLE `jpetstore`.`orders` 
CHANGE COLUMN `userid` `userid` VARCHAR(80) NULL  , 
CHANGE COLUMN `orderdate` `orderdate` DATE NULL  , 
CHANGE COLUMN `shipaddr1` `shipaddr1` VARCHAR(80) NULL  , 
CHANGE COLUMN `shipcity` `shipcity` VARCHAR(80) NULL  , 
CHANGE COLUMN `shipstate` `shipstate` VARCHAR(80) NULL  , 
CHANGE COLUMN `shipzip` `shipzip` VARCHAR(20) NULL  , 
CHANGE COLUMN `shipcountry` `shipcountry` VARCHAR(20) NULL  , 
CHANGE COLUMN `billaddr1` `billaddr1` VARCHAR(80) NULL  , 
CHANGE COLUMN `billcity` `billcity` VARCHAR(80) NULL  , 
CHANGE COLUMN `billstate` `billstate` VARCHAR(80) NULL  , 
CHANGE COLUMN `billzip` `billzip` VARCHAR(20) NULL  , 
CHANGE COLUMN `billcountry` `billcountry` VARCHAR(20) NULL  , 
CHANGE COLUMN `courier` `courier` VARCHAR(80) NULL  , 
CHANGE COLUMN `totalprice` `totalprice` DECIMAL(10,2) NULL  , 
CHANGE COLUMN `billtofirstname` `billtofirstname` VARCHAR(80) NULL  , 
CHANGE COLUMN `billtolastname` `billtolastname` VARCHAR(80) NULL  , 
CHANGE COLUMN `shiptofirstname` `shiptofirstname` VARCHAR(80) NULL  , 
CHANGE COLUMN `shiptolastname` `shiptolastname` VARCHAR(80) NULL  , 
CHANGE COLUMN `creditcard` `creditcard` VARCHAR(80) NULL  , 
CHANGE COLUMN `exprdate` `exprdate` VARCHAR(7) NULL  , 
CHANGE COLUMN `cardtype` `cardtype` VARCHAR(80) NULL  , 
CHANGE COLUMN `locale` `locale` VARCHAR(80) NULL  ;



