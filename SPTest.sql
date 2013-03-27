DROP PROCEDURE IF EXISTS sp_login;

delimiter /
CREATE PROCEDURE sp_login (IN INusuario CHAR(20),IN INpassword CHAR(20),OUT OUTid int,OUT OUTestado int,OUT OUTmsj CHAR(100))
BEGIN

	SELECT id,estado INTO OUTid,OUTestado FROM pws WHERE pws.usuario=INusuario AND pws.password=INpassword;
	IF OUTid THEN
		SET OUTmsj = 'Todo ok';
	ELSE
		SET OUTid = 0;
		SET OUTmsj = 'Usuario o contraseña invalido.';
	END if;

END;
/

SHOW PROCEDURE STATUS;


call sp_login ('hernan','hernan',@idUsuario,@estado,@msj)/

select @idUsuario,@estado,@msj/