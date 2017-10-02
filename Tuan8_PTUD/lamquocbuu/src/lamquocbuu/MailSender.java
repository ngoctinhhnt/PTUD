package lamquocbuu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

public class MailSender {

	private JFrame frame;
	private JTextField txtTo;
	private JTextField txtCc;
	private JTextField txtSubject;
	private JTextArea txtrMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailSender window = new MailSender();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MailSender() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTo = new JLabel("CC");
		lblTo.setBounds(6, 36, 61, 16);
		frame.getContentPane().add(lblTo);
		
		txtTo = new JTextField();
		txtTo.setBounds(105, 1, 199, 26);
		frame.getContentPane().add(txtTo);
		txtTo.setColumns(10);
		
		JLabel label = new JLabel("To");
		label.setBounds(6, 6, 61, 16);
		frame.getContentPane().add(label);
		
		txtCc = new JTextField();
		txtCc.setColumns(10);
		txtCc.setBounds(105, 31, 199, 26);
		frame.getContentPane().add(txtCc);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(6, 65, 61, 16);
		frame.getContentPane().add(lblSubject);
		
		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(105, 60, 199, 26);
		frame.getContentPane().add(txtSubject);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(6, 93, 61, 16);
		frame.getContentPane().add(lblMessage);
		
		txtrMessage = new JTextArea();
		txtrMessage.setBackground(SystemColor.window);
		txtrMessage.setText("message");
		txtrMessage.setBounds(105, 94, 339, 145);
		frame.getContentPane().add(txtrMessage);
		
		JButton btnSend = new JButton("Send");
		MailSender instance=this;
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					instance.sendmail();
					JOptionPane.showMessageDialog(null, "Gửi mail thành công");
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSend.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(btnSend);
	}
	
	public void sendmail() throws AddressException, MessagingException
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
				return new PasswordAuthentication("buubaoboi19","buubaoboi");
				
			}
		});
			//Overrid phuong thuc de cung cap thong tin xac thuc cho session nay.De gui email qua SMTP cua gmail can co tai khoan hop le cua google
	
		//Tạo một đoi tuong de chua thong can gui gmail
		Message mess=new MimeMessage(session);
		mess.addRecipient(Message.RecipientType.TO, new InternetAddress(this.txtTo.getText()));
		if(this.txtCc.getText().length()>0)
			mess.addRecipient(Message.RecipientType.CC, new InternetAddress(this.txtCc.getText()));
		mess.setSubject(this.txtSubject.getText());
		
		//Thiet lap nguoi nhan (to,cc) tieu de va noi dung email(noi dung co the su dung html)
		mess.setContent(txtrMessage.getText(),"text/html");
		
		//Gui Gmail
		Transport.send(mess);
	}
}
