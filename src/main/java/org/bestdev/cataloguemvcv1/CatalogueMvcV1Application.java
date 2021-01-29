package org.bestdev.cataloguemvcv1;

import org.bestdev.cataloguemvcv1.dao.ProduitRepository;
import org.bestdev.cataloguemvcv1.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CatalogueMvcV1Application {

    public static void main(String[] args) {

      ApplicationContext ctx =  SpringApplication.run(CatalogueMvcV1Application.class, args);
      //donne moi un bean qui implemente l'interface
        ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
        produitRepository.save(new Produit(null,"ordinateur rx",20000,2));
        produitRepository.save(new Produit(null,"smartphone",10000,2));
        produitRepository.save(new Produit(null,"impremente",20000,3));
        produitRepository.save(new Produit(null,"impremente",20000,3));
        produitRepository.save(new Produit(null,"impremente",20000,3));
        produitRepository.save(new Produit(null,"impremente",20000,3));
        produitRepository.save(new Produit(null,"impremente",20000,3));
        produitRepository.save(new Produit(null,"impremente",20000,3));
        produitRepository.save(new Produit(null,"impremente",20000,3));produitRepository.save(new Produit(null,"impremente",20000,3));


        produitRepository.findAll().forEach(produit -> {
            System.out.println(produit);
        });

    }

}
