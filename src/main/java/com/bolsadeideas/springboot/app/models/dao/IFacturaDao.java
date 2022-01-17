package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

    @Query("select f.items  from Factura f where f.id = ?1")
    List<ItemFactura> findItemsByFacturaId(Long id);

}
