package booky.tn.DAOentities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "news")
 public class News {
 


@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 
  @Column(name = "titre")
  private String titre;
 
  @Column(name = "contenu")
  private String contenu;
 
  
  @Column(name = "date")
  private Date date;
 
  @Column(name = "photo")
  private String photo;

  @Column(name = "fichier")
  private String fichier;

@Column(name = "categorie")
  private String categorie;
public News() {}

  public News(String contenu, Date date, String fichier,String photo, String titre, String categorie) {
		
		
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.photo = photo;
		this.fichier = fichier;
                this.categorie = categorie;
	}



public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getContenu() {
	return contenu;
}

public void setContenu(String contenu) {
	this.contenu = contenu;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}

public String getFichier() {
	return fichier;
}

public void setFichier(String fichier) {
	this.fichier = fichier;
}
public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}
@Override
public String toString() {
	return "news [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", date=" + date + ", photo=" + photo
			+ ", fichier=" + fichier + ", categorie=" + categorie + "]";
}
}


