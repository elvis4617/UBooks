package elvis.ubooks.user.web.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.cart.domain.Cart;
import elvis.ubooks.user.domain.User;
import elvis.ubooks.user.service.UserException;
import elvis.ubooks.user.service.UserService;

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();

	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		Map<String, String> errors = new HashMap<String, String>();
		String username = form.getUsername();
		if(username == null || username.trim().isEmpty())
			errors.put("username", "username cant be empty");
		else if(username.length() < 3 || username.length() > 10)
			errors.put("username", "username length cant less than 3 or exceed 10");
		
		String password = form.getPassword();
		if(password == null || password.trim().isEmpty())
			errors.put("password", "password cant be empty");
		else if(password.length() < 3 || password.length() > 10)
			errors.put("password", "password length cant less than 3 or exceed 10");
		
		String email = form.getEmail();
		if(email == null || email.trim().isEmpty())
			errors.put("email", "email cant be empty");
		else if(!email.matches("\\w+@\\w+\\.\\w+"))
			errors.put("email", "email format error");
		
		if(!errors.isEmpty()){
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}
		
		form.setUid(CommonUtils.uuid());
		form.setCode(CommonUtils.uuid() + CommonUtils.uuid());
		form.setState(false);
		
		
		try {
			userService.register(form);
			sendMail(form);
			request.setAttribute("msg", "Check email for verification email");
			return "f:/jsps/msg.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp"; 
		} catch (AddressException e) {
			throw new RuntimeException(e);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void sendMail(User form) throws IOException, AddressException, MessagingException{
		Properties email = new Properties();
		email.load(this.getClass().getClassLoader().getResourceAsStream("/email-info.properties"));
		String host = email.getProperty("host");
		String username = email.getProperty("username");
		String password = email.getProperty("password");
		int port = Integer.parseInt(email.getProperty("port"));
		String from = username;
		String subject = email.getProperty("subject");
		String content = email.getProperty("content");
		content = MessageFormat.format(content,form.getCode());
		
		Properties emailProperties = System.getProperties();  
	        emailProperties.put("mail.smtp.port", port);  
	        emailProperties.put("mail.smtp.auth", "true");  
	        emailProperties.put("mail.smtp.starttls.enable", "true");  
	        
		Session mailSession = Session.getDefaultInstance(emailProperties, null);  
		MimeMessage emailMessage = new MimeMessage(mailSession); 
		emailMessage.addRecipient(Message.RecipientType.TO,  
                new InternetAddress(form.getEmail()));  
		
		emailMessage.setSubject(subject);  
        emailMessage.setContent(content, "text/html");
        
        Transport transport = mailSession.getTransport("smtp"); 
        transport.connect(host, from, password);  
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());  
        transport.close();
	}

	public String active(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");
		try {
			userService.active(code);
			request.setAttribute("msg", "Active Successfully");
			return "f:/jsps/msg.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/jsps/msg.jsp";
		}
	}

	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		Map<String, String> errors = new HashMap<String, String>();
		String username = form.getUsername();
		if(username == null || username.trim().isEmpty())
			errors.put("username", "username cant be empty");
		else if(username.length()<3 || username.length() >10)
			errors.put("username", "username length cant be less than 3 or exceed 10");
		
		String password = form.getPassword();
		if(password == null || password.trim().isEmpty())
			errors.put("password", "password cant be empty");
	
		if(!errors.isEmpty()){
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
		try {
			User user = userService.login(form);
			request.getSession().invalidate();
			request.getSession().setAttribute("session_user", user);
			request.getSession().setAttribute("cart", new Cart());
			return "r:/index.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
	}

	public String exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/index.jsp";
		
	}
	
	
	
	
	
	
}
