package net.najiboulhouch.spring.boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.najiboulhouch.spring.boot.entities.Authority;


/**
 * 
 * @author NAJIB
 * @version 1.0
 * @since 20/12/2018
 */

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, String> {

}
