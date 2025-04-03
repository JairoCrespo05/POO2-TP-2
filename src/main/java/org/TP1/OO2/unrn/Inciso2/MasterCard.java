package org.TP1.OO2.unrn.Inciso2;

import java.time.LocalDate;

public class MasterCard extends TarjetaDeCredito{

    private static final int descuento = 2;

    public MasterCard(Comensal apoderado, long numeroTarjeta, LocalDate fechaExpiracion) {

        super(apoderado, numeroTarjeta, fechaExpiracion);
    }

    @Override
    public float aplicarDescuento(float precioBebidas, float precioComidas) {
        return precioBebidas + (precioComidas - (precioComidas * descuento /100));
    }
}
