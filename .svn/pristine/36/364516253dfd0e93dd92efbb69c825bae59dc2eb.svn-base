package com.daweda.webservices.rest;

//import com.daweda.model.entity.Account;
//import com.daweda.model.entity.User;
//import com.daweda.model.entity.UserDetails;
import com.daweda.services.email.EmailUtils;
import com.daweda.services.model.UserCredentials;
//import net.webservicex.GeoIP;
//import net.webservicex.GeoIPService;
//import net.webservicex.GeoIPServiceSoap;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

//@RestController
//@RequestMapping(value = "/registration")
public class RegisterController {
//	@Autowired
//	UserService userService;
//	@Autowired
//	UserDetailsService userDetailsService;
//	@Autowired
//	AccountService accountService;
//	@Autowired
//	TemplateDocumentService templateDocumentService;

	// send email
//	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
//	public @ResponseBody
//    User registerUser(@RequestBody String[] userData,
//			HttpServletRequest request, HttpServletResponse response)
//			throws MyRestException {
//
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods",
//				"POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//		try {
//
//			MutopiaScheduler mutopiaScheduler = ApplicationContextProvider
//					.getContext().getBean("MutopiaScheduler",
//							MutopiaScheduler.class);
//
//			String email = userData[0];
//			String clientCountryCode = userData[1];
//
//			email = email.replace("|", ".");
//
//			// validate email
//			boolean emailValidResult = true;
//			try {
//				InternetAddress emailAddr = new InternetAddress(email);
//				emailAddr.validate();
//			} catch (AddressException ex) {
//				emailValidResult = false;
//				System.out.println("Wrong email");
//				throw new MyRestException(HttpStatus.EXPECTATION_FAILED,
//						"Wrong email");
//			}
//
//			// check if email is present in DB
//			if (userService.findUserByEmail(email) != null) {
//				System.out.println("Such email already exists");
//				throw new MyRestException(HttpStatus.EXPECTATION_FAILED,
//						"Such email already exists");
//			}
//
//			String autopassword = PasswordUtils.generateRandomPassword();
//			String token = email.replace(".", "|");
//
//			// send validation message to user's email
//			sendEmailNotification(request, email, autopassword, token);
//
//			UserDetails ud = new UserDetails();
//			ud.setContactEmail(email);
//			ud.setGeoIp(request.getRemoteAddr());
//			ud.setIp(request.getRemoteAddr());
//			ud.setCountry(clientCountryCode);
//			ud.setCountryCode(mutopiaScheduler.getCountryCodes().get(
//					clientCountryCode.toLowerCase()));
//
//			Account account = new Account();
//			//accountService.create(account);
//			account = generateConfirmationDocuments(account);
//
//			User user = new User(email, true, autopassword, false, token,
//					false, ud, account);
//
//			userService.create(user);
//
//			response.setHeader("MutopiaToken", user.getToken());
//
//			return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (e instanceof MyRestException) {
//				MyRestException m = (MyRestException) e;
//				throw new MyRestException(m.getStatus(), m.getMessage());
//			} else {
//				throw new MyRestException(HttpStatus.EXPECTATION_FAILED,
//						"Registration failed!");
//			}
//		}
//	}

	// on approving email
//	@RequestMapping(value = "/approval", method = RequestMethod.POST, headers = "Accept=application/json")
//	public @ResponseBody UserCredentials getUserFromFrontend(
//			@RequestBody String usertoken, HttpServletRequest request,
//			HttpServletResponse response) throws MyRestException {
//
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods",
//				"POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//
//		System.out.println("userToken is " + usertoken);

		// if the user earlier sent an email to this web service, then
		// henceforth his registration is confirmed
		// and the corresponding DB field 'isActivated' of table
		// EmailPasswordTable is changed to true
//		User user = null;
//		if ((user = userService.findUserByToken(usertoken)) != null) {
//			// EmailPasswordClass emailPasswordClass = new EmailPasswordClass();
//			System.out.println("perfoming activation");
//			boolean activated = true;
//			userService.updateIsActivatedByToken(usertoken, activated);
//			response.setHeader("mytoken", usertoken);

			// return UserCredentials object to frontend to show its content in
			// 'Account' div
//			UserCredentials userCreds = new UserCredentials();
//			userCreds.setUserId((int) user.getId());
//			userCreds.setEmailAddress(user.getEmail());
//			userCreds.setUserAccount(user.getEmail());
//			userCreds.setPassword(user.getPassword());
//			// TODO in future
//			userCreds.setLanguage("English");
//			String ip = request.getRemoteAddr();
//			System.out.println("ip is " + ip);
//			userCreds.setIp(ip);
//			GeoIPService ipService = new GeoIPService();
//			GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
//			GeoIP geoIP = geoIPServiceSoap.getGeoIP(ip);
//			userCreds.setCountryIp(geoIP.getIP()); // geoIP.getCountryName();
//			System.out.println("Country name is " + geoIP.getCountryName());
//			System.out.println("Country ip is " + geoIP.getIP());
//
//			System.out
//					.println("return to user the UserCredentials object and in the response header the token value is set");
//			return userCreds;
//		} else {
//			System.out.println("such token is absent in DB!");
//			throw new MyRestException(HttpStatus.EXPECTATION_FAILED,
//					"you are not registered!");
//		}
//	}

	private String generatePassword(String email) {
		StringBuilder builder = new StringBuilder();
		String symbs = "@!#&";
		Random rand = new Random();
		builder.append(symbs.charAt(rand.nextInt(symbs.length())));
		for (int i = 0; i < email.length(); ++i) {
			if (Character.isAlphabetic(email.charAt(i))) {
				builder.append(((int) email.charAt(i) < 122) ? (char) ((int) email
						.charAt(i) + 1) : email.charAt(i));
			}
		}
		return builder.toString();
	}
	
//	private Account generateConfirmationDocuments(Account account) {
//		List<TemplateDocument> templates = templateDocumentService.findAll();
//		System.out.println(account);
//		for(TemplateDocument t: templates){
//			System.out.println(t);
//			ConfirmationDocument cd = new ConfirmationDocument(t);
//			account.addConfirmationDocument(cd);
//			for(ConfirmationDocument c: account.getConfirmationDocuments()){
//				System.out.println(c);
//			}
//
//		}
//		return account;
//	}
	
//	private void sendEmailNotification(HttpServletRequest request, String email, String autopassword, String token) throws MyRestException{
//		String linkToFollow = "http://" + request.getLocalAddr() + ":"
//				+ request.getLocalPort() + request.getContextPath()
//				+ "/homepage.html" + "?token=" + token;
//
//		try {
//			EmailUtils.sendEmailConfirmationMessage(email, linkToFollow,
//                    autopassword);
//		} catch (MessagingException e) {
//			throw new MyRestException(HttpStatus.INTERNAL_SERVER_ERROR,
//					"Failed to send email!");
//		}
//	}

	// handles exceptions
//	@ExceptionHandler
//	public ResponseEntity<ErrorResource> handle(MyRestException e) {
//		System.out.println("MyRestException!!!");
//		return new ResponseEntity<ErrorResource>(new ErrorResource(
//				e.getStatus(), e.getMessage()), e.getStatus());
//	}
}
