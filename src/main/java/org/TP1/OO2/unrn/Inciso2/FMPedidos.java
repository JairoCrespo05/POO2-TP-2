package org.TP1.OO2.unrn.Inciso2;

import java.sql.SQLException;
import java.time.LocalDate;

public interface FMPedidos {

    void registrarPedidos(LocalDate fecha, float montoTotal) throws SQLException;

}
