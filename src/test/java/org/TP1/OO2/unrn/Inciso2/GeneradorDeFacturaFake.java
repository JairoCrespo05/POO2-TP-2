package org.TP1.OO2.unrn.Inciso2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneradorDeFacturaFake implements FMPedidos{

    private String fecha;
    private float montoTotal;
    private String registroCompleto;


    @Override
    public void registrarPedidos(LocalDate fecha, float montoTotal) throws SQLException {

        this.fecha = dateFormatter(fecha);
        this.montoTotal = montoTotal;

        this.registroCompleto = this.fecha + " || " + this.montoTotal;

    }

    public String laFechaEs(){return fecha;}

    public float elMontoTotalEs(){return montoTotal;}

    public String elRegistroCompletoEs(){return registroCompleto;}

    private String dateFormatter(LocalDate fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fecha.format(formato);
    }

}
