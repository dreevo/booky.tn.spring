package tn.booky.corp.controllers;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Exchange;
import tn.booky.corp.services.CommentService;
import tn.booky.corp.services.CustomerService;
import tn.booky.corp.services.ExchangeService;

/**
 * @author Malek
 *
 */
@RestController
@RequestMapping("/rest/exchange")
public class ExchangeController {
	@Autowired
	private ExchangeService exchangeService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CustomerService customerService;

	// CRUD
	@PostMapping("/createExchange")
	public Exchange createExchange(@RequestBody Exchange ex) {
		return exchangeService.createExchange(ex);
	}

	@DeleteMapping("/deleteExchange/{id}")
	public String deleteExchange(@PathVariable int id) {
		return exchangeService.deleteExchange(id);
	}

	@DeleteMapping("/deleteExchanges")
	public String deleteExchanges() {
		return exchangeService.deleteExchanges();
	}

	@GetMapping("/getExchangeByIdReciever/{id}")
	public Exchange getExchangeByIdReciever(@PathVariable int idReciever) {

		return exchangeService.getExchangeByIdReciever(idReciever);

	}

	@GetMapping("/getExchangeByIdGiver/{id}")
	public Exchange getExchangeByIdGiver(@PathVariable int idGiver) {

		return exchangeService.getExchangeByIdGiver(idGiver);

	}

	@GetMapping("/getAllExchanges")
	public List<Exchange> getAllExchanges() {
		return exchangeService.getAllExchanges();
	}

	@PutMapping("/updateExchange")
	public Exchange updateExchange(@RequestBody Exchange ex) {
		return exchangeService.updateExchange(ex);
	}

	// pushed requests

	@GetMapping("/getAllRecievers")
	public List<Customer> getAllRecievers() {
		return exchangeService.getAllRecievers();
	}

	@GetMapping("/getAllGivers")
	public List<Customer> getAllGivers() {
		return exchangeService.getAllGivers();
	}

	@GetMapping("/countOffersOfExchange")
	public int countOffersOfExchange() {
		return exchangeService.countOffersOfExchange();
	}

	@GetMapping("/countFinishedOffersOfExchange")
	public int countFinishedOffersOfExchange() {
		return exchangeService.countFinishedOffersOfExchange();
	}

	@GetMapping("/getPourcentageOfFinishedOffers")
	public String getPourcentageOfFinishedOffers() {
		return exchangeService.getPourcentageOfFinishedOffers();
	}

	// Mailing API
	public void mailling(String mail, String message) {
		final String username = "bookycorp.tn@gmail.com";
		final String password = "esprit123";
		String fromEmail = "bookycorp.tn@gmail.com";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			msg.setSubject("User Verification");
			Multipart emailContent = new MimeMultipart();
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(message);
			emailContent.addBodyPart(textBodyPart);
			msg.setContent(emailContent);
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	// Methods consuming other services
	public void getInfoAboutCustomerGiver() {

		List<Customer> givers = exchangeService.getAllGivers();
		for (Customer giver : givers) {
			if (commentService.getTopFan().equals(giver)) {
				List<Customer> recievers = exchangeService.getAllRecievers();
				for (Customer reciever : recievers) {
					mailling(reciever.getEmail(), "We want to inform that this giver list of givers who are top fans");

				}
			}
		}
	}

	public void getInfoAboutCustomerReciever() {
		List<Customer> recievers = exchangeService.getAllRecievers();
		for (Customer reciever : recievers) {
			if (commentService.getTopFan().equals(reciever)) {
				List<Customer> givers = exchangeService.getAllGivers();
				for (Customer giver : givers) {
					mailling(giver.getEmail(), "We want to inform that this giver list of givers who are top fans");

				}
			}
		}
	}
}
