package ar.edu.utn.frbb.tup.jupfi.logic;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import ar.edu.utn.frbb.tup.jupfi.model.Cliente;
import ar.edu.utn.frbb.tup.jupfi.model.Cuenta;
import ar.edu.utn.frbb.tup.jupfi.model.Movimientos;


public class OperacionesCuenta {
    
    public static void crearCuenta(int idCliente, List<Cliente> listaClientes, List<Cuenta> listaCuentas) {
        // Buscar el cliente en la lista
        Cliente clienteAsociado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                clienteAsociado = cliente;
                break;
            }
        }
        if (clienteAsociado != null) {
            //Aca se genera el número de cuenta sumando 1000 al ID del cliente. Este nuevo numero podria ser aleatorio
            int numeroCuenta = clienteAsociado.getId() + 1000;

            // Crear la cuenta bancaria
            Cuenta nuevaCuenta = new Cuenta();
            nuevaCuenta.setNumeroCuenta(numeroCuenta);
            nuevaCuenta.setCliente(clienteAsociado);
            nuevaCuenta.setSaldo(0.0);
            nuevaCuenta.setTipoCuenta("Cuenta Bancaria");
            nuevaCuenta.setFechaApertura(LocalDate.now());

            listaCuentas.add(nuevaCuenta); // Agregar la cuenta a la lista

            System.out.println("Se ha creado una nueva cuenta bancaria para el cliente con ID " + idCliente);
            System.out.println("Número de cuenta asignado: " + numeroCuenta);
        } else {
            System.out.println("No se encontró ningún cliente con el ID especificado.");
        }
    }

    public static void mostrarDatosCuenta(List<Cuenta> listaCuentas, int numeroCuentaIngresado) {
        boolean cuentaEncontrada = false;
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuentaIngresado) {
                cuentaEncontrada = true;
                System.out.println("----- Datos de la Cuenta Bancaria -----");
                System.out.println("Número de Cuenta: " + cuenta.getNumeroCuenta());
                System.out.println("Cliente Asociado: " + cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
                System.out.println("Tipo de Cuenta: " + cuenta.getTipoCuenta());
                System.out.println("Saldo: " + cuenta.getSaldo());
                System.out.println("Fecha de Apertura: " + cuenta.getFechaApertura());
                break;
            }
        }
        if (!cuentaEncontrada) {
            System.out.println("La cuenta con el número " + numeroCuentaIngresado + " no fue encontrada.");
        }
    }
    
    
    public static void consultarDinero(Cuenta cuenta) {
        System.out.println("----- Consulta de Dinero -----");
        System.out.println("Saldo actual en la cuenta: " + cuenta.getSaldo());
    }
    
    //depositar dinero en la cuenta
    public static void depositarDinero(Cuenta cuenta, double monto) {
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        //creo que me falta registrar el movimiento en Movimientos.java
    }

    // retirar dinero de la cuenta
    public static void retirarDinero(Cuenta cuenta, double monto) {
        if (monto <= cuenta.getSaldo()) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    //transferir dinero desde esta cuenta a otra cuenta
    public static void transferirDinero(Cuenta origen, Cuenta destino, double monto) {
        if (monto <= origen.getSaldo()) {
            origen.setSaldo(origen.getSaldo() - monto);
            destino.setSaldo(destino.getSaldo() + monto);
            
            //se registra la transferencia
            Movimientos movimientoOrigen = new Movimientos(LocalDateTime.now(), "Transferencia a cuenta " + destino.getNumeroCuenta(), -monto, origen.getNumeroCuenta());
            GestorMovimientos.registrarMovimiento(movimientoOrigen);
            Movimientos movimientoDestino = new Movimientos(LocalDateTime.now(), "Transferencia desde cuenta " + origen.getNumeroCuenta(), monto, destino.getNumeroCuenta());
            GestorMovimientos.registrarMovimiento(movimientoDestino);

        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }
}
