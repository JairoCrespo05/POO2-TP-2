package org.TP1.OO2.unrn.Inciso2;

import jakarta.mail.MessagingException;
import org.TP1.OO2.unrn.DataBase.GeneradorDeFacturaDAO;
import org.TP1.OO2.unrn.MailMessenger;
import org.TP1.OO2.unrn.MailService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mesa {

    static final String CANT_SILLAS_INVALIDA = "Cantidad de sillas Insuficiente";
    private GestorDeMenu menu;
    private List<Comensal> clientes;
    private int cantidadSillas;
    private FMPedidos ticket;
    private MailService mensajeria;


    public Mesa(int cantidadSillas, FMPedidos registroPedidos, MailService servicioMensajeria){
        checkCantSillas(cantidadSillas);

        this.cantidadSillas = cantidadSillas;
        this.clientes = new ArrayList<>();
        this.menu = new GestorDeMenu();
        this.ticket = registroPedidos;
        this.mensajeria = servicioMensajeria;


//        this.ticket = new GeneradorDeFactura("C:/Users/Usuario/Documents/MiArchivoPedidosOO2.txt");
////        this.ticket = new GeneradorDeFacturaDAO();
//        this.mensajeria = new MailMessenger();
    }

    public void sentarseEnLaMesa(Comensal cliente){ clientes.add(cliente); }

    public void aniadirComidaAMenu(Alimento comida){ menu.agregarComida(comida); }

    public void aniadirBebidaAMenu(Alimento bebida){ menu.agregarBebida(bebida); }

    public void checkCantSillas(int cantSillas){
        if(cantSillas <= 0){throw new RuntimeException(CANT_SILLAS_INVALIDA);}
    }

     public void hacerPedido(Comensal comensal, Alimento comida, int cantComida, Alimento bebida, int cantBebida) throws RuntimeException {

       float precioBebidas = menu.elegirDelMenuBebidas(bebida, cantBebida);
       float precioComidas = menu.elegirDelMenuComidas(comida, cantComida);

       float precioDescontado = comensal.pedirLaCuenta(precioBebidas, precioComidas);

         try {
             ticket.registrarPedidos(LocalDate.parse("2025-04-02"), precioDescontado);
             mensajeria.enviarCorreo("crespijairo5@gmail.com", "Pedido", "Su pedido a sido registrado exitosamente");
         } catch (SQLException | MessagingException e) {
             throw new RuntimeException(e.getMessage());
         }

         comensal.pagarLaCuenta(precioDescontado);

     }




}
