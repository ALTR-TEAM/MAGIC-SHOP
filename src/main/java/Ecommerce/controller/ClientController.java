package Ecommerce.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Ecommerce.dao.ClientsImp;
import Ecommerce.model.Clients;

@Controller
public class ClientController {
	@Autowired
	
// Objet de type Client	 , Variable Global
   ClientsImp cltimp;
   
@RequestMapping ("/Client")
public String Client(@RequestParam(name="nom",required=false) String nom,
							@RequestParam(name="prenom",required=false) String prenom ,
							@RequestParam(name="adresse",required=false) String adresse ,
							@RequestParam(name="tel",required=false) String tel ,
							@RequestParam(name="email",required=false) String email ,
							@RequestParam(name="mdp",required=false) String mdp,
							@RequestParam(name="btn",required=false) String btn,
							Model mod,HttpSession session)
	
							{
								if(btn !=null) {if(btn.equals("Inscription")) {   //Pour le Modal Inscription sur la page index
									
					 				// Instance de la classe Clients
									Clients client = new Clients();
									
									//Setter les valeurs des champs de form dans les attribut de l'Entity
									client.setNom(nom);
									client.setPrenom(prenom);
									client.setTel(tel);
									client.setAdresse(adresse);
									client.setEmail(email);
									client.setMdp(mdp);
									
									
								
									
									//On va appeler la fonction Add() de la classe ClientImp
									cltimp.Add(client);
									
									session.setAttribute("user",client.getNom());
									
									mod.addAttribute("nom", nom);
									mod.addAttribute("prenom", prenom);
									mod.addAttribute("adresse", adresse);
									mod.addAttribute("tel", tel);
									mod.addAttribute("email", email);
									mod.addAttribute("mdp", mdp);
									mod.addAttribute("btn", btn);
									
									System.out.println("Vous êtes inscrit");
									return "redirect:/";
									
								}else 
										
								if(btn.equals("Connexion")) {    // Pour le Modal Connexion sur la page index
									
									mod.addAttribute("email", email);
									mod.addAttribute("mdp", mdp);
									mod.addAttribute("btn", btn);
									
									System.out.println("Vous êtes connecté");

									
									Clients sltAuth=cltimp.Auth(email);  // L'Authentification du client avec son mail, si client déjà existant sur la BD ( Pour le Modal de connexion)
									
									if(sltAuth==null) { // Si le mail n'est pas connu de la BD renvoyé un msg d'erreur sur la page d'index
										System.out.println("Email incorrect");  
										
										session.setAttribute("msgErrClient"," L'email " + email+" n'existe pas ");
										return "redirect:/";   
										
									}else { // Si le mail existe 
										session.setAttribute("MailExist", sltAuth.getEmail());
										
										// Verification si l'email de form == email de la table de email trouvé
										
										if(sltAuth.getMdp().equals(mdp)) { // L'Authentification du client avec son mdp, si client déjà existant sur la BD ( Pour le Modal de connexion)
											session.setAttribute("msgErrClient", null);
											
											session.setAttribute("idClients", sltAuth.getId());
											System.out.println("idClients "+sltAuth.getId());
											
											session.setAttribute("client", sltAuth.getNom()+" " +sltAuth.getPrenom());
											return "redirect:/";
											
										}else { // Si le mdp n'est pas le même que sur la BD , qui a été fournis avec un mail existant , renvoyé un msg d'erreur sur la page index
											session.setAttribute("msgErrClient"," Le mot de passe " + mdp +" est invalide pour l'Email "+sltAuth.getEmail());
											return "redirect:/";
										}
									}
									
									
								} 

												
					}return null;
															
															
			}

				
	}