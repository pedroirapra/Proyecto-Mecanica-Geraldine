package lp2.taller_mecanico.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Cliente {
    private int idCliente;
    private String run;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Collection<Vehiculo> vehiculosByIdCliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente", nullable = false)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "run", nullable = false, length = 12, unique=true)
    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido", nullable = true, length = 50)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50, unique=true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telefono", nullable = true, length = 50)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre +" "+ apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (idCliente != cliente.idCliente) return false;
        if (run != null ? !run.equals(cliente.run) : cliente.run != null) return false;
        if (nombre != null ? !nombre.equals(cliente.nombre) : cliente.nombre != null) return false;
        if (apellido != null ? !apellido.equals(cliente.apellido) : cliente.apellido != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;
        if (telefono != null ? !telefono.equals(cliente.telefono) : cliente.telefono != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (run != null ? run.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);

        return result;
    }

    @OneToMany(mappedBy = "clienteByIdCliente")
    public Collection<Vehiculo> getVehiculosByIdCliente() {
        return vehiculosByIdCliente;
    }

    public void setVehiculosByIdCliente(Collection<Vehiculo> vehiculosByIdCliente) {
        this.vehiculosByIdCliente = vehiculosByIdCliente;
    }
}
