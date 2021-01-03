package booky.tn.Controllers;


import java.util.HashSet;


import java.util.Set;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

import booky.tn.Message.Request.LoginForm;
import booky.tn.Message.Request.SignUpForm;
import booky.tn.Message.Response.JwtResponse;
import booky.tn.Message.Response.ResponseMessage;
import booky.tn.DAOentities.News;
import booky.tn.DAOentities.Role;
import booky.tn.DAOentities.RoleName;
import booky.tn.DAOentities.Customer;
import booky.tn.Repositories.RoleRepository;
import booky.tn.Repositories.NewsRepository;
import booky.tn.Repositories.CustomerRepository;
import booky.tn.Security.JWT.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
  @Autowired
  AuthenticationManager authenticationManager;
  
  @Autowired
  NewsRepository newsRepository;
  @Autowired
  CustomerRepository userRepository;
 
  @Autowired
  RoleRepository roleRepository;
 
  @Autowired
  PasswordEncoder encoder;
 
  @Autowired
  JwtProvider jwtProvider;
 
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
 
    SecurityContextHolder.getContext().setAuthentication(authentication);
 
    String jwt = jwtProvider.generateJwtToken(authentication);
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
  }
 
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
          HttpStatus.BAD_REQUEST);
    }
 
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
          HttpStatus.BAD_REQUEST);
    }
 
    // Creating user's account
    Customer C = new Customer(signUpRequest.getFirstname(), signUpRequest.getLastname(), signUpRequest.getUsername(),signUpRequest.getAge(),
    		signUpRequest.getEmail(), signUpRequest.getAddress(), signUpRequest.getImgURL(), signUpRequest.getPhone(),
              encoder.encode(signUpRequest.getPassword()));
 
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
 
    strRoles.forEach(role -> {
      switch (role) {
      case "admin":
        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(adminRole);
 
        break;
      
      default:
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
      }
    });
 
    C.setRoles(roles);
    userRepository.save(C);
 
    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
  }
  @PostMapping("/news")
  public News post(@RequestBody News news) {
 
    News _news = newsRepository.save(new News(news.getContenu(), news.getDate(), news.getFichier(), news.getPhoto(),news.getTitre(), news.getCategorie()));
    return _news;
  }
 @GetMapping("/news/list")
  public List<News> getAllnews() {
    System.out.println("Get all books...");
 
    List<News> news = new ArrayList<>();
    newsRepository.findAll().forEach(news::add);
 
    return news;
  }
 
 
  @DeleteMapping("/news/del/{id}")
  public ResponseEntity<String> deletenews(@PathVariable("id") long id) {
    System.out.println("Delete the news with ID = " + id + "...");
 
    newsRepository.deleteById(id);
 
    return new ResponseEntity<>("news was deleted!", HttpStatus.OK);
  }
 
 @DeleteMapping("/news/delete")
 public ResponseEntity<String> deleteAllnews() {
   System.out.println("Delete all the news...");

   newsRepository.deleteAll();

   return new ResponseEntity<>("No News, there are all deleted!", HttpStatus.OK);
 }

 @GetMapping(value = "news/{categorie}")
 public List<News> findByCategorie(@PathVariable String categorie) {

   List<News> news = newsRepository.findByCategorie(categorie);
   return news;
 }
 
}
