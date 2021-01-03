package booky.tn.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import booky.tn.DAOentities.News;



public interface NewsRepository extends JpaRepository<News, Long> {
	
         List<News> findByCategorie(String categorie);

}
