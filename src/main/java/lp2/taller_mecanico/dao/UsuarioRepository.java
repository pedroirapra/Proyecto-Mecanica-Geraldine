package lp2.taller_mecanico.dao;

import lp2.taller_mecanico.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {

    @Override
    public List<Usuario> findAll();

    public Usuario findByNombreAndContrasena(String nom, Integer contr);
}
