package com.example.controller.crud.implement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.ConstantPath;
import com.example.controller.crud.model.CrudModel;
import com.example.dto.product.implement.request.ProductDTOUpdate;
import com.example.dto.product.implement.request.ProductoDTOPost;
import com.example.dto.product.implement.response.ProductDTOGet;
import com.example.entities.implement.ProductEntity;

@RestController
@RequestMapping(ConstantPath.PRODUCT_PATH)
public class ProductController extends CrudModel<ProductEntity, ProductoDTOPost, ProductDTOGet, ProductDTOUpdate> {

}
