package org.TP1.OO2.unrn.Inciso2;

import org.TP1.OO2.unrn.DataBase.GeneradorDeFacturaDAO;
import org.TP1.OO2.unrn.FakeMailMessenger;
import org.TP1.OO2.unrn.Inciso1.RegistroInscriptos;
import org.TP1.OO2.unrn.MailMessenger;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    @Test
    public void Test01(){

//        var registroMesa = new GeneradorDeFactura("C:/Users/Usuario/Documents/MiArchivoPedidosOO2.txt");
//        var registroMesa = new GeneradorDeFacturaDAO();
//        var mensajeria = new MailMessenger();


        var cliente = new Comensal("Julian", "Alvarez");
        var registroMesa = new GeneradorDeFacturaFake();
        var mensajeria = new FakeMailMessenger();
        var viedma = new TarjetSinDescuento(cliente, 231, LocalDate.parse("2025-04-16"));
        var mesa = new Mesa(10, registroMesa, mensajeria);
        var comida = new Alimento("Hamburguesa", 200);
        var bebida = new Alimento("Pepsi", 100);

        String registroEsperado = "02/04/2025 || 300.0";

        cliente.asignarTarjeta(viedma);

        mesa.aniadirBebidaAMenu(bebida);
        mesa.aniadirComidaAMenu(comida);
        mesa.sentarseEnLaMesa(cliente);


        mesa.hacerPedido(cliente, comida, 1, bebida, 1);



        assertEquals(registroEsperado, registroMesa.elRegistroCompletoEs());
        assertEquals("crespijairo5@gmail.com", mensajeria.ElDestinatarioEs());
        assertEquals("Pedido", mensajeria.ElAsuntoEs());
        assertEquals("Su pedido a sido registrado exitosamente", mensajeria.ElmensajeEs());


    }


}