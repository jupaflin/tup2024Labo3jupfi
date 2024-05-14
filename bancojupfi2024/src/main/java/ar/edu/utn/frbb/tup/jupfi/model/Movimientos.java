package ar.edu.utn.frbb.tup.jupfi.model;

import java.time.LocalDateTime;

public class Movimientos {
    private LocalDateTime fechaHora;
    private String tipoOperacion;
    private double monto;
    private int numeroCuenta;

    public Movimientos(LocalDateTime fechaHora, String tipoOperacion, double monto, int numeroCuenta) {
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
