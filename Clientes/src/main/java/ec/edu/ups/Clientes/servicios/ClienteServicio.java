package ec.edu.ups.Clientes.servicios;

import ec.edu.ups.Clientes.entidades.Cliente;
import ec.edu.ups.Clientes.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> findAll(){
        return (List<Cliente>) clienteRepositorio.findAll();
    }

    public Cliente obtenerClienteByCedula (String cedula){
        return(Cliente)clienteRepositorio.findByCedula(cedula);
    }

    public void save (Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    public void delete(long codigo){
        clienteRepositorio.deleteById(codigo);
    }
}
