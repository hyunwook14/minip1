CREATE TABLE `board` (
	`NO` INT(11) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`COMMENT` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`id` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`delYN` VARCHAR(1) NULL DEFAULT 'N' COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`NO`)
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
AUTO_INCREMENT=8
;