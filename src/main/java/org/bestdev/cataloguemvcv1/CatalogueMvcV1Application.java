package org.bestdev.cataloguemvcv1;

import org.bestdev.cataloguemvcv1.dao.ProduitRepository;
import org.bestdev.cataloguemvcv1.dao.UserRepository;
import org.bestdev.cataloguemvcv1.dao.UserRoleRepository;
import org.bestdev.cataloguemvcv1.entities.Produit;
import org.bestdev.cataloguemvcv1.entities.User;
import org.bestdev.cataloguemvcv1.entities.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CatalogueMvcV1Application {
  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

    public static void main(String[] args) {

      ApplicationContext ctx =  SpringApplication.run(CatalogueMvcV1Application.class, args);
      //donne moi un bean qui implemente l'interface
        ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
      PasswordEncoder passwordEncoder = ctx.getBean(PasswordEncoder.class);
      UserRepository userRepository = ctx.getBean(UserRepository.class);

      UserRoleRepository userRoleRepository = ctx.getBean(UserRoleRepository.class);

      userRepository.save(new User(null,"user",passwordEncoder.encode("1234"),true));
      userRepository.save(new User(null,"admin",passwordEncoder.encode("1234"),true));

userRoleRepository.save(new UserRole(null,"user","USER"));
        userRoleRepository.save(new UserRole(null,"admin","ADMIN"));
        userRoleRepository.save(new UserRole(null,"admin","USER"));
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
