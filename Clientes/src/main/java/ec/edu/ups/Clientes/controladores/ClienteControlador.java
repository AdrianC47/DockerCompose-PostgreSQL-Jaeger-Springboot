package ec.edu.ups.Clientes.controladores;
import ec.edu.ups.Clientes.entidades.Cliente;
import ec.edu.ups.Clientes.entidades.peticiones.clientes.CrearCliente;
import ec.edu.ups.Clientes.servicios.ClienteNoEncontradoException;
import ec.edu.ups.Clientes.servicios.ClienteServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/activarServicio")
public class ClienteControlador {
    private ClienteServicio clienteServicio;

    private RestTemplate restTemplate;

    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @Autowired //inyeccion de dependencias
    public void setClienteServicio(ClienteServicio clienteServicio){
        this.clienteServicio=clienteServicio;
    }


    @Operation(summary = "Listar clientes")
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> listaClientes = clienteServicio.findAll();
        System.out.println("Se han listado clientes");
        return  new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
    }


    @Operation(summary = "Obtener cliente por Cedula")
    @GetMapping("/clienteByCedula/{cedula}")
    public ResponseEntity<Cliente> obtenerClienteByCedula(@PathVariable String cedula) {
        Optional<Cliente> clienteOptional = Optional.ofNullable(clienteServicio.obtenerClienteByCedula(cedula));
        Cliente u = clienteOptional.orElseThrow(ClienteNoEncontradoException::new);
        System.out.println("Lo que retorna es "+u);
        return new ResponseEntity<Cliente>(u, HttpStatus.OK);
    }


    @Operation(summary = "Crear Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente guardado!!",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class))}),
            @ApiResponse(responseCode = "400",description = "Objeto Cliente invalido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente no creado",
                    content = @Content)
    })
    @PostMapping("/cliente/create")
    public ResponseEntity<Cliente> createCliente(@RequestBody CrearCliente crearCliente) {
        Cliente c = new Cliente();
        c.setCedula(crearCliente.getCedula());
        c.setDireccion(crearCliente.getDireccion());
        c.setNombre(crearCliente.getNombre());
        c.setTelefono(crearCliente.getTelefono());
        clienteServicio.save(c);
        return ResponseEntity.ok(c);
    }

    @Operation(summary = "Eliminar Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente eliminado!!",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class))}),
            @ApiResponse(responseCode = "400",description = "Objeto Cliente invalido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado",
                    content = @Content)
    })
    @DeleteMapping("/cliente/delete/{codigo}")
    public ResponseEntity<String> deletePersona(@PathVariable long codigo) {
        clienteServicio.delete(codigo);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }




}
