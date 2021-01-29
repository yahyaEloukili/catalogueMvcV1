package org.bestdev.cataloguemvcv1.web;

import org.bestdev.cataloguemvcv1.dao.ProduitRepository;
import org.bestdev.cataloguemvcv1.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProduitController {

    //spring ioc
    @Autowired
    ProduitRepository produitRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page",defaultValue = "0") int p,@RequestParam(name = "size",defaultValue = "5") int s,
                        @RequestParam(name = "motCle",defaultValue = "") String mc){
        Page<Produit> pageProduits = produitRepository.chercher("%"+mc+"%",PageRequest.of(p,s));
        model.addAttribute("listProduits",pageProduits.getContent());
       int[] pages = new int[pageProduits.getTotalPages()];
       model.addAttribute("pages",pages);
       model.addAttribute("size",s);
       model.addAttribute("currentPage",p);
       model.addAttribute("motCle",mc);
        return "produits";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id")  Long id,@RequestParam(name = "motCle") String motCle,@RequestParam(name = "page") int page,@RequestParam(name = "size") int size){

        Produit produit = produitRepository.findById(id).get();
        produitRepository.delete(produit);
        return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
    }

    @GetMapping("/addProduct")
    public String formProduit(Model model){
        model.addAttribute("produit", new Produit());
        return "formProduit";
    }
    @GetMapping("/edit")
    public String formEditedit(Model model,long id){
        Produit p = produitRepository.findById(id).get();
        model.addAttribute("produit", p);
        return "editProduit";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
@GetMapping("/403")
public String accesdenied(){
        return "403";
    }
    @PostMapping("/save")
    public String save(Model model, @Valid Produit produit, BindingResult  bindingResult){
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.hasErrors());
            return "formProduit";
        }else {

            model.addAttribute("produit", produit);
            produitRepository.save(produit);
            return "confirmation";
        }
    }















}
