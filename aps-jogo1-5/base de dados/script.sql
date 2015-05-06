create database jma;

use jma;

CREATE  TABLE `jma`.`recordes` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `movimentos` INT NOT NULL ,
  PRIMARY KEY (`id`) );	

drop table recordes;

insert into recordes (nome,movimentos) values('edu',25);
insert into recordes (nome,movimentos) values('joca',35);
insert into recordes (nome,movimentos) values('rick',36);
insert into recordes (nome,movimentos) values('feh',22);
insert into recordes (nome,movimentos) values('feh',24);
insert into recordes (nome,movimentos) values('edu',98);
insert into recordes (nome,movimentos) values('edu',120);
insert into recordes (nome,movimentos) values('edu',123);

delete from recordes where recordes.id = all( select id from recordes where nome='edu');
select  id,nome,movimentos from recordes where nome='edu' order by movimentos asc;
delete from recordes where id = any(select id from recordes where id = 'edu');