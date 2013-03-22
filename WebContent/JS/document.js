List = {
		meta : {
			totalProdStock : null,
			actualPage : null,
			lastPage : null,
			backPage : null,
			nextPage : null
		},
		
		lista : null,
		
		loadPage : function(actualPage){
			var lineMax = document.getElementById("lineMax").getAttribute("value");

			var totalProdStock = List.meta.totalProdStock;
			List.meta.actualPage = actualPage;
			
			List.meta.lastPage = parseInt(totalProdStock / lineMax);
			if ((totalProdStock % lineMax) > 0 )
				++List.meta.lastPage;
			var lastPage = List.meta.lastPage;
			
			var divList = '<table>'+
							'<tr>'+
								'<th>Codigo </th>'+'<th>Precio</th>'+'<th>Cantidad</th>'+
							'</tr>';
					
			var max = lineMax * actualPage;
			var i = max - lineMax;
			var element = null;
			
			if (actualPage == lastPage)
				max = totalProdStock;
			
			while(i < max){
				element = List.lista[i];
			
				divList += 	'<tr>' + 
					'<td class="prStock">' + '<input value="' + element.codProducto + '" /></td>' +
					'<td class="prStock">' + '<input value="' + element.precio + '" /></td>' +
					'<td class="prStock">' + '<input value="' + element.cantidad + '" /></td>' +
				'</tr>';
				
				++i;
			};
			
			divList += 	'</table>' + '<dir id="hoja"><div id="hojaDisplay"></div></div>';
			
			document.getElementById("bodyList").innerHTML = divList;
			
			var botonBack = "", botonNext = "";
			if (actualPage != 1)
				botonBack = '<a onclick="List.loadPage(' + (actualPage - 1) + ')">'+
					'<img src="../images/go-lt-off.gif" alt="Pagina anterior"/></a>';
			if (actualPage != lastPage)
				botonNext = '<a onclick="List.loadPage(' + (actualPage + 1) + ')">'+
				'<img src="../images/go-rt-off.gif" alt="Pagina anterior"/></a>';
			name = 'Hoja ';
			desdeHasta = '<a>' + actualPage + '</a>/<a>'+ lastPage +'</a>';
			
			document.getElementById("hojaDisplay").innerHTML = name + botonBack + desdeHasta + botonNext ;

		},

		callStock : function(){

				$.ajax({
					url: "product/selectStock",
					data: "pagina=0",
					type: "GET",
					typedata: "json",
					async: false,
					beforeSend : function () {	},
					success: function(jsResp){
						if (jsResp.estado == "ok"){

							List.lista = jsResp.list;
							List.meta.totalProdStock = List.lista.length;
			
							List.loadPage(1);
							
						}else{
							alert(jsResp.msj);
						}
					},
					complete : function () {	},
					error: function(){
						alert("Error al iniciar facturacion. La tranferencia salio MAL.");
					}
				}); // Fin de ajax
			
		}
};

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
			var inTipo = Menu.radioSelect("rm-tipoMovimiento");
			var tipo = "ingreso";
			
			if (inTipo != null)
				tipo = inTipo.value;
			
			if ( tipo == "ingreso" || tipo == "egreso" ){
				$.ajax({
					url: "document/remito/action",
					data: "tipoMovimiento=" + tipo,
					type: "POST",
					typedata: "json",
					async: false,
					beforeSend : function () {	},
					success: function(jsResp){
							
					},
					complete : function () {
						Product.clearProductos();
					},
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
		productoAction : function() {
			var elemento = document.getElementsByName("elemento").item(0).value;
			if(elemento == "producto"){
				var nombre = document.getElementsByName("pr-nombre").item(0).value;
				var detalle = document.getElementsByName("pr-detalle").item(0).value;
				var categoria = document.getElementsByName("pr-categoria").item(0).value;
				var precio = document.getElementsByName("pr-precio").item(0).value;
				
				var url = "newElement/newProduct";
				var datos = "elemento=" + elemento + "&nombre=" + nombre + "&detalle=" + detalle +
																		"&categoria=" + categoria + "&precio=" + precio;
				
				var respuesta = ElementFactory.ajaxNewElement(url,datos);
				if (respuesta == "ok"){
					alert("Comunicacion exitosa. Los datos se actualizaron correctamente. " + datos);
				}else {
					alert("Comunicacion exitosa. Los datos se NO se actualizaron.  " + datos);
				}
			}
		},
		clienteAction : function() {
			var elemento = document.getElementsByName("elemento").item(0).value;
			if(elemento == "cliente"){
				var nombre = document.getElementsByName("cl-nombre").item(0).value;
				var apellido = document.getElementsByName("cl-apellido").item(0).value;
				var razonSocial = document.getElementsByName("cl-razonSocial").item(0).value;
				var direccion = document.getElementsByName("cl-direccion").item(0).value;
				var tipo = document.getElementsByName("cl-tipo").item(0).value;
				var credito = document.getElementsByName("cl-credito").item(0).value;
				
				var url = "newElement/newClient";
				var datos = "elemento=" + elemento + "&nombre=" + nombre + "&apellido=" + apellido +
								"&razonSocial=" + razonSocial + "&tipo=" + tipo + "&credito=" + credito + "&direccion=" + direccion;
				
				var respuesta = ElementFactory.ajaxNewElement(url,datos);
				if (respuesta == "ok"){
					alert("Comunicacion exitosa. Los datos se actualizaron correctamente. " + datos);
				}else {
					alert("Comunicacion exitosa. Los datos se NO se actualizaron.  " + datos);
				};
			};
		},
		proveedorAction : function() {
			var elemento = document.getElementsByName("elemento").item(0).value;
			if(elemento == "proveedor"){
				var nombre = document.getElementsByName("pv-nombre").item(0).value;
				var razonSocial = document.getElementsByName("pv-razonSocial").item(0).value;
				var direccion = document.getElementsByName("pv-direccion").item(0).value;
				var tipo = document.getElementsByName("pv-tipo").item(0).value;
				
				var url = "newElement/newProvider";
				var datos = "elemento=" + elemento + "&nombre=" + nombre + "&razonSocial=" + razonSocial +
								"&tipo=" + tipo + "&direccion=" + direccion;
				
				var respuesta = ElementFactory.ajaxNewElement(url,datos);
				if (respuesta == "ok"){
					alert("Comunicacion exitosa. Los datos se actualizaron correctamente. " + datos);
				}else {
					alert("Comunicacion exitosa. Los datos se NO se actualizaron.  " + datos);
				};
			};
		},
		
		usuarioAction : function() {},
		
		ajaxNewElement : function(url, datos) {
			var respuesta = "error";
			$.ajax({
				url: url,
				data: datos,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {	},
				success: function(resp){
						if (resp.objNewElement.estado == "ok"){
							respuesta = resp.objNewElement.estado;
						}else{
							respuesta = resp.objNewElement.msj;
						}
				},
				complete : function () {	},
				error: function(){
					alert("Error al iniciar chequeo de elemento. La tranferencia salio MAL.");
				}
			}); // Fin de ajax
			
			return respuesta;
		},
		
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
			var codProducto = $("#inputIdProducto").val();
								$("#inputIdProducto").val("");
			var cantidad = $("#cantidad").val();
							$("#cantidad").val("1");
			
			if(codProducto == "" || cantidad == "" || codProducto <= 0 || cantidad <= 0){
				return;
				}
								
			$.ajax({
				url: "documento/addProduct",
				data: "codProducto="+codProducto+"&cantidad="+cantidad,
				type: "POST",
				typedata: "json",
				async: false,
				success: function(jsResp){
				
				if(jsResp.estado == "ok"){	
					var div = '<table><tr class="formProducto">' + 
					'<td>Codigo</td>' 	+ 
					'<td>Nombre </td>' 		+
					'<td>Detalles </td>' 	+
					'<td>Precio </td>' 		+
					'<td>Cantidad </li>' 	+
					'</tr>';
					var cantProductos = 0;
					
					jsResp.objDocumento.lProductos.forEach(function (element, index, array) {						
						div += 	'<tr class="formProducto">' +
						'<td>'+ element.codigo 		+ '</td>' +
						'<td>'+ element.nombre 		+ '</td>' +
						'<td>'+ element.detalle		+ '</td>' +
						'<td>'+ element.precio 		+ '</td>' +
						'<td>'+ element.cantidad	+ '</td>' + 
						'</tr>';
						
						cantProductos++;
					});
					
					div += '</table>';
					
					$("#listaProductos").empty();
					$("#listaProductos").append(div);

					var divTotal = '<ul class="formTotal">' +
						'<li><strong>Total: '+ jsResp.objDocumento.totalMasIva +'</strong></li>' +
						'<li>Total bruto: '+ jsResp.objDocumento.totalBruto +'</li> </ul>';
										
					$("#totalFactura").empty();
					$("#totalFactura").append(divTotal);
					
					var divCantidad = '<ul class="formTotal">' +
						'<li><strong>Total: '+ jsResp.objDocumento.cantTotalProductos +'</strong></li>' +
						'<li>Total de elementos: '+ jsResp.objDocumento.cantElemProductos +'</li> </ul>';
										
					$("#totalRemito").empty();
					$("#totalRemito").append(divCantidad);
					
					$("#frBtnAction").show();
					
				}else{
					alert(jsResp.msjError);
				}
	
				},	
				error: function(){
					alert("Error al cargar productos. La tranferencia salio MAL.");
					$("#inputIdProducto").val(codProducto);
					$("#cantidad").val(cantidad);
				},
			}); //Fin de ajax
			
			$("#inputIdProducto").focus();
		},
		clearProductos : function (){
			$("#listaProductos").empty();
			$("#totalFactura").empty();
			$("#frBtnAction").hide();
		}
};

Client = {
		terminoBuscar : "Buscar cliente...",
		
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
			var termino = $("#searchClients").val();
			if (termino == Client.terminoBuscar)
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
			
			$("#listClientsSearched").hide();
			$("#listClientsSearched").empty();
			$("#searchClients").val(Client.terminoBuscar);
			
		}
};

Provider = {
		terminoBuscar : "Buscar proveedor...",
		
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
			if (termino == Provider.terminoBuscar)
				termino = "";

			$.ajax({
				url: "providers/searchProviders",
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
				url: "documento/addProvider",
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
			
			$("#listProvidersSearched").hide();
			$("#listProvidersSearched").empty();
			$("#searchProviders").val(Provider.terminoBuscar);
		}
};

Menu = {
		init : function (){
			window.onresize = Menu.resize;
			Menu.resize();
		},
		
		resize : function (){			
			Menu.adapatarLargo();
			Menu.adapatarAncho();
		},
		
		adapatarLargo : function (){
			var windowLargo = window.innerHeight;
			var menuLargo = document.getElementById("ui-layout-north").offsetHeight;
			document.getElementById("panel-izquierdo").style.height =  (windowLargo - menuLargo - 1) + "px";
		},
		adapatarAncho : function (){
			var windowAncho = window.innerWidth;
			var menuAncho = document.getElementById("ui-layout-north").offsetHeight;
			document.getElementById("outer-center").style.width =  (windowAncho - menuAncho - 1) + "px";
		},
		
		radioSelect : function (name){
			var tm = document.getElementsByName(name);
			
			for (var i=0; i < tm.length; i++)
			{ 
				if (tm.item(i).checked){
					return tm.item(i);
				};
			}
			return null;
		},
		desplegableAbre : function(e,ob){
			ob.getElementsByTagName("ul").item(0).style["display"] = "block";
			ob.getElementsByTagName("a").item(0).className = "abreDesplegableAbierto menuDesplegable";
			ob.onclick = function (event) { Menu.desplegableCierra(event,this); };
			ob.onblur = function(event) { Menu.desplegableCierra(event,this);
			alert("chau");};	
		},
		desplegableCierra : function (e,ob){
			ob.getElementsByTagName("ul").item(0).style["display"] = "none";
			ob.getElementsByTagName("a").item(0).className = "abreDesplegable";
			ob.onclick = function (event) {Menu.desplegableAbre(event,this);};
		}
};