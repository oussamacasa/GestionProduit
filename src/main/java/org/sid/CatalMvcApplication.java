package org.sid;

import java.util.List;

import org.sid.dao.ProduuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalMvcApplication implements CommandLineRunner {
 // Le principe de spring MVC 
	
/* 1-nous avons un client HTTp qui envoie une requete HTTP
 * 2-La requete envoyé il est directement recu par Tomcat (le conteneur web de l'application)
 * 3-Tomcat est configuré pour que les requetes http passent par DispatcherServlet (le controleur frontale)
 * 4-DispatcherServlete il regard l'url de la requete après il regarde le contrileur dont ça se trouve cet url et declancher la methode
 * 5-le controleur concerné appel le metier (le repositroy ) 
 * 6- le repository revoie la réponse au niveau de la bdd après renvoie la list des produit 
 * 7- la liste des données doit etre enregistrer dans ke model (model.addAttribute)
 * 8- une fois les resultats sont enregistrer dans le model on va retourner la vue au dipatcherServelet 
 * 9- ce DespatcherServlette il va faire appel au moteur de template Thymleaf
 * 10- Thymleaf le moteur de template va lire le contenu de la vue.html
 * 11- dans la vue basée sur thymleaf on fait appel implicitement au model (car tout les informations qu'on veut afficher se trouve dans le model) 
 * 12 -  et a la fin ce code generé par thymealf va fornir une reponse en pagehtml au client
 
 */
	@Autowired
	private  ProduuitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalMvcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		produitRepository.save(new Produit(null, "pc 33", 600, 12));
		produitRepository.save(new Produit(null, "catalogue 33", 455, 14));
		produitRepository.save(new Produit(null, "tablette", 33, 17));
		produitRepository.save(new Produit(null, "IPAD", 499, 13));
		produitRepository.findAll().forEach(p-> {
		System.out.println(p.getDescription());
		});
	
	

}
}
