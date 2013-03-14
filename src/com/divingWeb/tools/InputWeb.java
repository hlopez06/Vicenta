package com.divingWeb.tools;

public class InputWeb {
	
	private static String SIZE = "20";
	public static String getSIZE() {
		return SIZE;
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getSize() {
		return size;
	}

	public String getValue() {
		return value;
	}

	public String getClassName() {
		return className;
	}

	private String id;
	private String titulo;
	private String name;
	private String type;
	private String title;
	private String size;
	private String value;
	private String className;
	
	public InputWeb(String titulo ,String name, String elemento){
		this.className = "formElem";
		this.type = "text";
		this.value = "";
		this.size = SIZE;
		this.titulo = titulo;
		this.name = elemento + "-" + name;
		this.id = this.name;
	}
}
