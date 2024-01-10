package com.example.constant;

public abstract class ConstantPath {
	public static final String IDENTIFIER_PARAM = "{" + TableDataConstant.ID_COLUMN_NAME + "}";
	public static final String DEFAULT_PATH = "/api/";
	public static final String SUPPLIER_PATH = DEFAULT_PATH + TableDataConstant.SUPPLIER_TABLE_NAME;
	public static final String PRODUCT_PATH = DEFAULT_PATH + TableDataConstant.PRODUCT_TABLE_NAME;
	public static final String CREATE = "/create/";
	public static final String UPDATE = "/update/" + IDENTIFIER_PARAM;
	public static final String DELETE = "/delete/" + IDENTIFIER_PARAM;
	public static final String FIND_ALL = "/findAll";
	public static final String FIND_THAT_MATCH = "/findMatch";
}
