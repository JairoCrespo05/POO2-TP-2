package org.TP1.OO2.unrn.Inciso1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistroInscriptos implements FileManager {

    static final String PATH_VACIO = "El path esta vacio";
    static final String NO_ES_ARCHIVO = "No es un Archivo";
    static final String NO_ES_ARCHIVO_LEGIBLE = "No es un Archivo Legible";
    static final String ARCHIVO_NO_SE_ESCRIBE = "No se puede escribir en este Archivo";
    static final String ARCHIVO_NO_CREADO = "No se puede crear este Archivo";
    static final String FALLO_DE_ESCRITURA = "No se pudo escribir este Archivo";


    private String path;

    public RegistroInscriptos(String path){
        checkPath(path);
        this.path = path;
        System.out.println("Constructor Path: "+path);
    }


    @Override
    public void RegistrarEnArchivo(/*String path,*/ LocalDate fechaInscripcion, int id_Participante, int id_Concurso) {
        String contenido = dateFormater(fechaInscripcion)  + " , " + id_Participante + " , " + id_Concurso + "\n";

        try {

            Path realPath = Path.of(this.path);

            Files.write(realPath,
                        contenido.getBytes(),
                    /*Si existe el archivo escribe, si no existe lo crea*/
                    Files.exists(realPath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

        } catch (IOException e) {
            throw new RuntimeException(FALLO_DE_ESCRITURA);
        }
    }


    private String dateFormater(LocalDate fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fecha.format(formato);
    }

    private void checkPath(String path){
        if(path.isBlank()){ throw new RuntimeException(PATH_VACIO); }
    }

    private void checkEsArchivo(File arch){
        if(!arch.isFile()){throw new RuntimeException(NO_ES_ARCHIVO); }
    }

    private void checkEsLegible(File arch){
        if(!arch.canRead()){throw new RuntimeException(NO_ES_ARCHIVO_LEGIBLE); }
    }

    private void checkSePuedeEscribir(File arch){
        if(!arch.canWrite()){throw new RuntimeException(ARCHIVO_NO_SE_ESCRIBE); }
    }

    public String miPathEs(){ return path; }

}
