package org.bestdev.cataloguemvcv1.dao;

import org.bestdev.cataloguemvcv1.entities.User;
import org.bestdev.cataloguemvcv1.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

}
