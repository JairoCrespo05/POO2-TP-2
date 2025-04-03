package org.TP1.OO2.unrn.Inciso2;

import java.time.LocalDate;

public abstract class TarjetaDeCredito {

//Siempre y cuando el source y el test esten en un paquete de igual nombre ej: "package.unrn.tp1.oo2" el mensaje se puede usar en los test aunque este protected
    static final String SALDO_INSUFICIENTE = "El Saldo es Insuficiente";
    static final String NUMERO_TARJETA_INVALIDO = "El numero de tarjeta NO  es valido";
    static final String TITULAR_NULO = "El titular no Puede ser Nulo";
    static final String TARJETA_VENCIDA = "La tarjeta Ya Expiró";

      private Comensal titular;
      private long numeroTarjeta;
      private LocalDate fechaExpiracion;
      private float saldo;



     protected TarjetaDeCredito(Comensal apoderado, long numeroTarjeta, LocalDate fechaExpiracion) {

        checkTitular(apoderado);
        checknumTarjeta(numeroTarjeta);
        checkNoExpiro(fechaExpiracion);

        this.titular = apoderado;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;

        //este atributo solo lo utilizo para corroborar si se pago el pedido
        this.saldo = 10000;
    }


    public abstract float aplicarDescuento(float precioBebidas, float precioComidas);

     public float miSaldoEs(){return this.saldo;}

    public void checkNoExpiro(LocalDate fechaExpiracion){
            if(fechaExpiracion.isBefore(LocalDate.now()) ){
                  throw new RuntimeException(TARJETA_VENCIDA);
            }
    }


    public void checknumTarjeta(long numTarjeta){
           if(numTarjeta < 1){
                 throw new RuntimeException(NUMERO_TARJETA_INVALIDO);
           }
    }

    public void checkTitular(Comensal titular){
           if(titular == null){
                 throw new RuntimeException(TITULAR_NULO);
           }
    }

    public void pagar(float precio){
        if(this.saldo < precio){
            throw new RuntimeException(SALDO_INSUFICIENTE);
        }

        this.saldo -= precio;
    }

    public void pagarMasPropina(float precio, Propina propina){

        float precioTotal = precio + propina.monto();

        if(this.saldo < precioTotal ){
            throw new RuntimeException(SALDO_INSUFICIENTE);
        }
        this.saldo -= precio;
    }

}
