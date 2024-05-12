package modelo_dto;

import java.io.Serializable;

public class automovil implements Serializable {
    private int id;
    private String codigo;
    private String marca;
    private String modelo;
    private String color;
    private double precioBase;
    private double porcentajeImpuesto;
    private String tipoMotor;
    private boolean estadoVenta;


    public void AutomovilDTO(int id, String codigo, String marca, String modelo, String color, double precioBase,
                        double porcentajeImpuesto, String tipoMotor, boolean estadoVenta) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precioBase = precioBase;
        this.porcentajeImpuesto = porcentajeImpuesto;
        this.tipoMotor = tipoMotor;
        this.estadoVenta = estadoVenta;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }

    public void setPorcentajeImpuesto(double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public boolean isEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(boolean estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    @Override
    public String toString() {
        return "AutomovilDTO{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precioBase=" + precioBase +
                ", porcentajeImpuesto=" + porcentajeImpuesto +
                ", tipoMotor='" + tipoMotor + '\'' +
                ", estadoVenta=" + estadoVenta +
                '}';
    }

}
