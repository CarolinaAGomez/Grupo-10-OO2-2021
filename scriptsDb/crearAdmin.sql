use `grupo-10-bdd-oo2-2021`;

INSERT INTO perfil (id_perfil,nombre_rol)  VALUES (1,"ROLE_ADMIN");
INSERT INTO usuario (id_usuario,apellido,created_at,dni,mail,nombre,password,updated_at,username,id_perfil) 
VALUES(1,"",current_date(),0,"","","$2a$10$q7lfJmGkuVwKOPgPGup68eBvoVscD8Z1gGwCfuMWhsnrSZDkGC6Ym",current_date(),"admin",1);

select * from perfil;
select * from usuario;
select id_usuario as id,username,password,p.nombre_rol as rol from usuario u inner join perfil p on u.id_perfil = p.id_perfil;


