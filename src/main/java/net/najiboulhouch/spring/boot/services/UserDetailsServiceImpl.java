package net.najiboulhouch.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.spring.boot.entities.User;
import net.najiboulhouch.spring.boot.repositories.UserRepository;

/**
 * Allow all users to connect to application trough this class.
 * @author NAJIB
 * @version 1.0
 * @see UserDetailsService
 */

@Service
@Transactional(readOnly=true)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired private UserRepository userRepository ;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		UserDetailsImpl userDetails = null  ;
		if(user != null){
			userDetails  = new UserDetailsImpl(user, user.getGroup().getAuthorities());
			
			if(!userDetails.isEnabled()){
				throw new UsernameNotFoundException("Your account is disabled.");
			}
		}
		else {
			throw new UsernameNotFoundException("The requested user not registered.");
		}
		return userDetails;
	}
}
