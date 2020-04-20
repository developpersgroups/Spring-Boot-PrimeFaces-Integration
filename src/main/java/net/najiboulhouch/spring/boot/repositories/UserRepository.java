package net.najiboulhouch.spring.boot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.najiboulhouch.spring.boot.entities.User;

/**
 * 
 * @author NAJIB
 * @version 1.0
 * @since 20/12/2018
 */

@Repository
public interface UserRepository extends CrudRepository<User , String> {

	public User findByUserName(String name);
	public List<User> findByEnabledFalse();
	
	
}
