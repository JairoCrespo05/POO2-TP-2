package org.TP1.OO2.unrn;
import org.TP1.OO2.unrn.DataBase.GeneradorDeFacturaDAO;
import org.TP1.OO2.unrn.DataBase.RegistroInscriptosDAO;
import org.TP1.OO2.unrn.Inciso2.*;
import org.TP1.OO2.unrn.Inciso1.*;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String [] args) throws SQLException {

        System.out.println("//////////////////CONCURSO////////////////////////////////");

        //Acceso a DataBase
//        var registroInscriptos = new RegistroInscriptosDAO();

        //Registro en Disco
        var registroInscriptos = new RegistroInscriptos("C:/Users/Usuario/Documents/MiArchivoInscriptosOO2.txt");

        var mensajeriaConcurso = new MailMessenger();
        Participante participante = new Participante("Juan", "Lopez", 33);
        Concurso concurso = new Concurso(2024, "GranConcurso", LocalDate.now(), LocalDate.parse("2025-09-12"), registroInscriptos, mensajeriaConcurso);
        Inscripcion inscripcion = new Inscripcion(participante, LocalDate.now(), concurso);

        inscripcion.inscribirAlConcurso(concurso);

        System.out.println("///////////////////RESTAURANTE///////////////////////////////");

        //Registro en DataBase
//        var registroPedidos = new GeneradorDeFacturaDAO();

        //Registro en Disco
        var registroPedidos = new GeneradorDeFactura("C:/Users/Usuario/Documents/MiArchivoPedidosOO2.txt");

        var cliente = new Comensal("Julian", "Alvarez");
        var mensajeriaMesa = new MailMessenger();
        var viedma = new TarjetSinDescuento(cliente, 231, LocalDate.parse("2025-04-16"));
        var mesa = new Mesa(10, registroPedidos, mensajeriaMesa);
        var comida = new Alimento("Hamburguesa", 200);
        var bebida = new Alimento("Pepsi", 100);

        cliente.asignarTarjeta(viedma);

        mesa.aniadirBebidaAMenu(bebida);
        mesa.aniadirComidaAMenu(comida);
        mesa.sentarseEnLaMesa(cliente);

        mesa.hacerPedido(cliente, comida, 1, bebida, 1);


    }
}
