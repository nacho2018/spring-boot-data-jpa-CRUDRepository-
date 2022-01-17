package com.bolsadeideas.springboot.app.models.service;

import com.bolsadeideas.springboot.app.models.dao.IFacturaDao;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService{

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    public List<ItemFactura> findAllItemsByBill(Factura bill) {
        return facturaDao.findItemsByFacturaId(bill.getId());
    }
}
