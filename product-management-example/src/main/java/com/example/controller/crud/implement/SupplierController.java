package com.example.controller.crud.implement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.ConstantPath;
import com.example.controller.crud.model.CrudModel;
import com.example.dto.suplier.implement.request.SupplierDTOPost;
import com.example.dto.suplier.implement.request.SupplierDTOUpdate;
import com.example.dto.suplier.implement.response.SupplierDTOGet;
import com.example.entities.implement.SupplierEntity;

@RestController
@RequestMapping(ConstantPath.SUPPLIER_PATH)
public class SupplierController extends CrudModel<SupplierEntity, SupplierDTOPost, SupplierDTOGet, SupplierDTOUpdate> {

}
