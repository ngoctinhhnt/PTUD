package Mailclient;


import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class mailclient {
	public static void sendmail() throws AddressException, MessagingException
	{
		//Tạo một doi tuong de thiet lap cac thuoc tinh can thiet de gui email voi gmail
		Properties pro = new Properties();
		
		//Thiet lap SMTP Server
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.starttls.enable", "true");
		
		//Thiet lap thuoc tinh ve xac thuc tai khoan
		pro.put("mail.smtp.auth", "true");
		
		//Thiet lap cong cua dich vu tren SMTP Server(Gmail dung cong 465)
		pro.put("mail.smtp.port", "587");
		
		//Thiet lap class danh cho quan ly Socket
		pro.put("mail.smtp.SocketFactory.class", javax.net.ssl.SSLSocketFactory.class.getName());
		
		//Tao mot doi tuong Session de thiet lap phien lam viec voi mail server
		Session session = Session.getDefaultInstance(pro,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("tinnguyen1792017","0973826727");
				
			}
		});
			//Overrid phuong thuc de cung cap thong tin xac thuc cho session nay.De gui email qua SMTP cua gmail can co tai khoan hop le cua google
	
		//Tạo một đoi tuong de chua thong can gui gmail
		Message mess=new MimeMessage(session);
		mess.addRecipient(Message.RecipientType.TO, new InternetAddress("nttin256@gmail.com"));
		//mess.addRecipient(Message.RecipientType.CC, new InternetAddress("ntploan66@gmail.com"));
		mess.setSubject("Test Mail ! >>>"+ new Date());
		String content="Chay thu Email";
		
		//Thiet lap nguoi nhan (to,cc) tieu de va noi dung email(noi dung co the su dung html)
		mess.setContent(content,"text/html");
		
		//Gui Gmail
		Transport.send(mess);
	}
	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
			sendmail();
			System.out.println("Email da gui thanh cong");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			System.out.println("Sending failed");
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("Sending failed");
			e.printStackTrace();
		}
	}

}
