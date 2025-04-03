package org.TP1.OO2.unrn.Inciso2;

public class Comensal {

    static final String NOMBRE_Y_APELLIDO_INVALIDO = "El nombre y El apellido No pueden estar vacios";
    private String nombre;
    private String apellido;
    private TarjetaDeCredito tarjetaDeCredito;

    public Comensal(String nombre, String apellido){

        checkApellidoYNombre(nombre, apellido);

        this.nombre = nombre;
        this.apellido = apellido;

    }

    public void asignarTarjeta(TarjetaDeCredito tarjeta){this.tarjetaDeCredito = tarjeta;}


    public float pedirLaCuenta(float precioBebidas, float precioComidas){

        return this.tarjetaDeCredito.aplicarDescuento(precioBebidas, precioComidas);

    }

    public void pagarLaCuenta (float montoAPagar){
        this.tarjetaDeCredito.pagar(montoAPagar);
        //Pago con Propina
        //this.tarjetaDeCredito.pagarMasPropina(montoAPagar, Propina.BAJA);
    }

    public boolean checkApellidoYNombre(String apellido, String name){
        if(name.isBlank() || apellido.isBlank()){
            throw new RuntimeException(NOMBRE_Y_APELLIDO_INVALIDO);
        }
        return true;
    }


}
