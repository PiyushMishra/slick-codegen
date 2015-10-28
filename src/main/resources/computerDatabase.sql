CREATE TABLE `Companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Computers` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(40) NOT NULL,
`introduced` DATE,
`discontinued` DATE,
`companyId` int(11),
PRIMARY KEY (`id`),
FOREIGN KEY fk_company_id(companyId)
   REFERENCES Companies(id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) Engine = InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Persons` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(50) NOT NULL,
`address` varchar (250) NOT NULL,
`companyId` int(11),
`computerId` int(11),
PRIMARY KEY (`id`),

FOREIGN KEY fk_company_id(companyId)
   REFERENCES Companies(id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT,

FOREIGN KEY fk_computer_id(computerID)
   REFERENCES Computers(id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1; 
