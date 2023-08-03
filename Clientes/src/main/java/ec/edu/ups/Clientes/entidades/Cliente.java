package ec.edu.ups.Clientes.entidades;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(long codigo, String nombre, String cedula, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codigo == cliente.codigo && Objects.equals(nombre, cliente.nombre) && Objects.equals(cedula, cliente.cedula) && Objects.equals(telefono, cliente.telefono) && Objects.equals(direccion, cliente.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, cedula, telefono, direccion);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
