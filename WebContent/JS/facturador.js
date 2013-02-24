facturar = {
		newProduct : function(){
			var idProducto = $("#idProducto").val();
			var cantidad = $("#cantidad").val();
			$.ajax({
				url: "facturador/newProduct",
				data: "idProducto="+idProducto+"&cantidad="+cantidad,
				type: "POST",
				typedata: "json",
				async: false,
				success: function(json_respuesta){
					
					var div = "<ul>";
					
					json_respuesta.objFactura.lProductos.forEach(logArrayElements);
		
					div += "</ul>";
					
					$("#listaProductos").empty();
					$("#listaProductos").append(div);
					
					function logArrayElements(element, index, array) {
						
						div += 	'<ul class="formFactura"><li>id Producto &nbsp; '+ element.idProducto +'</li>' +
						'<li>cantidad &nbsp; '+ element.cantidad +'</li></ul>';
					}
				},	
				error: function(){
					alert("Error al iniciar cargar productos. La tranferencia salio MAL.");
				}	
			}); //Fin de ajax
		}
};