package ar.edu.utn.frbb.tup.jupfi;

import ar.edu.utn.frbb.tup.jupfi.input.Menu;
import ar.edu.utn.frbb.tup.jupfi.logic.CargarClientes;
import ar.edu.utn.frbb.tup.jupfi.model.Cliente;
import ar.edu.utn.frbb.tup.jupfi.model.Cuenta;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        List<Cliente> listaClientes = CargarClientes.generarClientes();
        List<Cuenta> listaCuentas = new ArrayList<>();
        Menu.mostrarMenu(listaClientes, listaCuentas);
    }
}


