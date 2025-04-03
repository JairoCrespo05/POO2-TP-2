package org.TP1.OO2.unrn.Inciso1;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistroInscriptosFake implements FileManager {

    private String fechaInscripcion;
    private int id_Participante;
    private int id_Concurso;
    private String registroCompleto;


    @Override
    public void RegistrarEnArchivo(LocalDate fechaInscripcion, int id_Participante, int id_Concurso) throws SQLException {

        this.fechaInscripcion = dateFormatter(fechaInscripcion);
        this.id_Participante = id_Participante;
        this.id_Concurso = id_Concurso;

        this.registroCompleto = this.fechaInscripcion + " , " + this.id_Participante + " , " + this.id_Concurso;

    }


    private String dateFormatter(LocalDate fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fecha.format(formato);
    }

    public String laFechaEs(){return fechaInscripcion;}

    public int elIdParticipanteEs(){return id_Participante;}

    public int elIdConcursoEs(){return id_Concurso;}

    public String elRegistroCompletoEs(){return registroCompleto;}


}
