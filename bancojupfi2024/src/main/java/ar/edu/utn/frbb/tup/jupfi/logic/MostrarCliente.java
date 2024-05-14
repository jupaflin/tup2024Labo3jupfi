package ar.edu.utn.frbb.tup.jupfi.logic;

import ar.edu.utn.frbb.tup.jupfi.model.Cliente;

import java.util.List;

public class MostrarCliente {
    public static void mostrarClientePorId(int id, List<Cliente> listaClientes) {
        boolean encontrado = false;

        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                encontrado = true;
                System.out.println("Información del cliente con ID " + id + ":");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Dirección: " + cliente.getDireccion());
                System.out.println("Teléfono: " + cliente.getTelefono());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente con ID " + id + " no encontrado.");
        }
    }
}