package org.TP1.OO2.unrn.DataBase;

import org.TP1.OO2.unrn.Inciso1.FileManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class RegistroInscriptosDAO implements FileManager {

    static String ERROR_REGISTRAR_INSCRIPTO = "Ocurrio un error al intentar registrar al inscripto";

    public RegistroInscriptosDAO(){

    }

    @Override
    public void RegistrarEnArchivo(LocalDate fechaInscripcion, int id_Participante, int id_Concurso) throws SQLException {
        System.out.println("Ejecutando ------> registrarPedidos(LocalDate fecha, float montoTotal);");
        System.out.println("Insertar fecha: [" + fechaInscripcion + "] , id_Participante: [" + id_Participante + "] e id_Concurso: [" + id_Concurso + "] ");
        System.out.println(" ");

        String fechaFormateada = dateFormatter(fechaInscripcion);

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement =
                    conn.prepareStatement(

                            "INSERT INTO inscripciones (fechaInscripcion, id_Participante, id_Concurso)"
                                    +	"VALUES (?, ?, ?)" );

            statement.setString(1, fechaFormateada);
            statement.setInt(2, id_Participante);
            statement.setInt(3, id_Concurso);


            int cantidad = statement.executeUpdate();
            if(cantidad > 0) {
                System.out.println("Modificando " + cantidad + " registros");
            } else {
                System.out.println("Error al crear el Rol");
            }

        } catch (SQLException e) {
            throw new SQLException(ERROR_REGISTRAR_INSCRIPTO );
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
