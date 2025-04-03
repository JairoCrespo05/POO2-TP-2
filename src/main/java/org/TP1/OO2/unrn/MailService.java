package org.TP1.OO2.unrn;

import jakarta.mail.MessagingException;

public interface MailService {

    void enviarCorreo(String destinatario,String asunto, String mensaje) throws MessagingException;

}
