DROP PROCEDURE IF EXISTS sp_cargaStock;

delimiter /
CREATE PROCEDURE sp_cargaStock (in idProducto int,in codProducto int,in cantidad int, in precio float(3),out resp int)
BEGIN
 	
SET resp = EXISTS (SELECT * FROM stock AS sp WHERE sp.idProducto=idProducto);
IF resp THEN
	UPDATE stock AS sp SET sp.cantidad=sp.cantidad+cantidad WHERE sp.idProducto=idProducto;
	SET resp = 1;
ELSE
	INSERT INTO stock (idProducto,codProducto,cantidad,precio) VALUES (idProducto,codProducto,cantidad,precio) ;
	SET resp = 2;
END if;

END;
/

SHOW PROCEDURE STATUS;