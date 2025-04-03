package org.TP1.OO2.unrn.Inciso2;

import java.util.ArrayList;
import java.util.List;

public class GestorDeMenu {


    protected static final String BEBIDA_NO_ENCONTRADA = "No se encontro la Bebida";
    protected static final String COMIDA_NO_ENCONTRADA = "No se encontro la Comida";
    private List<Alimento> menuComida;
    private List<Alimento> menuBebidas;

    public GestorDeMenu() {
        this.menuComida = new ArrayList<>();
        this.menuBebidas = new ArrayList<>();
    }


    public void agregarBebida(Alimento bebida){ menuBebidas.add(bebida);}

    public void agregarComida(Alimento comida){ menuComida.add(comida);}

    public float elegirDelMenuBebidas(Alimento bebida ,int cantidad){

        for(Alimento bebidas : menuBebidas){
            if(bebidas.equals(bebida)){
                return bebida.pedirAlimento(cantidad);
            }
        }
        throw new RuntimeException(BEBIDA_NO_ENCONTRADA);
    }

    public float elegirDelMenuComidas(Alimento comida ,int cantidad){
        for(Alimento comidas : menuComida){
            if(comidas.equals(comida)){

                return comida.pedirAlimento(cantidad);

            }
        }
        throw new RuntimeException(COMIDA_NO_ENCONTRADA);
    }


}
