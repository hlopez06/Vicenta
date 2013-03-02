Factura = {
		addProduct : function(){
			var idProducto = $("#idProducto").val();
			var cantidad = $("#cantidad").val();
			$.ajax({
				url: "facturador/AddProduct",
				data: "idProducto="+idProducto+"&cantidad="+cantidad,
				type: "POST",
				typedata: "json",
				async: false,
				success: function(jsResp){
					
					var div = '<table><tr class="formProducto">' + 
					'<td>Id Producto</td>' 	+ 
					'<td>Nombre </td>' 		+
					'<td>Detalles </td>' 	+
					'<td>Precio </td>' 		+
					'<td>Cantidad </li>' 	+
					'</tr>';
					
					jsResp.objFactura.lProductos.forEach(logArrayElements);
					
					div += '</table>';
					
					$("#listaProductos").empty();
					$("#listaProductos").append(div);

					function logArrayElements(element, index, array) {						
						div += 	'<tr class="formProducto">' +
						'<td>'+ element.guid 		+ '</td>' +
						'<td>'+ element.nombre 		+ '</td>' +
						'<td>'+ element.detalle		+ '</td>' +
						'<td>'+ element.precio 		+ '</td>' +
						'<td>'+ element.cantidad	+ '</td>' + 
						'</tr>';

					var divTotal = '<ul class="formTotal"><li>Total bruto: '+ jsResp.objFactura.totalBruto +'</li>' +
							'<li>Total: '+ jsResp.objFactura.totalMasIva +'</li></ul>';

					$("#totalFactura").empty();
					$("#totalFactura").append(divTotal);
					
					}
				},	
				error: function(){
					alert("Error al iniciar cargar productos. La tranferencia salio MAL.");
				}	
			}); //Fin de ajax
		},
		agregarCliente : function(numeroDeIndex){
			var cliente = Clientes.obtenerCliente(numeroDeIndex);
			
			document.getElementsByName("cl-nombre").item(0).value = cliente.nombre;
			document.getElementsByName("cl-apellido").item(0).value = cliente.apellido;
			document.getElementsByName("cl-tipo").item(0).value = cliente.tipo;
			document.getElementsByName("cl-razonSocial").item(0).value = cliente.razonSocial;
			document.getElementsByName("cl-credito").item(0).value = cliente.credito;
			
//			enviar cliente
		}
};
Clientes = {
		
		listaDeCLientes : null,
		
		abrirFormCrearCliente : function (){
			
		},
		
		crearCliente : function(){
			
		},
		
		obtenerCliente : function(numeroDeIndex){
			var cliente = Clientes.listaDeCLientes.objListaClientes[numeroDeIndex];
			if(cliente != undefined)
				return Clientes.listaDeCLientes.objListaClientes[numeroDeIndex];
		},
		
		searchClientsKeyEnter : function(e, elemento) {
				tecla=(document.all) ? e.keyCode : e.which; 
				if(tecla == 13) Clientes.searchClients();
		},
			
		searchClients : function(){
			var termino = $("#searchClientes").val();
			if (termino == "Buscar cliente...")
				termino = "";

			$.ajax({
				url: "client/SearchClients",
				data: "termino=" + termino,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {
					$("#lupaSearchCliente").hide();	
					$("#listClientsSearched").show();
					},
				success: function(jsResp){
					Clientes.listaDeCLientes = jsResp;
					var div;
					
					if (jsResp.objListaClientes.length > 0)
					{
						if(termino == "")
							termino = "<strong>TODO</strong>";
							
						div = '<ul class="lista" style="margin: 3px 10px;">' +
								'<li>Resultado de la busqueda <i>' + termino + '</i></li>';
						
						jsResp.objListaClientes.forEach(creaListaCliente);
						
						div += '</ul>';
						
					}else{
						div = '<a style="margin: 2px 22px;" >No hay resultados para <i>"' + termino + '"</i><a>';
					}

					$("#listClientsSearched").empty();
					$("#listClientsSearched").append(div);
					$("#listClientsSearched").show();
					
					function creaListaCliente(element, index, array) {
						div += '<li><a name=' + index + ' onclick="Factura.agregarCliente('+index+')" href="#">'
							+ element.apellido + ', ' + element.nombre + 
							'</a></li>';
					}
				},
				complete : function () {
					$("#lupaSearchCliente").show();
					$("#searchingClients").hide();
					},
				error: function(){
					alert("Error al iniciar cargar productos. La tranferencia salio MAL.");
				}	
			}); //Fin de ajax
		}		
};