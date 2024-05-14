package ar.edu.utn.frbb.tup.jupfi.model;

public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String pais;

    public Direccion() {
        this.calle = "";
        this.ciudad = "";
        this.codigoPostal = "";
        this.pais = "";
    }

    public Direccion(String calle, String ciudad, String codigoPostal, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Calle: " + calle + ", Ciudad: " + ciudad + ", Código Postal: " + codigoPostal + ", País: " + pais;
    }
}
