package ar.edu.utn.frbb.tup.jupfi.logic;

import ar.edu.utn.frbb.tup.jupfi.model.Cliente;
import ar.edu.utn.frbb.tup.jupfi.model.Direccion;
import ar.edu.utn.frbb.tup.jupfi.model.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CargarClientes {
    public static List<Cliente> generarClientes() {
        // Crear una lista para almacenar los clientes
        List<Cliente> listaClientes = new ArrayList<>();

        // Crear personas con datos por defecto
        Direccion direccionPersona1 = new Direccion("Falsa 123", "Springfield", "12345", "Estados Unidos");
        Persona persona1 = new Persona("Juan", "Perez", "12345678", LocalDate.of(1990, 5, 15), direccionPersona1, "1122334455");
        Cliente cliente1 = new Cliente(1, persona1.getNombre(), persona1.getApellido(), direccionPersona1, persona1.getTelefono());
        listaClientes.add(cliente1); // Agregar el cliente a la lista

        Direccion direccionPersona2 = new Direccion("Avenida 456", "Springfield", "54321", "Estados Unidos");
        Persona persona2 = new Persona("María", "González", "87654321", LocalDate.of(1985, 8, 20), direccionPersona2, "5544332211");
        Cliente cliente2 = new Cliente(2, persona2.getNombre(), persona2.getApellido(), direccionPersona2, persona2.getTelefono());
        listaClientes.add(cliente2); // Agregar el otro cliente a la lista 

        // Retornar la lista de clientes
        return listaClientes;
    }
}
//La idea es poder cargar personas. En un programa real, las cargaria de una base de datos o algun archivo local.
//En este caso, se cargan personas "por defecto" para poder probar las otras funciones del programa sin problemas.