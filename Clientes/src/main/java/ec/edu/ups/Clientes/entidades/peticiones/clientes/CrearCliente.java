package ec.edu.ups.Clientes.entidades.peticiones.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearCliente {

    @JsonProperty
    private String nombre;
    @JsonProperty
    private String cedula;
    @JsonProperty
    private String telefono;
    @JsonProperty
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
