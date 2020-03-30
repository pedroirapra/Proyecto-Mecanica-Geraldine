package lp2.taller_mecanico.dao;

import lp2.taller_mecanico.model.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {

    @Override
    public List<Cliente> findAll();

    public Cliente findByIdCliente(int intValue);
}
