package com.twitter.search.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.twitter.search.json.data.TweetDetails;

/**
 * Simple demonstration of using the javax.mail API.
 * 
 * Run from the command line. Please edit the implementation to use correct
 * email addresses and host name.
 */
public final class Emailer 
{
	private static ResourceBundle props = ResourceBundle.getBundle("config");
	private static Properties fMailServerConfig = new Properties();
	StringBuffer sb = new StringBuffer();
	static 
	{
		fetchConfig();
	}

	private final static Logger LOGGER = Logger.getLogger("Emailer");
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static void main(String... aArguments) 
	{
		
	}
	
	/**
	 * Send a single email.
	 */
	public static void sendEmail(List<TweetDetails> list) 
	{
		String aBody = EmailUtil.prepareMailContent(list);
		Session session = Session.getDefaultInstance(fMailServerConfig, null);
		MimeMessage message = new MimeMessage(session);
		try {
			StringTokenizer st = new StringTokenizer(props.getString("mail.to"), ",");
			while (st.hasMoreTokens()) {
				String to = st.nextToken();
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
			}
			message.setFrom(new InternetAddress(props.getString("mail.from")));
			message.setSubject(props.getString("mail.subject"));
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(
					aBody, "text/html")));
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			LOGGER.info("Email sent");
		} catch (MessagingException ex) {
			LOGGER.severe("Cannot send email. " + ex);
		} catch (IOException ex) {
			LOGGER.severe("Cannot send mail." + ex);
		}
	}
	
	
	/**
	 * Allows the config to be refreshed at runtime, instead of requiring a
	 * restart.
	 */
	public static void refreshConfig() {
		fMailServerConfig.clear();
		fetchConfig();
	}

	/**
	 * Open a specific text file containing mail server parameters, and populate
	 * a corresponding Properties object.
	 */
	private static void fetchConfig() 
	{
		InputStream input = null;
		try 
		{
			fMailServerConfig.put("mail.host", props.getString("mail.host"));
			fMailServerConfig.put("mail.transport.protocol",props.getString("mail.transport.protocol"));

		} 
		catch (Exception ex) 
		{
			LOGGER.severe("Cannot open and load mail server properties file.");
		} 
		finally 
		{
			try 
			{
				if (input != null)
					input.close();
			} 
			catch (IOException ex) 
			{
				LOGGER.severe("Cannot close mail server properties file.");
			}
		}
	}
}