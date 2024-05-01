package concesionario.modelo_dto;

public class formaPago {
    private int id;
    private String descripcion;

    // Constructor
    public void FormaPagoDTO(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método toString para imprimir el DTO
    @Override
    public String toString() {
        return "FormaPagoDTO{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
