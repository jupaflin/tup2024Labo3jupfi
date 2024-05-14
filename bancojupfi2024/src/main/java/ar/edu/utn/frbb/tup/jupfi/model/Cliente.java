package ar.edu.utn.frbb.tup.jupfi.model;

public class Cliente {
    private int id; //identificador del cliente
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private String telefono;

    public Cliente() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.direccion = new Direccion();
        this.telefono = "";
    }

    public Cliente(int id, String nombre, String apellido, Direccion direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
