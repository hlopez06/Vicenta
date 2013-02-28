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
					
					var div = '<ul><ul class="formProducto"><li>Id Producto</li>' + '<li>Cantidad </li></ul>';
					
					json_respuesta.objFactura.lProductos.forEach(logArrayElements);
		
					div += '<ul class="formProducto"><li>Total bruto: '+ json_respuesta.objFactura.totalBruto +'</li>' +
							'<li>Total: '+ json_respuesta.objFactura.totalMasIva +'</li></ul> </ul>';
					
					$("#listaProductos").empty();
					$("#listaProductos").append(div);
					
					function logArrayElements(element, index, array) {
						
						div += 	'<ul class="formProducto">' +
									'<li>'+ element.idProducto 	+ '</li>' +
									'<li>'+ element.cantidad 	+ '</li>' + 
								'</ul>';
					}
				},	
				error: function(){
					alert("Error al iniciar cargar productos. La tranferencia salio MAL.");
				}	
			}); //Fin de ajax
		}
};