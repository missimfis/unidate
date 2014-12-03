package bean;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class provides an E-Mail-Service. It sends Activation E-Mails via the
 * reMind Google Mail Account. The only method visible to 'public' is the method
 * SendActivationEMail that will manage the whole connection opening and closing
 * by itself.
 *
 * While implementing this class, some code snippets were reused from
 * http://www.tutorials.de/content/1177-e-mails-mit-javamail-versenden.html
 * https://www.tutorials.de/threads/email-mit-javamail-versenden.255387/
 *
 * @author missimfis
 */
public final class ActivationEMailService {

    private static Session session = null;
    private static Transport transport = null;

    /**
     * Default constructor for this class.
     */
    private ActivationEMailService() {
    }

    /**
     * Does send an activation e-mail.
     *
     * @param to
     * @param activationLink
     * @return success
     */
    public static boolean sendActivationEMail(String to, String activationLink) {
        boolean success = false;

        // google-mail with TLSv1 and authentication
        String host = "smtp.gmail.com";
        int port = 587;
        String user = "remindremind1@gmail.com";
        String pass = "";

        try {
            // connects to the mail google mail-server
            connectToMailServer(host, port, user, pass);

            // does send the e-mail
            sendEMail(user, to, activationLink);

            success = true;

            // closes the connection to the google mail-server
            closeConnectionToMailServer();
        } catch (NoSuchProviderException e) {
            success = false;
        } catch (AddressException e) {
            success = false;
        } catch (MessagingException e) {
            success = false;
        } catch (Exception e) {
            success = false;
        }
        return success;
    }

    /**
     * This method sends an E-Mail with the given parameters.
     *
     * @param from
     * @param to
     * @param activationLink
     * @throws MessagingException
     * @throws AddressException
     */
    private static void sendEMail(String from, String to,
            String activationLink) throws AddressException, MessagingException {

        // get subject and text from e-mail according to user language
        String messageText = "Guten Tag\n"
                + "Wir freuen uns über Ihre Interesse an unidate.\n"
                + "Um Ihre Registration zu bestätigen klicken Sie bitte auf den folgenden Bestätigungslink.\n"
                +  activationLink+"\n"
                + "Falls die Registration nicht von Ihnen vorgenommen wurde, können Sie diese E-Mail ignorieren.\n"
                + "Freundliche Grüsse\n"
                + "Ihr unidate Team";
        String messageSubject = "Registrationsbestätigungsemail Unidate";

        // create new e-mail and set properties
        Message message = new MimeMessage(session);
        Address[] receiverAddresses = InternetAddress.parse(to);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, receiverAddresses);
        message.setSubject(messageSubject);
        message.setText(messageText);

        // send message
        transport.sendMessage(message, receiverAddresses);

        System.out.println("ACTIVATION EMAIL SERVICE MESSAGE: Activation E-Mail to " + to + " sent successfully.");
    }

    /**
     * This method connects to the mail sever with the given parameters.
     *
     * @param host
     * @param port
     * @param user
     * @param pass
     * @throws NoSuchProviderException
     * @throws MessagingException
     */
    private static void connectToMailServer(String host, int port, String user,
            String pass) throws NoSuchProviderException, MessagingException {
        Properties props = new Properties();

        // activate authentication
        props.put("mail.smtp.auth", "true");

        // SSLv2
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // get Java Mail Session
        session = Session.getDefaultInstance(props);
        transport = session.getTransport("smtp");

        transport.connect(host, port, user, pass);
    }

    /**
     * Does close the connection to e-mail-service.
     *
     * @throws MessagingException
     */
    private static void closeConnectionToMailServer() throws MessagingException {
        transport.close();
    }
}
