package com.example.constant;

public abstract class SqlQueryConstant {
	public static final String FIND_SUPLIER_BY_VALUE = "SELECT * FROM " + TableDataConstant.SUPPLIER_TABLE_NAME
			+ " p WHERE CONCAT(p.id, p.nombre, p.correo, p.direccion) LIKE %?1%";
	
	public static final String FIND_PRODUCT_BY_VALUE = "SELECT * FROM " + TableDataConstant.PRODUCT_TABLE_NAME
			+ " AS p WHERE CONCAT(p.id, p.nombre, p.tipo, p.marca, p.precio_unidad, p.cantidad) LIKE %?1%";
	
	public static final String FIND_BY_NAME = "SELECT * FROM " + TableDataConstant.SUPPLIER_TABLE_NAME
			+ " WHERE(nombre = ?) LIMIT 1";
}
