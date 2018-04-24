package utilities;

import javax.mail.*;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class EmailUtilities {

    public void ReadEmail(Map<String, String> credentials) {
        Properties properties = new Properties();
        properties.put("mail.debug", "false");
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.imap.port", credentials.get("imapPort"));

        Authenticator auth = new EmailAuthenticator(credentials.get("email"), credentials.get("password"));
        Session session = Session.getDefaultInstance(properties, auth);
        session.setDebug(false);
        try {
            Store store = session.getStore();
            store.connect(credentials.get("imapServer"), credentials.get("email"), credentials.get("password"));

            Folder inbox = store.getFolder("INBOX");

            inbox.open(Folder.READ_ONLY);
            System.out.println("Количество сообщений : " + String.valueOf(inbox.getMessageCount()));
            if (inbox.getMessageCount() == 0) return;

            Message lastMessage = inbox.getMessage(inbox.getMessageCount());
            Multipart mp = (Multipart) lastMessage.getContent();

            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart bp = mp.getBodyPart(i);
                if (bp.getFileName() == null)
                    System.out.println("    " + i + ". сообщение : '" + bp.getContent() + "'");
                else
                    System.out.println("    " + i + ". файл : '" + bp.getFileName() + "'");
            }
            store.close();
        } catch (NoSuchProviderException e) {
            System.err.println(e.getMessage());
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
