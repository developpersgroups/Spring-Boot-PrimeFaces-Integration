package net.najiboulhouch.spring.boot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * 
 * @author NAJIB
 * @version 1.0
 * @since 20/12/2018
 */

@Entity
@Table(name="TAB_AUTHORITIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Authority  {
	
	@Id
	@Column(name="NAME")
	String name;
	
	@Column(name="CODE")
	String code;
	
}
