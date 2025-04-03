package org.TP1.OO2.unrn.Inciso2;

import java.time.LocalDate;

public class Visa extends TarjetaDeCredito {

    private static final int descuento = 3;

    public Visa(Comensal apoderado, long numeroTarjeta, LocalDate fechaExpiracion) {

        super(apoderado, numeroTarjeta, fechaExpiracion);
    }



    @Override
    public float aplicarDescuento(float precioBebidas, float precioComidas) {
        return precioComidas + (precioBebidas - (precioBebidas * descuento /100));
    }
}
