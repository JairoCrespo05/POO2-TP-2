package org.TP1.OO2.unrn.Inciso1;

import java.sql.SQLException;
import java.time.LocalDate;

public abstract interface FileManager {

    void RegistrarEnArchivo(LocalDate fechaInscripcion, int id_Participante, int id_Concurso) throws SQLException;

}
