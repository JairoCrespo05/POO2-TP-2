package org.TP1.OO2.unrn.Inciso1;

import java.time.LocalDate;

public class Inscripcion {

    static final String FECHA_INVALIDA = "El Tiempo de Inscripcion ya expiró";
    static final String PARTICIPANTE_INVALIDO = "El Participante NO puede ser nulo";
    static final String CONCURSO_INVALIDO = "El Concurso NO puede ser nulo";


    private Participante participante;
    private LocalDate fechaInscripcion;
    private Concurso concurso;


    public Inscripcion(Participante participante, LocalDate fechaInscripcion, Concurso concurso){
        checkParticipante(participante);
        checkConcurso(concurso);

        this.participante = participante;
        this.fechaInscripcion = fechaInscripcion;
        this.concurso = concurso;
    }

    public void puntuarParticipante(){
        if(concurso.esPrimerDia(this.fechaInscripcion)){
            participante.sumarPuntos();
        }
    }

    public boolean laFechaEsValida(LocalDate fechaInicio, LocalDate fechaFin)throws RuntimeException{

        if (fechaInscripcion.isBefore(fechaInicio) || fechaInscripcion.isAfter(fechaFin)) {
            throw new RuntimeException(FECHA_INVALIDA);

        }

        return true;
    }

    public LocalDate laFechaInscripcionEs(){return fechaInscripcion;}

    public void inscribirAlConcurso(Concurso concurso){

        puntuarParticipante();

        concurso.agregarParticipante(this.participante, this);
    }

    public void checkParticipante(Participante participante){
        if(participante == null){throw  new RuntimeException(PARTICIPANTE_INVALIDO);}
    }

    public void checkConcurso(Concurso concurso){
        if(concurso == null){throw  new RuntimeException(CONCURSO_INVALIDO);}
    }

}
