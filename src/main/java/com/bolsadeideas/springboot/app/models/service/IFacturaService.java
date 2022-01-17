package com.bolsadeideas.springboot.app.models.service;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;

import java.util.List;

public interface IFacturaService {

    List<ItemFactura> findAllItemsByBill(Factura bill);


}
