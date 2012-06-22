/* ============== HelperTools ==============
 * Initial developer: Lukas Diener <lukas.diener@hotmail.com>
 *
 * =====
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE - Version 2
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 * =====
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.
 *
 */
package info.michaelkohler.helpertools.net;

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 

/**
 * |NetHelper| is a helper class for various internet-
 * related actions, such as downloading files and sending
 * e-mails.
 * 
 * @author Lukas Diener
 * @version 0.0.1
 */
public class NetHelper {

    /**
     * Empty Constructor
     */
    public NetHelper() {
    }

    /**
     * Downloads a file from a specified URL
     *
     * @param url URL that points to a resource
     * @param filename the name of the file to store the contents
     * @return error message or empty string for success
     */
    public static String downloadFile(java.net.URL url, String filename) {
    	try {
    		writeToFile(getUrlInputStream(url), filename);
    	} catch (Exception e) {
    		return "error: " + e;
    	}
    	return "";
    }

    /**
     * Downloads a file from a specified URL
     *
     * @param url URL string that points to a resource
     * @param filename the name of the file to store the contents
     * @return error message; an empty string if none
     */
    public static String downloadFile(String url, String filename) {
    	try {
    		downloadFile(new java.net.URL(url), filename);
    	} catch (Exception e) {
    		return "error: " + e;
    	}
    	return "";
    }
    
    /**
     * sendMail sends emails.
     *
     * Borrowed from Slavik Dimitrovich, Richmond, Virginia
     *
     * @param host host address
     * @param from sender address
     * @param to receiver address
     * @param subject message subject
     * @param message message body
     * @throws java.io.MalformedURLException
     * @throws java.io.IOException
     */
    public static void sendMail(String host, String from, String to, String subject, String message)
        throws MalformedURLException, IOException {
      System.getProperties().put("mail.host", host);
      URLConnection connection = new URL("mailto:" + to).openConnection();
      connection.setDoInput(false);
      connection.setDoOutput(true);
      connection.connect();

      PrintWriter out = new PrintWriter(connection.getOutputStream());
      out.println("From: \"" + from + "\" <" + from + ">");
      out.println("To: " + to);
      out.println("Subject: " + subject);
      out.println();
      out.println(message);
      out.close();
    }
    
    public static void sendMail(String smtpServer, String from, String to, String subject, String message, String attachmentFileName) 
        throws MessagingException { 
      DataSource fileDataSource = new FileDataSource( attachmentFileName );
      
      MimeMultipart content = new MimeMultipart(); 
      MimeBodyPart text = new MimeBodyPart(); 
      MimeBodyPart html = new MimeBodyPart();
      BodyPart attachment = new MimeBodyPart();
      
      text.setText( "Text als normaler String" ); 
      text.setHeader( "MIME-Version" , "1.0" ); 
      text.setHeader( "Content-Type" , text.getContentType() ); 
      
      html.setContent( "<html>Text als <b>HTML</b></html>", "text/html"); 
      html.setHeader( "MIME-Version" , "1.0" ); 
      html.setHeader( "Content-Type" , html.getContentType() );
      
      attachment.setDataHandler( new DataHandler(new File(attachmentFileName).getName()) ); 
      attachment.setFileName( dateiname );
      
      content.addBodyPart( text ); 
      content.addBodyPart( html ); 
      content.addBodyPart( attachment );
      
      Properties props = new Properties();
      props.put( "mail.smtp.host", smtpServer ); 
      Session session = Session.getDefaultInstance( props ); 
      
      Message msg = new MimeMessage( session ); 
      InternetAddress addressFrom = new InternetAddress( from ); 
      msg.setFrom( addressFrom ); 
      InternetAddress addressTo = new InternetAddress( recipient ); 
      msg.setRecipient( Message.RecipientType.TO, addressTo ); 
      msg.setSubject( subject ); 
      msg.setContent( content ); 
      msg.setHeader( "MIME-Version" , "1.0" ); 
      msg.setHeader( "Content-Type" , content.getContentType() ); 
      msg.setHeader( "X-Mailer", "Java-Mailer V 1.60217733" ); 
      msg.setSentDate( new Date() );
      Transport.send( msg );
    }
}