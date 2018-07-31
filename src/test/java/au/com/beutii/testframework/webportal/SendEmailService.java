package au.com.beutii.testframework.webportal;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class SendEmailService {
	private Properties props;
	private static SendEmailService instance;

	private SendEmailService(){
		props = new Properties();
		props.put("mail.smtp.host", "smtp.qiye.aliyun.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
	}

	public synchronized static SendEmailService getInstance(){
		if(instance == null){
			instance = new SendEmailService();
		}
		return instance;
	}

	public void sendNotificationEmail(String to, String from, String msg, String password) {
		//get Session
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
				});
		//compose message
		try {
			MimeMessage message = new MimeMessage(session);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			if(to.contains(";")){
				String[] addresses = to.split(";");
				List<Address> recipients = new ArrayList<>();
				for(String address : addresses){
					recipients.add(new InternetAddress(address));
				}
				message.addRecipients(Message.RecipientType.TO, recipients.toArray(new Address[]{}));
			}else{
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			}
			message.setSubject("Cart added @ " + sdf.format(new Date()));
			message.setText(msg);
			//send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

