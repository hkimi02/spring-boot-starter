package iset.gestion.app.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import iset.gestion.app.dao.*;
import iset.gestion.app.entities.Produit;
@Controller
public class CatController {
@Autowired
ProduitRepository produitRepository;
@Autowired
ClientRepository clientRepository;
 @GetMapping(value = "/")
public String home() { return "pages/produit"; }
@GetMapping(value = "products")
public String index(Model model)
{
return "pages/produit";
}
@GetMapping(value ="/add_produit")
public String add_produit(Model model) {
	Produit p = new Produit();
	model.addAttribute("produit", p);
	return "pages/addProduit";
}
@PostMapping(value ="/addProduit")
public String addProduit(Produit p,Model model) {
	produitRepository.save(p);
	return "redirect:/search";
}
@GetMapping(value="/search")
public String search(Model model,
		 @RequestParam(name="page",defaultValue="0") int page,

		 @RequestParam(name="motCle",defaultValue="") String mc) {


		 Page<Produit> pageProduits =

		produitRepository.findByDesignationContains(mc,PageRequest.of(page,2
		));
		 int pageCount = pageProduits.getTotalPages();
		 int[] pages = new int[pageCount];
		 for(int i=0;i<pageCount;i++)
		 pages[i]=i;
		 model.addAttribute("pages",pages);
		 model.addAttribute("motCle",mc);
		 model.addAttribute("pagecourante",page);
		 model.addAttribute("pageproduits", pageProduits);

		 return "pages/produit";
		 }
		 @GetMapping("/delete")
		 public String delete(String id,int page, String motCle) {
		 produitRepository.deleteById(id);
		 return "redirect:/search?page="+page+"&motCle="+motCle;
		 }
		@SuppressWarnings("deprecation")
		@GetMapping("/update")
		 public String getById(String id,Model model) {
			 Produit p = produitRepository.getById(id);
			 model.addAttribute("produit", p);
			 return "pages/updateProduit";
		 }
		 
}
