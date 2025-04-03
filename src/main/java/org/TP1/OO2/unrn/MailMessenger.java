package org.TP1.OO2.unrn;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


import java.util.Properties;

public class MailMessenger implements MailService {

    private static final String HOST  = "sandbox.smtp.mailtrap.io";
    private static final String PORT = "2525";
//    private  String ssl = "no";
//    private  String tsl = "yes";
    private static final String USER = "b87e2abe360271";
    private static final String PASSWORD = "1e149bd54796d7";
    private static final String TOKEN = "****17c2";

    public MailMessenger(){

    }

    @Override
    public void enviarCorreo(String destinatario, String asunto, String contenido) throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttlss.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);

        Session sesion = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASSWORD);
            }
        });

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(USER));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

            mensaje.setSubject(asunto);
            mensaje.setText(contenido);

            Transport.send(mensaje);
        }catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }

        System.out.println("Mensaje enviado Exitosamente");
    }


}















