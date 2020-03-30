package lp2.taller_mecanico.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Vehiculo {
    private int idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private String comentario;
    private Collection<Registro> registrosByIdVehiculo;
    private Cliente clienteByIdCliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo", nullable = false)
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Basic
    @Column(name = "patente", nullable = false, length = 10, unique=true)
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Basic
    @Column(name = "marca", nullable = true, length = 60)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "modelo", nullable = true, length = 50)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Basic
    @Column(name = "anio", nullable = true)
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer año) {
        this.anio = año;
    }

    @Basic
    @Column(name = "comentario", nullable = true, length = 100)
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        if (idVehiculo != vehiculo.idVehiculo) return false;
        if (patente != null ? !patente.equals(vehiculo.patente) : vehiculo.patente != null) return false;
        if (marca != null ? !marca.equals(vehiculo.marca) : vehiculo.marca != null) return false;
        if (modelo != null ? !modelo.equals(vehiculo.modelo) : vehiculo.modelo != null) return false;
        if (anio != null ? !anio.equals(vehiculo.anio) : vehiculo.anio != null) return false;
        if (comentario != null ? !comentario.equals(vehiculo.comentario) : vehiculo.comentario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVehiculo;
        result = 31 * result + (patente != null ? patente.hashCode() : 0);
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (anio != null ? anio.hashCode() : 0);
        result = 31 * result + (comentario != null ? comentario.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "vehiculoByIdVehiculo")
    public Collection<Registro> getRegistrosByIdVehiculo() {
        return registrosByIdVehiculo;
    }

    public void setRegistrosByIdVehiculo(Collection<Registro> registrosByIdVehiculo) {
        this.registrosByIdVehiculo = registrosByIdVehiculo;
    }

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    public Cliente getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(Cliente clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }

    @Override
    public String toString() {
        return marca +" "+ modelo+" "+patente;
    }
}
