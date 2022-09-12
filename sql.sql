CREATE SCHEMA `expensereimbursementsystem` ;

CREATE TABLE expensereimbursementsystem.user (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   userType varchar(255),
   username varchar(255),
   password varchar(255)
) 

CREATE TABLE expensereimbursementsystem.ticket (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  employeeId int NOT NULL,
  expense int NOT NULL,
  reason varchar(255) DEFAULT NULL,
  status varchar(255) DEFAULT NULL
)


INSERT INTO expensereimbursementsystem.user (`userType`, `username`, `password`) VALUES ('employee', 'emp1','emp1');
INSERT INTO expensereimbursementsystem.user (`userType`, `username`, `password`) VALUES ('employee', 'emp10','emp10');
INSERT INTO expensereimbursementsystem.user (`userType`, `username`, `password`) VALUES ('manager', 'manager1','manager1');

