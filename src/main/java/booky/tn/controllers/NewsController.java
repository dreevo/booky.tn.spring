package booky.tn.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import booky.tn.DAOentities.News;
import booky.tn.Repositories.NewsRepository;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NewsController {
 
  @Autowired
  NewsRepository NR;
 
 
 
 
  @PutMapping("/news/update/{id}")
  public ResponseEntity<News> updatenews(@PathVariable("id") long id, @RequestBody News news) {
    System.out.println("Update news with ID = " + id + "...");
 
    Optional<News> newsData = NR.findById(id);
 
    if (newsData.isPresent()) {
      News _news = newsData.get();
      _news.setDate(news.getDate());
      _news.setContenu(news.getContenu());
      _news.setTitre(news.getTitre());
      _news.setPhoto(news.getPhoto());
      _news.setFichier(news.getFichier());
     _news.setCategorie(news.getCategorie());
      return new ResponseEntity<>(NR.save(_news), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
