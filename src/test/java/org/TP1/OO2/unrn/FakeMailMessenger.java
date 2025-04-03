package org.TP1.OO2.unrn;

import jakarta.mail.MessagingException;

public class FakeMailMessenger implements MailService {

    private String destinatario;
    private String asunto;
    private String mensaje;

    public FakeMailMessenger(){

    }

    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) throws MessagingException {

        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;

    }


    public String ElDestinatarioEs(){return destinatario;}

    public String ElAsuntoEs(){return asunto;}

    public String ElmensajeEs(){return mensaje;}

}
