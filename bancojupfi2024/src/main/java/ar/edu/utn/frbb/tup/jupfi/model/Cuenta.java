package ar.edu.utn.frbb.tup.jupfi.model;

import java.time.LocalDate;

public class Cuenta {
    private int numeroCuenta;
    private Cliente cliente;
    private String tipoCuenta;
    private double saldo;
    private LocalDate fechaApertura;

    public Cuenta() {
        this.numeroCuenta = 0;
        this.cliente = null;
        this.tipoCuenta = "";
        this.saldo = 0.0;
        this.fechaApertura = null;
    }

    public Cuenta(int numeroCuenta, Cliente cliente, String tipoCuenta, double saldo, LocalDate fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
}
