package org.sid.web;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.sid.Produit;
import org.sid.dao.ProduuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProduitController {
	
	@Autowired
	private ProduuitRepository produitRepository;  
	//une methode qui va me retourner une vue
	@RequestMapping(value ="/index", method = RequestMethod.GET)
	public String index(Model model, @RequestParam(name="page", defaultValue ="0") int page,
			@RequestParam(name="motCle", defaultValue ="") String mc) { 
		Page<Produit>  produits = produitRepository.findBydescriptionContains(mc,PageRequest.of(page,6)); 
		model.addAttribute("listDesProduits", produits); 
		model.addAttribute("pages", new int[produits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "produits";
	}
	@GetMapping("/delete")

	 public String delete(Long id, int page, String motCle) {
		
		 produitRepository.deleteById(id);
		 
		 return "redirect:/index?page="+page+"&motCle="+motCle;
		 
	 }

	@GetMapping("/getAll")
	 public String getAll(Model model) {
		model.addAttribute("produit",new Produit());
		return "AjouterProduit";
	}
	
	@PostMapping("/save")
	 public String save(Model model, @Valid Produit produit, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "AjouterProduit";
		produitRepository.save(produit);
		return "redirect:/index";
	}
	
	@GetMapping("/edit") 
	public String edit(Model model, Long id) {
		Produit produit = produitRepository.findById(id).get();
		model.addAttribute("produit", produit);
		return "EditProduit";
	}
	@GetMapping("/findById") 
	public String findBy(Model model,  @RequestParam(name="id", defaultValue ="0") Long id) {
		Optional<Produit> produit = produitRepository.findById(id);
		model.addAttribute("produit", produit);
		model.addAttribute("id", id);
		return "produits";
		
		
		
	}
	
}
