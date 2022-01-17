package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

import java.util.List;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

    @Query("select c from Cliente c where c.id = ?1")
     Cliente findOneWithQuery(Long id);

    /*@Query("select c from Cliente c where c.id between ?1 and ?2")
    List<Cliente> findAllByIdRange(Long from, Long to);*/

    List<Cliente> findByIdBetween(Long from, Long to);

   List<Cliente> findByEmailContaining(String domain);
}
