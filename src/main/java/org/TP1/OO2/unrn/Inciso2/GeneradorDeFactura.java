package org.TP1.OO2.unrn.Inciso2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneradorDeFactura implements FMPedidos{

    static String PATH_VACIO = "El path no puede se vacio";
    static final String FALLO_DE_ESCRITURA = "No se pudo escribir este Archivo";

    private String path;

    public GeneradorDeFactura(String path) {
        checkPath(path);
        this.path = path;
    }

    @Override
    public void registrarPedidos(LocalDate fecha, float montoTotal) {

        String contenido = dateFormatter(fecha) + " || " + montoTotal + "\n";

        try {

            Path realPath = Path.of(this.path);
            Files.write(realPath,
                    contenido.getBytes(),
                    Files.exists(realPath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

        } catch (IOException e) {
            throw new RuntimeException(FALLO_DE_ESCRITURA);
        }
    }


    private String dateFormatter(LocalDate fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fecha.format(formato);
    }

    private void checkPath(String path){
        if(path.isBlank()){throw new RuntimeException(PATH_VACIO);}
    }


}
