package org.TP1.OO2.unrn.Inciso2;

import java.time.LocalDate;

public class ComarcaPlus extends TarjetaDeCredito{

    private static final int descuento = 2;

    public ComarcaPlus(Comensal apoderado, long numeroTarjeta, LocalDate fechaExpiracion) {

        super(apoderado, numeroTarjeta, fechaExpiracion);
    }

    @Override
    public float aplicarDescuento(float precioBebidas, float precioComidas) {
        float precioTotal = precioBebidas + precioComidas;
        return (precioTotal - (precioTotal * descuento /100));
    }

}
