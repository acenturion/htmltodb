/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  acenturion
 * Created: 20/09/2017
 */

drop database htmltodb
create database htmltodb
USE htmltodb;

create table regresion(
id int not null auto_increment,
pais varchar(20),
idnegocio int,
inicio varchar(30),
fin varchar(30),
idresponsable int,
versionRobot varchar(30),
primary key(id)
);

create table modulo(
   id int not null auto_increment,
   idcaso int ,
   idregresion int ,
   duracion varchar(30),
   primary key(id)
);



