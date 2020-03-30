package lp2.taller_mecanico.dao;

import lp2.taller_mecanico.model.Vehiculo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehiculoRepository extends CrudRepository<Vehiculo,Integer> {

    @Override
    public List<Vehiculo> findAll();

    public Vehiculo findByIdVehiculo(Integer id);

}
