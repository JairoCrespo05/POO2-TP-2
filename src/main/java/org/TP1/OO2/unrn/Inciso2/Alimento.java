package org.TP1.OO2.unrn.Inciso2;

public class Alimento {


    protected static final String NOMBRE_VACIO = "El Nombre no puede estar vacio";
    protected static final String PRECIO_INVALIDO = "El Precio no es valido";
    private String nombre;
    private float precio;


    public Alimento(String nombre, float precio) {
        checkNombreAlimento(nombre);
        checkPrecioAlimento(precio);

        this.nombre = nombre;
        this.precio = precio;
    }


    @Override
    public boolean equals(Object obj) {

        Alimento alimento = (Alimento) obj;

        if(!this.nombre.equals(alimento.suNombreEs())) {return false;}

        if(!(this.precio == alimento.suPrecioEs())) {return false;}

        return true;
    }

    public String suNombreEs(){return this.nombre;}

    public float pedirAlimento(int cantidad){return precio * cantidad;}

    public float suPrecioEs(){ return this.precio;}

    public void checkNombreAlimento(String nombre){
        if(nombre.isBlank()){throw  new RuntimeException(NOMBRE_VACIO);}
    }

    public void checkPrecioAlimento(float precio){
        if(precio <= 0){throw  new RuntimeException(PRECIO_INVALIDO);}
    }


}
