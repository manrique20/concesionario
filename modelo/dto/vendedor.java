package modelo_dto;

public class vendedor {
    private int id;
    private String nombre;
    private String profesion;

    // Constructor
    public void VendedorDTO(int id, String nombre, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.profesion = profesion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    // Método toString para imprimir el DTO
    @Override
    public String toString() {
        return "VendedorDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
