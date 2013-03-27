function listPage(pts){
		var meta = {
			totalProdStock : null,
			actualPage : null,
			lastPage : null,
			backPage : null,
			nextPage : null
		};
		
		this.pts = {
			name : "List",
 			lineMax : "lineMax",
			divTitulo : '<table>'+'<tr>'+'<th>Codigo </th>'+'<th>Precio</th>'+'<th>Cantidad</th>'+'</tr>',
			divContent : function (element, index ) {
				return '<tr>' + 
				'<td class="prStock">' + '<input value="' + element.codProducto + '" /></td>' +
				'<td class="prStock">' + '<input value="' + element.precio + '" /></td>' +
				'<td class="prStock">' + '<input value="' + element.cantidad + '" /></td>' +
			'</tr>';
			},
			bodyList : "bodyList",
			divPie : "",
		};
		
		if (pts)
			this.pts = pts;
		
		this.lista = null;
		
		this.newList = function (unaLista) {
			meta.totalProdStock = unaLista.length;
			this.lista = unaLista;
		};
		
		this.loadPage = function (actualPage){
			if (meta.totalProdStock > 0){
				var lineMax = getID(this.pts.lineMax).getAttribute("value");
	
				var totalProdStock = meta.totalProdStock;
				meta.actualPage = actualPage;
				
				meta.lastPage = parseInt(totalProdStock / lineMax);
				if ((totalProdStock % lineMax) > 0 )
					++meta.lastPage;
				var lastPage = meta.lastPage;
				
				var divList = this.pts.divTitulo;
						
				var max = lineMax * actualPage;
				var i = max - lineMax;
				var element = null;
				
				if (actualPage == lastPage)
					max = totalProdStock;
				
				while(i < max){
					element = this.lista[i];
				
					divList += 	this.pts.divContent(element,i);
					
					++i;
				};
				
				divList += 	'</table>' + '<div id="pieListaProductos" ><div id="hojaDisplay"></div></div>';
				
				divList += this.pts.divPie;
				
				getID(this.pts.bodyList).innerHTML = divList;
				
				if (lastPage > 1){
					var botonBack = "", botonNext = "";
					if (actualPage != 1)
						botonBack = '<a onclick="'+this.pts.name+'.loadPage(' + (actualPage - 1) + ')">'+
							'<img src="../images/go-lt-off.gif" alt="Pagina anterior"/></a>';
					if (actualPage != lastPage)
						botonNext = '<a onclick="'+this.pts.name+'.loadPage(' + (actualPage + 1) + ')">'+
						'<img src="../images/go-rt-off.gif" alt="Pagina anterior"/></a>';
					
					name = 'Hoja ';
					desdeHasta = '<a>' + actualPage + '</a>/<a>'+ lastPage +'</a>';
					
					getID("hojaDisplay").innerHTML = name + botonBack + desdeHasta + botonNext ;
				};
			}else{
				getID(this.pts.bodyList).innerHTML = '<div id="sinStock">No hay productos en stock.</div>';
			};
		};
};

List = {
		init : function(){
			Menu.init();
			
			var pts = {
					name : "List",
		 			lineMax : "lineMax",
					divTitulo : '<table>'+'<tr>'+'<th>Codigo </th>'+'<th>Precio</th>'+'<th>Cantidad</th>'+'</tr>',
					divContent : function (element, index ) {
						return '<tr>' + 
						'<td class="prStock">' + '<input value="' + element.codProducto + '" /></td>' +
						'<td class="prStock">' + '<input value="' + element.precio + '" /></td>' +
						'<td class="prStock">' + '<input value="' + element.cantidad + '" /></td>' +
					'</tr>';
					},
					bodyList : "bodyList"
				};
				LL = new listPage(pts);
				
				List.callStock();
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

							LL.newList(jsResp.list);
							LL.loadPage(1);
							
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
					url: "facturador/action",
					data: "idCliente=" + idCliente,
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
				alert("Debe agregar un cliente.");
			}
		}
};

Remito = {
		action : function(){

			var tipo = getID("rm-tipoMovimiento");
			
			if (tipo == null){
				alert("Error al setear tipo de remito.");
				return; 
			}
				
			var persona = null; 
			if (document.getElementsByName("pr-id") && tipo == "ingreso"){
				persona = document.getElementsByName("pr-id").item(0).value;
			} else if (document.getElementsByName("cl-id") && tipo == "egreso"){
				persona = document.getElementsByName("cl-id").item(0).value;
			}
			
			if (persona != null && persona != ""){

				$.ajax({
					url: "document/remito/action",
					data: "tipoMovimiento=" + tipo + "&persona=" + persona,
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
				alert("Debe ingresar un remitente.");
			}
		}
};

ElementFactory = {
		productoAction : function() {
			var elemento = document.getElementsByName("elemento").item(0).value;
			if(elemento == "producto"){
				var codigo = document.getElementsByName("pr-codigo").item(0).value;
				var nombre = document.getElementsByName("pr-nombre").item(0).value;
				var detalle = document.getElementsByName("pr-detalle").item(0).value;
				var categoria = document.getElementsByName("pr-categoria").item(0).value;
				var precio = document.getElementsByName("pr-precio").item(0).value;
				
				var url = "newElement/newProduct";
				var datos = "elemento=" + elemento + "&codigo=" + codigo + "&nombre=" + nombre + "&detalle=" + detalle +
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

		terminoBuscar : "Buscar productos...",
		
		listaDeProductos : null,
		
		init : function(){
			Menu.init();
			
			var pts = {
				name : "LP",
				lineMax : "lineMax",
				divTitulo : "<table>",
				bodyList : "listProductsSearched",
				divContent : function (element, index){
					return 	'<tr class="listProductsSearched">' + 
								'<td><a name=' + element.codigo + ' onclick="Product.addProduct('+ element.codigo +')" href="#">'
								+ element.codigo + '. ' + element.nombre + 
								'</a></td>' +
							'</tr>';
				},
				divPie : "<div id='bt-limpiar'><a class='bt' onclick='Product.limpiarHojas()'>Limpiar</a></div>"
			
			};
			LP = new listPage(pts);
		},
		
		limpiarHojas : function (){
			getID("listProductsSearched").innerHTML = "";
			getID("searchProdTermino").value = "";
			getID("inputCodProducto").focus();
			Menu.resize();
		},
		
		obtenerProducto : function(numeroDeIndex){
			var producto = Product.listaDeProductos[numeroDeIndex];
			if(producto != undefined)
				return Product.listaDeProductos[numeroDeIndex];
		},
			
		searchProducts : function(){
			var termino = $("#searchProdTermino").val();
			if (termino == Product.terminoBuscar)
				termino = "";
			
			var nombre = $("#searchProdNombre").val();
			var detalle = $("#searchProdDetalle").val();
			var categoria = $("#searchProdCategoria").val();

			var fuente;
			if ($("#fuente").val()){
				fuente = $("#SearchProductFuente").val();
			} else {				
				fuente = "";
			}
			
			var data = "termino=" + termino + "&nombre=" + nombre + "&detalle=" + detalle +
						"&categoria=" + categoria  + "&codigo=&deposito=&fuente=" + fuente;
			
			$.ajax({
				url: "products/searchProducts",
				data: data,
				type: "GET",
				typedata: "json",
				async: false,
				beforeSend : function () {
					$("#lupaSearchProduct").hide();	
					$("#searchingProducts").show();
					},
				success: function(jsResp){
					if (jsResp.estado == "ok"){
						
						Product.listaDeProductos = jsResp.objList;
						var div;
						
						if (jsResp.objList.length > 0)
						{
							if(termino == "")
								termino = "<strong>TODO</strong>";
								
							div = '<ul class="lista" style="margin: 3px 10px;">' +
									'<li>Resultado de la busqueda </li> <table>';
							
							LP.newList(jsResp.objList);
							LP.pts.divTitulo = div;
							LP.loadPage(1);
							
						}else{
							div = '<a style="margin: 2px 22px;" >No hay resultados para <i>"' + termino + '"</i><a>';
							$("#listProductsSearched").empty;
							$("#listProductsSearched").add(div);
						}
						$("#listProductsSearched").show();
	
					} else {
						alert("Error en la respuesta. " + jsResp.msj);
					}					
				},
				complete : function () {
					$("#lupaSearchProduct").show();
					$("#searchingProducts").hide();
					},
				error: function(){
					alert("Error al iniciar buscar productos. La tranferencia salio MAL.");
				}	
			}); //Fin de ajax
			
			$("#lupaSearchProduct").show();
			$("#searchingProducts").hide();
			Menu.resize();
		},
		
		addProduct : function(codigo){
			var codProducto;
			var cantidad;
			
			if (codigo){
				codProducto = codigo;
				cantidad = 1;
			}else{
				codProducto = $("#inputCodProducto").val();
									$("#inputCodProducto").val("");
				cantidad = $("#cantidad").val();
								$("#cantidad").val("1");
				
			}
				if(codProducto == "" || cantidad == "" || codProducto <= 0 || cantidad <= 0){
					return;
				}else {
					Product.ajaxProducto("codProducto="+codProducto+"&cantidad="+cantidad);
				}
		},
		
		extractProduct : function(codProducto, cantidad){
			if (cantidad != "" || cantidad > 0)
				cantidad = (cantidad * -1);
				
			if(codProducto == "" || codProducto <= 0){
				return;
			}else {
				Product.ajaxProducto("codProducto="+codProducto+"&cantidad="+cantidad);
			}
		},
		eliminar : function (codProducto){
			if(codProducto == "" || codProducto <= 0 ){
				return;
			}else {
				Product.ajaxProducto("codProducto="+codProducto+"&cantidad=0");
			}
		},
		ajaxProducto : function(data){
			
			$.ajax({
				url: "documento/addProduct",
				data: data,
				type: "POST",
				typedata: "json",
				async: false,
				success: function(jsResp){
				if(jsResp.estado == "ok"){  

					var div;
					if (jsResp.objDocumento.lProductos.length > 0){
					div = '<table><tr class="formProducto">' + 
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
						'<td>'+ 
							'<a href="javascript:Product.extractProduct('+ element.codigo +',1);">' + 
							' <img title="Restar uno" src="../images/bt-extractProduct.png"></a>' +
							'<a href="javascript:Product.eliminar('+ element.codigo +');">' + 
							' <img title="Eliminar" src="../images/bt-deleteProduct.png"></a>' +
						'</td>' +
						'</tr>';
						
						cantProductos++;
					});
					
					div += '</table>';
					
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
					} else {
						div = '<div id="sinProductos">Ingrese algun producto...</div>';
					}

					$("#listaProductos").empty();
					$("#listaProductos").append(div);
					getID("pie").style["display"] = "none";
					
				}else{
					alert(jsResp.msj);
				}
	
				},	
				error: function(){
					alert("Error al cargar productos. La tranferencia salio MAL.");
					$("#inputCodProducto").val(codProducto);
					$("#cantidad").val(cantidad);
				}
			}); //Fin de ajax
			
			$("#inputCodProducto").focus();
			Menu.resize();
		},
		clearProductos : function (){
			getID("pie").style["display"] = "block";
			$("#listaProductos").empty();
			$("#totalFactura").empty();
			$("#totalRemito").empty();
			$("#frBtnAction").hide();
		}
};

Client = {
		terminoBuscar : "Buscar cliente...",
		
		listaDeClientes : null,
		
		obtenerCliente : function(numeroDeIndex){
			var cliente = Client.listaDeClientes.objListaClientes[numeroDeIndex];
			if(cliente != undefined)
				return Client.listaDeClientes.objListaClientes[numeroDeIndex];
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
			var menuLargo = getID("ui-layout-north").offsetHeight;
			var docContent = getID("docContent").offsetHeight;
			var menuPie = 0;
			if(getID("pie"))
				menuPie = getID("pie").offsetHeight;
			
			var outerCenter = windowLargo;
			if (docContent > (windowLargo - menuLargo)){
				outerCenter = docContent + menuPie + 20; //20px por margenes
			}else {
				outerCenter = windowLargo - menuLargo - 1;
			}
			if(getID("panel-izquierdo"))	
				getID("panel-izquierdo").style.height =  (outerCenter) + "px";
			
			getID("mainContent").style.height =  (outerCenter) + "px";
		},
		
		display : function (nameElem){
			var element = getID(nameElem);
			if(element){
				if (element.style["display"] == "none"){
					element.style["display"] = "block";
				} else {
					element.style["display"] = "none";
				}	
			}
		},
		
		adapatarAncho : function (){
			var windowAncho = window.innerWidth;
			var menuAncho = 0;
			if(getID("panel-izquierdo")){
				menuAncho = getID("panel-izquierdo").offsetWidth;
				getID("mainContent").style.left = menuAncho + "px";
			}	
			
			getID("outer-center").style.width =  (windowAncho - menuAncho - 1) + "px";
			
			if (getID("pie"))
				getID("pie").style.width =  (windowAncho - menuAncho - 5 - 1) + "px";
		},
		
		keyEnter : function(e, elemento, funcion) {
			tecla=(document.all) ? e.keyCode : e.which; 
			if(tecla == 13)	funcion();
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
function getID(idName) {
	if (document.getElementById(idName))
		return document.getElementById(idName);
	
	return null;
};