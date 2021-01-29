package org.bestdev.cataloguemvcv1.dao;

import org.bestdev.cataloguemvcv1.entities.Produit;
import org.bestdev.cataloguemvcv1.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

}
