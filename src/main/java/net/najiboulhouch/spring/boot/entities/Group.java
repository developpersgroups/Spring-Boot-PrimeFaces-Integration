package net.najiboulhouch.spring.boot.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
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
@Table(name = "TAB_GROUPES")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Group {

	@Id
	@Column(name = "NAME")
	String name;

	@Column(name = "CODE")
    String code;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TAB_GROUPES_AUTHORITIES", joinColumns = { @JoinColumn(name = "GROUPE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "AUTHORITY_ID") })
	Set<Authority> authorities;

	@OneToMany(mappedBy="group")
	List<User> users;

	public Group(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

}
