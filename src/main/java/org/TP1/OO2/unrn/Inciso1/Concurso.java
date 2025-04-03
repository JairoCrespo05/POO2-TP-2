package org.TP1.OO2.unrn.Inciso1;

import jakarta.mail.MessagingException;
import org.TP1.OO2.unrn.MailMessenger;
import org.TP1.OO2.unrn.MailService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

    static final String YA_INSCRIPTO = "El Participante ya esta inscripto";
    static final String NOMBRE_CONCURSO_INVALIDO = "El nombre del Concurso no es valido";
    static final String FECHAS_INVALIDAS = "Las Fechas del Concurso no son validas";
    static final String ID_NO_VALIDO = "El Id no es valido";

    private int id_Concurso;
    private String nombreConcurso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Participante> inscriptos;
    private FileManager registro;
    private MailService mensajeria;

    public  Concurso(int id_Concurso, String nombreCurso, LocalDate fechaInicio, LocalDate fechaFin, FileManager registroInscriptos, MailService servicioMensajeria){
        checkIdConcurso(id_Concurso);
        checkNombreConcurso(nombreCurso);
        checkFechasValidas(fechaInicio, fechaFin);

        this.id_Concurso = id_Concurso;
        this.nombreConcurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inscriptos =  new ArrayList<>();
        this.registro = registroInscriptos;
        this.mensajeria = servicioMensajeria;

//        this.registro = new RegistrarInscriptosDAO();
//        this.registro = new RegistroInscriptos("C:/Users/Usuario/Documents/MiArchivoInscriptosOO2.txt");
//        this.mensajeria = new MailMessenger();
    }


    public boolean validarFechaInscripcion(Inscripcion inscripcion){

        inscripcion.laFechaEsValida(this.fechaInicio, this.fechaFin);

        return true;
    }

    public boolean esPrimerDia(LocalDate fecha){
        if (fecha.equals(this.fechaInicio)) return true;
        return false;
    }



    public void agregarParticipante(Participante participante, Inscripcion inscripcion)throws RuntimeException{
        if(EstaInscripto(participante)){
            throw new RuntimeException(YA_INSCRIPTO);
        }
        if(validarFechaInscripcion(inscripcion)){
            inscriptos.add(participante);
            try {
                registro.RegistrarEnArchivo( inscripcion.laFechaInscripcionEs(), participante.miIdEs(), this.id_Concurso);
                mensajeria.enviarCorreo("crespijairo5@gmail.com", "Inscrpcion", "Usted ha sido Registrado al Concurso");
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            } catch (MessagingException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public boolean EstaInscripto(Participante participante){
        if(inscriptos.contains(participante)) return true;
        return false;
    }

    public void checkNombreConcurso(String nombreConcurso){
        if(nombreConcurso.isBlank()){throw new RuntimeException(NOMBRE_CONCURSO_INVALIDO);}
    }

    public void checkFechasValidas(LocalDate fechaIni, LocalDate fechaFin){
        if(fechaIni == null || fechaFin == null){throw new RuntimeException(FECHAS_INVALIDAS);}
    }

    public void checkIdConcurso(int id_Concurso){
        if(id_Concurso < 1){throw new RuntimeException(ID_NO_VALIDO);}
    }
}
