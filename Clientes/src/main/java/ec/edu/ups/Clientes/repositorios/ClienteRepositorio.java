package ec.edu.ups.Clientes.repositorios;

import ec.edu.ups.Clientes.entidades.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente,Long> {
    @Query("select c from Cliente  c where c.cedula=:cedula")
    Cliente findByCedula(String cedula);
}
