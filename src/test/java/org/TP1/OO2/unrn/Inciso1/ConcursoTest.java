package org.TP1.OO2.unrn.Inciso1;

import org.TP1.OO2.unrn.DataBase.RegistroInscriptosDAO;
import org.TP1.OO2.unrn.FakeMailMessenger;
import org.TP1.OO2.unrn.MailMessenger;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {

    @Test
    public void Test01(){

//        var registroInscriptos = new RegistroInscriptosDAO();
//        var registroInscriptos = new RegistroInscriptos("C:/Users/Usuario/Documents/MiArchivoInscriptosOO2.txt");
//        var mensajeriaConcurso = new MailMessenger();

        var registroInscriptos = new RegistroInscriptosFake();
        var mensajeriaConcurso = new FakeMailMessenger();
        String registroEsperado = "31/03/2025 , 33 , 2024";


        Participante participante = new Participante("Juan", "Lopez", 33);
        Concurso concurso = new Concurso(2024, "GranConcurso", LocalDate.parse("2024-12-18"), LocalDate.parse("2026-09-12"), registroInscriptos, mensajeriaConcurso);
        Inscripcion inscripcion = new Inscripcion(participante, LocalDate.parse("2025-03-31"), concurso);

        inscripcion.inscribirAlConcurso(concurso);

        assertEquals(registroEsperado, registroInscriptos.elRegistroCompletoEs());
        assertEquals("crespijairo5@gmail.com", mensajeriaConcurso.ElDestinatarioEs());
        assertEquals("Inscrpcion", mensajeriaConcurso.ElAsuntoEs());
        assertEquals("Usted ha sido Registrado al Concurso", mensajeriaConcurso.ElmensajeEs());


    }

}