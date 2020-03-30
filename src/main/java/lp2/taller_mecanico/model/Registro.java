package lp2.taller_mecanico.model;

import javax.persistence.*;
import java.util.Random;

@Entity
public class Registro {

    public Random r= new Random();

    private int idRegistro;
    private String hora;
    private String dia;
    private String mes;
    private String anio;
    private String estado;
    private Integer costo;
    private Vehiculo vehiculoByIdVehiculo;
    private String codigo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistro", nullable = false)
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    @Basic
    @Column(name = "hora", nullable = true, length = 30)
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    @Basic
    @Column(name = "dia", nullable = true, length = 30)
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Basic
    @Column(name = "mes", nullable = true, length = 30)
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    @Basic
    @Column(name = "anio", nullable = true, length = 30)
    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Basic
    @Column(name = "estado", nullable = true, length = 30)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "costo", nullable = true)
    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Basic
    @Column(name = "codigo", nullable = true)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String generarCodigo() {
        String codigo=""+(r.nextInt(888888)+111111);
        return codigo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registro registro = (Registro) o;

        if (idRegistro != registro.idRegistro) return false;
        if (hora != null ? !hora.equals(registro.hora) : registro.hora != null) return false;
        if (dia != null ? !dia.equals(registro.dia) : registro.dia != null) return false;
        if (mes != null ? !mes.equals(registro.mes) : registro.mes != null) return false;
        if (anio != null ? !anio.equals(registro.anio) : registro.anio != null) return false;
        if (estado != null ? !estado.equals(registro.estado) : registro.estado != null) return false;
        if (costo != null ? !costo.equals(registro.costo) : registro.costo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRegistro;
        result = 31 * result + (hora != null ? hora.hashCode() : 0);
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        result = 31 * result + (mes != null ? mes.hashCode() : 0);
        result = 31 * result + (anio != null ? anio.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (costo != null ? costo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idVehiculo", referencedColumnName = "idVehiculo", nullable = false)
    public Vehiculo getVehiculoByIdVehiculo() {
        return vehiculoByIdVehiculo;
    }

    public void setVehiculoByIdVehiculo(Vehiculo vehiculoByIdVehiculo) {
        this.vehiculoByIdVehiculo = vehiculoByIdVehiculo;
    }
}
