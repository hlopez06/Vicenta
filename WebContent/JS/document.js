Factura = {
		action : function(){
			
			if (document.getElementsByName("cl-id").item(0).value != ""){
				var idCliente = document.getElementsByName("cl-id").item(0).value;
				
				$.ajax({
					url: "facturador/facturar",
					data: "idCliente=" + idCliente,
					type: "GET",
					typedata: "json",
					async: false,
					beforeSend : function () {	},
					success: function(jsResp){
							
					},
					complete : function () {	},
					error: function(){
						alert("Error al iniciar facturacion. La tranferencia salio MAL.");
					}
				}); // Fin de ajax
			} else {
				alert("Debe agregar un cliente.");
			}
		}
};

Remito = {
		action : function(){
			
			var tipo = document.getElementsByName("rm-tipo").item(0).value;
			
			if (tipo != "" && ( tipo == "ingreso" || tipo == "egreso" )){
				
				$.ajax({
					url: "document/remito/action",
					data: "tipoMovimiento=" + tipo,
					type: "POST",
					typedata: "json",
					async: false,
					beforeSend : function () {	},
					success: function(jsResp){
							
					},
					complete : function () {	},
					error: function(){
						alert("Error al iniciar facturacion. La tranferencia salio MAL.");
					}
				}); // Fin de ajax
			} else {
				alert("Error en el tipo de movimiento.");
			}
		}
};

ElementFactory = {
		productoAction : function() {},
		clienteAction : function() {},
		proveedorAction : function() {},
		usuarioAction : function() {},
		ajaxCheckElement : function (url, datos){
			
			$.ajax({
				url: url,
				data: datos,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {	},
				success: function(resp){
						if (resp.objRespuesta.estado == "free")
						{
							return true;
						}
						return false;
				},
				complete : function () {	},
				error: function(){
					alert("Error al iniciar chequeo de elemento. La tranferencia salio MAL.");
				}
			}); // Fin de ajax
		}
};


Product = {		
		addProduct : function(){
			var idProducto = $("#inputIdProducto").val();
								$("#inputIdProducto").val("");
			var cantidad = $("#cantidad").val();
							$("#cantidad").val("1");
			
			if(idProducto == "" || cantidad == "" || idProducto <= 0 || cantidad <= 0){
				return;
				}
								
			$.ajax({
				url: "documento/addProduct",
				data: "idProducto="+idProducto+"&cantidad="+cantidad,
				type: "POST",
				typedata: "json",
				async: false,
				success: function(jsResp){
				
				if(jsResp.estado == "ok"){	
					var div = '<table><tr class="formProducto">' + 
					'<td>Id Producto</td>' 	+ 
					'<td>Nombre </td>' 		+
					'<td>Detalles </td>' 	+
					'<td>Precio </td>' 		+
					'<td>Cantidad </li>' 	+
					'</tr>';
					
					jsResp.objDocumento.lProductos.forEach(function (element, index, array) {						
						div += 	'<tr class="formProducto">' +
						'<td>'+ element.id 		+ '</td>' +
						'<td>'+ element.nombre 		+ '</td>' +
						'<td>'+ element.detalle		+ '</td>' +
						'<td>'+ element.precio 		+ '</td>' +
						'<td>'+ element.cantidad	+ '</td>' + 
						'</tr>';
					});
					
					div += '</table>';
					
					$("#listaProductos").empty();
					$("#listaProductos").append(div);

					var divTotal = '<ul class="formTotal">' +
						'<li><strong>Total: '+ jsResp.objDocumento.totalMasIva +'</strong></li>' +
						'<li>Total bruto: '+ jsResp.objDocumento.totalBruto +'</li> </ul>';
					
					$("#totalFactura").empty();
					$("#totalFactura").append(divTotal);
					
				}else{
					alert(jsResp.msjError);
				}
	
				},	
				error: function(){
					alert("Error al cargar productos. La tranferencia salio MAL.");
					$("#inputIdProducto").val(idProducto);
					$("#cantidad").val(cantidad);
				}	
			}); //Fin de ajax
			
			$("#inputIdProducto").focus();
		}
};

Client = {
		
		listaDeClientes : null,
		
		abrirFormCrearCliente : function (){
			
		},
		
		crearCliente : function(){
			
		},
		
		obtenerCliente : function(numeroDeIndex){
			var cliente = Client.listaDeClientes.objListaClientes[numeroDeIndex];
			if(cliente != undefined)
				return Client.listaDeClientes.objListaClientes[numeroDeIndex];
		},
		
		searchClientsKeyEnter : function(e, elemento) {
				tecla=(document.all) ? e.keyCode : e.which; 
				if(tecla == 13) Client.searchClients();
		},
			
		searchClients : function(){
			var termino = $("#searchClientes").val();
			if (termino == "Buscar cliente...")
				termino = "";

			$.ajax({
				url: "client/searchClients",
				data: "termino=" + termino,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {
					$("#lupaSearchCliente").hide();	
					$("#searchingClients").show();
					},
				success: function(jsResp){
					Client.listaDeClientes = jsResp;
					var div;
					
					if (jsResp.objListaClientes.length > 0)
					{
						if(termino == "")
							termino = "<strong>TODO</strong>";
							
						div = '<ul class="lista" style="margin: 3px 10px;">' +
								'<li>Resultado de la busqueda <i>' + termino + '</i></li>';
						
						jsResp.objListaClientes.forEach(function (element, index, array) {
							div += '<li><a name=' + index + ' onclick="Client.agregarCliente('+index+')" href="#">'
							+ element.apellido + ', ' + element.nombre + 
							'</a></li>';
						});
						
						div += '</ul>';
						
					}else{
						div = '<a style="margin: 2px 22px;" >No hay resultados para <i>"' + termino + '"</i><a>';
					}

					$("#listClientsSearched").empty();
					$("#listClientsSearched").append(div);
					$("#listClientsSearched").show();
					
				},
				complete : function () {
					$("#lupaSearchCliente").show();
					$("#searchingClients").hide();
					},
				error: function(){
					alert("Error al iniciar buscar clientes. La tranferencia salio MAL.");
				}	
			}); //Fin de ajax
		},
		
		agregarCliente : function(numeroDeIndex){
			var cliente = Client.obtenerCliente(numeroDeIndex);
			
			document.getElementsByName("cl-id").item(0).value = cliente.id;
			document.getElementsByName("cl-nombre").item(0).value = cliente.nombre;
			document.getElementsByName("cl-apellido").item(0).value = cliente.apellido;
			document.getElementsByName("cl-tipo").item(0).value = cliente.tipo;
			document.getElementsByName("cl-razonSocial").item(0).value = cliente.razonSocial;
			document.getElementsByName("cl-credito").item(0).value = cliente.credito;
			
			$.ajax({
				url: "documento/addClient",
				data: "idCliente=" + cliente.id,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {	},
				success: function(jsResp){
		
				},
				complete : function () {	},
				error: function(){
					alert("Error al iniciar cargar cliente. La tranferencia salio MAL.");
				}
			});
		}
};

Provider = {
		
		listaDeProviders : null,
		
		abrirFormCrearProveedor : function (){
			
		},
		
		crearProveedor : function(){
			
		},
		
		obtenerProveedor : function(numeroDeIndex){
			var proveedor = Provider.listaDeProviders.objListaProviders[numeroDeIndex];
			if(proveedor != undefined)
				return Provider.listaDeProviders.objListaProviders[numeroDeIndex];
		},
		
		searchProvidersKeyEnter : function(e, elemento) {
				tecla=(document.all) ? e.keyCode : e.which; 
				if(tecla == 13) Provider.searchProviders();
		},
			
		searchProviders : function(){
			var termino = $("#searchProviders").val();
			if (termino == "Buscar proveedor...")
				termino = "";

			$.ajax({
				url: "provider/SearchProviders",
				data: "termino=" + termino,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {
					$("#lupaSearchProviders").hide();	
					$("#searchingProviders").show();
					},
				success: function(jsResp){
					Provider.listaDeProviders = jsResp;
					var div;
					
					if (jsResp.objListaProviders.length > 0)
					{
						if(termino == "")
							termino = "<strong>TODO</strong>";
							
						div = '<ul class="lista" style="margin: 3px 10px;">' +
								'<li>Resultado de la busqueda <i>' + termino + '</i></li>';
						
						jsResp.objListaProviders.forEach(function (element, index, array) {
							div += '<li><a name=' + index + ' onclick="Provider.agregarProveedor('+index+')" href="#">'
							+ element.razonSocial + 
							'</a></li>';
						});
						
						div += '</ul>';
						
					}else{
						div = '<a style="margin: 2px 22px;" >No hay resultados para <i>"' + termino + '"</i><a>';
					}

					$("#listProvidersSearched").empty();
					$("#listProvidersSearched").append(div);
					$("#listProvidersSearched").show();
					
				},
				complete : function () {
					$("#lupaSearchProviders").show();
					$("#searchingProviders").hide();
					},
				error: function(){
					alert("Error al iniciar buscar proveedores. La tranferencia salio MAL.");
				}	
			}); //Fin de ajax
		},
		
		agregarProveedor : function(numeroDeIndex){
			var proveedor = Provider.obtenerProveedor(numeroDeIndex);
			
			document.getElementsByName("pr-id").item(0).value = proveedor.id;
			document.getElementsByName("pr-nombre").item(0).value = proveedor.nombre;
			document.getElementsByName("pr-direccion").item(0).value = proveedor.direccion;
			document.getElementsByName("pr-tipo").item(0).value = proveedor.tipo;
			document.getElementsByName("pr-razonSocial").item(0).value = proveedor.razonSocial;
			
			$.ajax({
				url: "documento/AddProvider",
				data: "idProveedor=" + proveedor.id,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {	},
				success: function(jsResp){
		
				},
				complete : function () {	},
				error: function(){
					alert("Error al iniciar cargar proveedor. La tranferencia salio MAL.");
				}
			});
		}
};

menu = {
		historialDespAbre : function (){
			document.getElementById("menuDespHisto").style["display"] = "block";
			document.getElementById("HistorialDesplegable").className = "abreDesplegableAbierto menuDesplegable";
			document.getElementById("HistorialDesplegable").onclick = function () {menu.historialDespCierra();};

				},
		historialDespCierra : function (){
				document.getElementById("menuDespHisto").style["display"] = "none";
				document.getElementById("HistorialDesplegable").className = "abreDesplegable";
				document.getElementById("HistorialDesplegable").onclick = function () {menu.historialDespAbre();};
				
				},
		altaDespAbre : function (){
			document.getElementById("menuDespAlta").style["display"] = "block";
			document.getElementById("AltaDesplegable").className = "abreDesplegableAbierto menuDesplegable";
			document.getElementById("AltaDesplegable").onclick = function () {menu.AltaDespCierra();};

				},
		altaDespCierra : function (){
				document.getElementById("menuDespAlta").style["display"] = "none";
				document.getElementById("AltaDesplegable").className = "abreDesplegable";
				document.getElementById("AltaDesplegable").onclick = function () {menu.AltaDespAbre();};
				
				},

};