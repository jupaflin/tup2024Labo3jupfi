package ar.edu.utn.frbb.tup.jupfi.logic;

import ar.edu.utn.frbb.tup.jupfi.model.Movimientos;
import java.util.ArrayList;
import java.util.List;

public class GestorMovimientos {    //para registrar movimientos cuando una persona le da dinero a otra
    private static List<Movimientos> listaMovimientos = new ArrayList<>();

    public static void registrarMovimiento(Movimientos movimiento) {
        listaMovimientos.add(movimiento);
    }

    public static List<Movimientos> getListaMovimientos() {
        return listaMovimientos;
    }
}

