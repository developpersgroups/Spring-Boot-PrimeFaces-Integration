package net.najiboulhouch.spring.boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.najiboulhouch.spring.boot.entities.Group;


/**
 * 
 * @author NAJIB
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface GroupeRepository extends CrudRepository<Group, String> {

}
