package net.najiboulhouch.spring.boot.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * 
 * @author NAJIB
 * @version 1.0
 * @since 20/12/2018
 */

@Entity
@Table(name="TAB_USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

	@Column(name="PHONE")
	String phone;
	
	@Column(name="FIRST_NAME")
	String firstName;
	
	@Column(name="LAST_NAME")
	String lastName;
	
	@Column(name="DATE_REGISTRED")
	Date dateRegistred;
	
	@Column(name="TITLE")
	String title;
	
	@Column(name="PASSWORD")
	String password;
	
	@Column(name="ENABLED")
	boolean enabled;
	
	@Column(name="USER_NAME")
	@Id
	String userName;
	
	@ManyToOne
	@JoinColumn(name="GROUPE_ID")
	Group group;
	
}
