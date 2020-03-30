package lp2.taller_mecanico.dao;

import lp2.taller_mecanico.model.Registro;
import lp2.taller_mecanico.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistroRepository extends CrudRepository<Registro,Integer> {

    @Override
    public List<Registro> findAll();

  // public Registro findByPatenteAndCodigo(String patente, String codigo);
    public Registro findByCodigo(String codigo);
}