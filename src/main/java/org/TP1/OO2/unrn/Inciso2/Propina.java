package org.TP1.OO2.unrn.Inciso2;

public enum Propina {

    BAJA(0.02F),
    MEDIA(0.03F),
    ALTA(0.05F);

    private final float monto;

    Propina(float monto){this.monto = monto;}

    public float monto(){ return monto;}

}
