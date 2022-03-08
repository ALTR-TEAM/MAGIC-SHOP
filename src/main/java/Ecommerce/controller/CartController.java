package Ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Ecommerce.dao.ProductDao;
import Ecommerce.model.Item;

@Controller
@RequestMapping(value = "cart")
public class CartController {

	//methode qui renvoie la page index
	@RequestMapping(value = "index", method = RequestMethod.GET )
	public String index() {
		return "cart/index";
	}
	
	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") String id, HttpSession session) {
		ProductDao productDao = new ProductDao();
		
		//si le panier est vide
		if (session.getAttribute("cart") == null) {
			//tu me cree une list cart avec la liste des article
			List<Item> cart = new ArrayList<Item>();
			// je peux ajouter un nouvel article avec son id et la quantite 1, grace a la methode add du ProductDao
			cart.add(new Item(productDao.find(id), 1));
			//envoie cet article avec l' attribut "cart", de la liste cart= objet de la list <Item>
			session.setAttribute("cart", cart);
			
		//sinon il y a un article	
		}else {
			//on recupere une list cart de cast  List<Item>, de la session deja existante du panier (il ya deja des produits dans la panier)
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			//on crée qui verifie si this existe avec parametre(id, list cart)
			int index = this.exists(id, cart);
			
				//condition= si index =-1=> a joute moi un nouvel item
			if (index == -1) {
				cart.add(new Item(productDao.find(id), 1));
				
				//sinon index different de -1 = un item exist => calcul la quantité du l'item existant dans la panier (index)
			}else {
				//on definit quantité= 
				int quantity = cart.get(index).getQuantity() +1;
				cart.get(index).setQuantity(quantity);
			}
			
			session.setAttribute("cart", cart);
		}
		return "redirect: /cart/index";
	}
	
	//remove---------------------------------------------------
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id") String id, HttpSession session) {
		ProductDao productDao = new ProductDao();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.exists(id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	
	private int exists(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}
	
}
