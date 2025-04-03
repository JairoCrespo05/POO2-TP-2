package org.TP1.OO2.unrn.Inciso1;

public class Participante {

    static final String NOMBRE_Y_APELLIDO_INVALIDO = "El nombre y El apellido No pueden estar vacios";
    static final String ID_INVALIDO = "El Id No puede ser menor a 1";

    private String nombre;
    private String apellido;
    private int Id;
    private int puntosGanados;


    public Participante (String nombre, String apellido, int Id){
        checkNombreYApellido(nombre, apellido);
        checkId(Id);

        this.nombre = nombre;
        this.apellido = apellido;
        this.Id = Id;
        this.puntosGanados = 0;
    }

    public void sumarPuntos(){
        this.puntosGanados += 10;
    }

    public int misPuntos(){
        return this.puntosGanados;
    }

    public void checkNombreYApellido(String nombre, String apellido){
        if(nombre.isBlank() || apellido.isBlank()){
            throw new RuntimeException(NOMBRE_Y_APELLIDO_INVALIDO);
        }
    }

    public int miIdEs(){return this.Id;}

    public void checkId(int id){
        if(id < 1){throw new RuntimeException(ID_INVALIDO);}
    }

}
