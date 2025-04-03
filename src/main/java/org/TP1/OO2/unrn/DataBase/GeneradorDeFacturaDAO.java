package org.TP1.OO2.unrn.DataBase;

import org.TP1.OO2.unrn.Inciso2.FMPedidos;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneradorDeFacturaDAO implements FMPedidos {

    static String ERROR_REGISTRAR_PEDIDO = "Ocurrio un error al intentar registrar el pedido";


    public GeneradorDeFacturaDAO(){

    }

    @Override
    public void registrarPedidos(LocalDate fecha, float montoTotal) throws SQLException {
        System.out.println("Ejecutando ------> registrarPedidos(LocalDate fecha, float montoTotal);");
        System.out.println("Insertar fecha: [" + fecha + "] y monto: [" + montoTotal + "]");
        System.out.println(" ");

        String fechaFormateada = dateFormatter(fecha);

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement =
                    conn.prepareStatement(

                            "INSERT INTO pedidos (fechaPedido, montoTotal)"
                                    +	"VALUES (?, ?)" );

            statement.setString(1, fechaFormateada);
            statement.setFloat(2, montoTotal);

            int cantidad = statement.executeUpdate();
            if(cantidad > 0) {
                System.out.println("Modificando " + cantidad + " registros");
            } else {
                System.out.println("Error al crear el Rol");
            }

        } catch (SQLException e) {
            throw new SQLException(ERROR_REGISTRAR_PEDIDO);
        } finally {
            System.out.println("-------Desconectar servidor--------");
            ConnectionManager.disconnect();
        }
    }


    private String dateFormatter(LocalDate fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fecha.format(formato);
    }
}
