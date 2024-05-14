package ar.edu.utn.frbb.tup.jupfi.input;

import ar.edu.utn.frbb.tup.jupfi.logic.GestorMovimientos;
import ar.edu.utn.frbb.tup.jupfi.logic.MostrarCliente;
import ar.edu.utn.frbb.tup.jupfi.model.Cliente;
import ar.edu.utn.frbb.tup.jupfi.logic.OperacionesCuenta;
import ar.edu.utn.frbb.tup.jupfi.model.Cuenta;
import ar.edu.utn.frbb.tup.jupfi.model.Movimientos;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void mostrarMenu(List<Cliente> listaClientes, List<Cuenta> listaCuentas) {
        Scanner scanner = new Scanner(System.in);
        int opcionMenu;

        do {
            System.out.println("----- Menú -----");
            System.out.println("1 - Ingresar a Cuenta Bancaria con el numero de cuenta");
            System.out.println("2 - Crear Cuenta Bancaria en base a ID del cliente.");
            System.out.println("3 - Mostrar cliente por ID");
            System.out.println("4 - Mostrar todos los movimientos");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            
            opcionMenu = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingresar a Cuenta Bancaria:");
                    try {
                        System.out.print("Ingrese el número de cuenta bancaria: ");
                        int numeroCuenta = scanner.nextInt();
                        scanner.nextLine();
                
                        // Buscar la cuenta en la lista de cuentas
                        Cuenta cuentaSeleccionada = null;
                        for (Cuenta cuenta : listaCuentas) {
                            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                                cuentaSeleccionada = cuenta;
                                break;
                            }
                        }
                
                        if (cuentaSeleccionada != null) {
                            SubMenu.mostrarSubMenu(listaCuentas, numeroCuenta);
                        } else {
                            System.out.println("La cuenta bancaria ingresada no existe.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Ingrese un número de cuenta bancaria valido.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    // Crear una cuenta bancaria asociada a un cliente
                    System.out.print("Ingrese el ID del cliente para asociar la cuenta bancaria (se creara un nuevo numero): ");
                    int idClienteCreacion = scanner.nextInt();
                    scanner.nextLine();

                    OperacionesCuenta.crearCuenta(idClienteCreacion, listaClientes, listaCuentas);
                    break;
                case 3:
                    // Pedir al usuario que ingrese el ID del cliente
                    System.out.print("Ingrese el ID del cliente a mostrar (Ej: 1,2): ");
                    int idClienteConsulta = scanner.nextInt();
                    scanner.nextLine();

                    MostrarCliente.mostrarClientePorId(idClienteConsulta, listaClientes);
                    break;

                case 4:
                    // Mostrar todos los movimientos
                    System.out.println("----- Todos los movimientos -----");
                    List<Movimientos> movimientos = GestorMovimientos.getListaMovimientos();
                    if (!movimientos.isEmpty()) {
                        for (Movimientos movimiento : movimientos) {
                            System.out.println("Fecha y hora: " + movimiento.getFechaHora());
                            System.out.println("Tipo de operación: " + movimiento.getTipoOperacion());
                            System.out.println("Monto: " + movimiento.getMonto());
                            System.out.println("--------------------");
                        }
                    } else {
                        System.out.println("No hay movimientos registrados.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                    break;
            }
        } while (opcionMenu != 5);
    }
}
