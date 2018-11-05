package util;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailManager
{
    private static final String HOST         = ConfigurationManager.getInstance().getProperty( "mail.smtp.host",                "smtp.gmail.com" );
    private static final String SOCKET_PORT  = ConfigurationManager.getInstance().getProperty( "mail.smtp.socketFactory.port",  "465" );
    private static final String SOCKET_CLASS = ConfigurationManager.getInstance().getProperty( "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
    private static final String AUTH         = ConfigurationManager.getInstance().getProperty( "mail.smtp.auth",                "true" );
    private static final String PORT         = ConfigurationManager.getInstance().getProperty( "mail.smtp.port",                "465" );
    private static final String USERNAME     = ConfigurationManager.getInstance().getProperty( "mail.username" );
    private static final String PASSWORD     = ConfigurationManager.getInstance().getProperty( "mail.password" );
    
    private static MailManager intance;
    
    public static MailManager getInstance()
    {
        if ( intance == null )
        {
            intance = new MailManager();
        }
        
        return intance;
    }
    
    private String subject;
    private String text;
    private String html;
    private String fileName;
    
    private MailManager()
    {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host",                HOST );
        props.put("mail.smtp.socketFactory.port",  SOCKET_PORT );
        props.put("mail.smtp.socketFactory.class", SOCKET_CLASS);
        props.put("mail.smtp.auth",                AUTH );
        props.put("mail.smtp.port",                PORT );

        session = Session.getDefaultInstance( props, new javax.mail.Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication( USERNAME, PASSWORD );
            }
        } );

        /** Ativa Debug para sessão */
        session.setDebug( true );
    }

    public String getSubject() 
    {
        return subject;
    }

    public void setSubject( String subject ) 
    {
        this.subject = subject;
    }

    public String getText() 
    {
        return text;
    }

    public void setText( String text ) 
    {
        this.text = text;
    }

    public String getHtml() 
    {
        return html;
    }

    public void setHtml( String html ) 
    {
        this.html = html;
    }
    
    public String getFileName() 
    {
        return fileName;
    }

    public void setFileName( String fileName )
    {
        this.fileName = fileName;
    }

    public void sendTo( String recipient ) throws Exception
    {
        if ( recipient == null || recipient.isEmpty() )
        {
            throw new IllegalArgumentException( "Recepients cannot be null" );
        }
        
        Message message = new MimeMessage( session );
        
        MimeBodyPart mbp = new MimeBodyPart();
       
        mbp.setDisposition(Part.ATTACHMENT);
        
        
        message.setFrom( new InternetAddress( USERNAME ) ); 

        Address[] toUser = InternetAddress.parse( recipient );  

        message.setRecipients( Message.RecipientType.TO, toUser );
        
        message.setSubject( subject );//Assunto
        
        if ( html != null )
        {
            message.setContent( html, "text/html; charset=utf-8" );
        }
        
        else if ( text != null )
        {
            message.setText( text );
        }
        
        if ( fileName != null && !fileName.isEmpty() )
        {
            DataSource fds = new FileDataSource(fileName);
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(fds.getName());
            Multipart mp = new MimeMultipart();   
            mp.addBodyPart(mbp);
            message.setContent(mp);
        }
        
        
        new Thread( new Runnable() 
        {
            @Override
            public void run() 
            {
                try
                {
                    /**Método para enviar a mensagem criada*/
                    Transport.send( message );
                }
                
                catch ( Exception e )
                {
//                    ApplicationUtilities.logException( e );
                }
            }
        } ).start();
        
    }
    
    private Session session;
}